package stefanini.aceleradev.api.produto;
public record DadosDetalhamentoProduto(Long id, String nome, Integer preco, Integer quantidade) {
    public DadosDetalhamentoProduto(Produto produto){
        this(produto.getId(), produto.getNome(), produto.getPreco(), produto.getQuantidade());
    }
}
