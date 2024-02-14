package stefanini.aceleradev.api.usuario;

import java.time.LocalDate;

public record DadosListagemUsuario(Long id, String nome, LocalDate dataNascimento, String cpf, String cep) {
    public DadosListagemUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getDataNascimento(), usuario.getCpf(), usuario.getCep());
    }
}
