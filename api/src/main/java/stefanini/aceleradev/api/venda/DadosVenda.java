package stefanini.aceleradev.api.venda;

import jakarta.validation.constraints.NotNull;
import stefanini.aceleradev.api.produto.Produto;
import stefanini.aceleradev.api.usuario.Usuario;


public record DadosVenda(
        @NotNull
        Long id,
        Usuario user_id,
        Produto produto_id,
        Long quantidade,
        String data_venda
) {
}
