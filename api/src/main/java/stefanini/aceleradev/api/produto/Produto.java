package stefanini.aceleradev.api.produto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import stefanini.aceleradev.api.venda.DadosVenda;
import stefanini.aceleradev.api.venda.Venda;

import java.util.List;

@Table(name="produtos")
@Entity(name="produtos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer preco;
    private Integer quantidade;

    @OneToMany(mappedBy = "produto")
    private List<Venda> vendas;

    public Produto(DadosProduto dados) {
        this.nome = dados.nome();
        this.preco = dados.preco();
        this.quantidade = dados.quantidade();
    }

    public Produto(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = getPreco();
        this.quantidade = getPreco();
    }

    public void atualizarDados(DadosAtualizarProduto dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.preco() != null) {
            this.preco = dados.preco();
        }
        if (dados.quantidade() != null) {
            this.quantidade = dados.quantidade();
        }
    }
}