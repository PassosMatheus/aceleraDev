package stefanini.aceleradev.api.venda;

import org.springframework.stereotype.Service;
import stefanini.aceleradev.api.produto.Produto;
import stefanini.aceleradev.api.produto.ProdutoRepository;
import stefanini.aceleradev.api.usuario.Usuario;
import stefanini.aceleradev.api.usuario.UsuarioRepository;

import java.time.LocalDateTime;

@Service
public class VendaService {
    private final VendaRepository vendaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProdutoRepository produtoRepository;

    public VendaService(VendaRepository vendaRepository,
                        UsuarioRepository usuarioRepository,
                        ProdutoRepository produtoRepository) {
        this.vendaRepository = vendaRepository;
        this.usuarioRepository = usuarioRepository;
        this.produtoRepository = produtoRepository;
    }
}
