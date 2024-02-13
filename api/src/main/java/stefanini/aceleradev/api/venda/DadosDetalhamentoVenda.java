package stefanini.aceleradev.api.venda;

import stefanini.aceleradev.api.produto.Produto;
import stefanini.aceleradev.api.usuario.Usuario;

public record DadosDetalhamentoVenda(Long id, Usuario user_id, Produto produto_id, Long quantidade, String data_venda) {
    public DadosDetalhamentoVenda(Venda venda) {
                this(venda.getId(), venda.getUser_id(), venda.getProduto_id(), venda.getQuantidade(), venda.getData_venda());
    }
}
