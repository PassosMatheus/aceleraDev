package stefanini.aceleradev.api.venda;

import stefanini.aceleradev.api.produto.Produto;
import stefanini.aceleradev.api.usuario.Usuario;

public record DadosDetalhamentoVenda(Long id,
                                     Usuario usuario,
                                     Produto produto,
                                     Long quantidade,
                                     String data_venda) {
}
