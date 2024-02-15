package stefanini.aceleradev.api.controler;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import stefanini.aceleradev.api.produto.*;
import stefanini.aceleradev.api.usuario.Usuario;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProductController {
    @Autowired
    private ProdutoRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosProduto dados, UriComponentsBuilder uriBuilder) {
        var produto = new Produto((dados));
        repository.save(produto);

        var uri = uriBuilder.path("/produto/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoProduto(produto));
    }
    @GetMapping
    public ResponseEntity<List<DadosListagemProdutos>> listar() {
        var produtos = repository.findAll().stream().map(DadosListagemProdutos::new).toList();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemProdutos> listarPorId(@PathVariable Long id) {
        Optional<Produto> optionalProduto = repository.findById(id);
        if (optionalProduto.isPresent()) {
            Produto produto = optionalProduto.get();
            return ResponseEntity.ok(new DadosListagemProdutos(produto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarProduto dados) {
        var produto = repository.getReferenceById(dados.id());
        produto.atualizarDados(dados);

        return ResponseEntity.ok(new DadosDetalhamentoProduto(produto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
