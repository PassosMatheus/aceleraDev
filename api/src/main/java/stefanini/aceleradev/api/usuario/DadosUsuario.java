package stefanini.aceleradev.api.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosUsuario(
        @NotBlank
        String nome,
        @NotBlank
        String dataNascimento,
        @NotBlank
        String cpf,
        @NotBlank
        String cep)
{
}
