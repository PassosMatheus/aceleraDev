package stefanini.aceleradev.api.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record DadosUsuario(
        Long id,
        @NotBlank
        String nome,
        @NotNull
        LocalDate dataNascimento,
        @NotBlank
        String cpf,
        @NotBlank
        String cep){

}


