package stefanini.aceleradev.api.usuario;

import stefanini.aceleradev.api.usuario.Usuario;

import java.time.LocalDate;

public record DadosDetalhamentoUsuario(Long id, String nome, LocalDate dataNascimento, String cpf, String cep) {
    public DadosDetalhamentoUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getDataNascimento(), usuario.getCpf(), usuario.getCep());
    }
}
