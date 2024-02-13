package stefanini.aceleradev.api.usuario;

public record DadosListagemUsuario(Long id, String nome, String dataNascimento, String cpf, String cep) {
    public DadosListagemUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getDataNascimento(), usuario.getCpf(), usuario.getCep());
    }
}
