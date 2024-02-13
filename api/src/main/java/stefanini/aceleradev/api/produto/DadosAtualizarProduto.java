package stefanini.aceleradev.api.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarProduto(
        @NotNull
        Long id,
        String nome,
        Integer preco,
        Integer quantidade
) {
}
