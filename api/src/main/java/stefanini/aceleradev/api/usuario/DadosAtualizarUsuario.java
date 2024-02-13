package stefanini.aceleradev.api.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarUsuario(
        @NotNull
        Long id,
        String nome,
        String dataNascimento,
        String cpf,
        String cep) {
}
