package stefanini.aceleradev.api.usuario;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizarUsuario(
        @NotNull
        Long id,
        String nome,
        LocalDate dataNascimento,
        String cpf,
        String cep) {
}
