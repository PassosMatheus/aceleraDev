package stefanini.aceleradev.api.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stefanini.aceleradev.api.produto.Produto;
import stefanini.aceleradev.api.produto.ProdutoRepository;
import stefanini.aceleradev.api.usuario.Usuario;
import stefanini.aceleradev.api.usuario.UsuarioRepository;
import stefanini.aceleradev.api.venda.DadosVenda;
import stefanini.aceleradev.api.venda.Venda;
import stefanini.aceleradev.api.venda.VendaRepository;

@RestController
@RequestMapping("/vendas")
public class SalesController {
    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public Venda criarVenda(@RequestBody DadosVenda dadosVenda) {
        Usuario usuario = usuarioRepository.findById(dadosVenda.usuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Produto produto = produtoRepository.findById(dadosVenda.produto().getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Venda venda = new Venda(dadosVenda);
        venda.setUsuario(usuario);
        venda.setProduto(produto);
        venda.setData_venda(dadosVenda.data_venda());
        venda.setQuantidade(dadosVenda.quantidade());

        return vendaRepository.save(venda);
    }
}