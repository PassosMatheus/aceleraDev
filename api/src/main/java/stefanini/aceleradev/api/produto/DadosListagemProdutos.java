package stefanini.aceleradev.api.produto;

public record DadosListagemProdutos(Long id, String nome, Integer preco, Integer quantidade) {
    public DadosListagemProdutos(Produto produto){
        this(produto.getId(), produto.getNome(), produto.getPreco(), produto.getQuantidade());
    }
}
