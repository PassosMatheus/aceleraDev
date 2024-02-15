package stefanini.aceleradev.api.venda;

import stefanini.aceleradev.api.produto.Produto;
import stefanini.aceleradev.api.usuario.Usuario;

import java.time.LocalDate;

public record DadosDetalhamentoVenda(Long id, Usuario usuario, Produto produto, Integer quantidade, LocalDate data_venda) {
    public DadosDetalhamentoVenda(Venda venda){
        this(venda.getId(), venda.getUsuario(), venda.getProduto(), venda.getQuantidade(), venda.getData_venda());
    }
}
