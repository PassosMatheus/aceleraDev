package stefanini.aceleradev.api.venda;

import jakarta.validation.constraints.NotBlank;
import stefanini.aceleradev.api.produto.Produto;
import stefanini.aceleradev.api.usuario.Usuario;

import java.time.LocalDate;

public record DadosVenda(
        @NotBlank
        Usuario usuario,
        @NotBlank
        Produto produto,
        @NotBlank
        Integer quantidade,
        LocalDate data_venda) {
}
