package stefanini.aceleradev.api.usuario;

import stefanini.aceleradev.api.usuario.Usuario;

public record DadosDetalhamentoUsuario(Long id, String nome, String dataNascimento, String cpf, String cep) {
    public DadosDetalhamentoUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getDataNascimento(), usuario.getCpf(), usuario.getCep());
    }
}
