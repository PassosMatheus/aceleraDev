package stefanini.aceleradev.api.produto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public Produto(DadosProduto dados) {
        this.nome = dados.nome();
        this.preco = dados.preco();
        this.quantidade = dados.quantidade();
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