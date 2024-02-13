package stefanini.aceleradev.api.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosProduto(
    @NotBlank
    String nome,
    @NotNull
    Integer preco,
    @NotNull
    Integer quantidade) {
}
