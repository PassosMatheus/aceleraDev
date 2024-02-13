package stefanini.aceleradev.api.controler;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import stefanini.aceleradev.api.produto.ProdutoRepository;
import stefanini.aceleradev.api.usuario.UsuarioRepository;
import stefanini.aceleradev.api.venda.DadosDetalhamentoVenda;
import stefanini.aceleradev.api.venda.DadosVenda;
import stefanini.aceleradev.api.venda.Venda;
import stefanini.aceleradev.api.venda.VendaRepository;

import java.util.List;

@RestController
@RequestMapping("/venda")
public class SalesController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private VendaRepository vendaRepository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosVenda dados, UriComponentsBuilder uriBuilder) {
        var venda = new Venda((dados));
        vendaRepository.save(venda);

        var uri = uriBuilder.path("/venda/{id}").buildAndExpand(venda.getId()).toUri();
        return null;
    }
    @GetMapping
    public List<Venda> getAllSales() {
        return vendaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> getSalesById(@PathVariable Long id) {
        Venda sales = vendaRepository.findById(id).orElse(null);
        if (sales != null) {
            return new ResponseEntity<>(sales, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSales(@PathVariable Long id) {
        Venda existingSales = vendaRepository.findById(id).orElse(null);
        if (existingSales != null) {
            vendaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}






