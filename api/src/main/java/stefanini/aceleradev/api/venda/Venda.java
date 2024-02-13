package stefanini.aceleradev.api.venda;

import jakarta.persistence.*;
import lombok.*;
import stefanini.aceleradev.api.produto.DadosAtualizarProduto;
import stefanini.aceleradev.api.produto.Produto;
import stefanini.aceleradev.api.usuario.Usuario;

import java.util.Timer;

@Table(name="vendas")
@Entity(name="vendas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario user_id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Produto produto_id;
    private Long quantidade;
    private String data_venda;

    public Venda(DadosVenda dados) {
        this.id = dados.id();
        this.quantidade = dados.quantidade();
        this.data_venda = dados.data_venda();
    }

    public void atualizarDados(DadosAtualizarVenda dados) {
        if (dados.id() != null) {
            this.id = dados.id();
        }
        if (dados.quantidade() != null) {
            this.quantidade = dados.quantidade();
        }
        if (dados.data_venda() != null) {
            this.data_venda = dados.data_venda();
        }
    }

    public void setUser(Usuario usuario) {
        this.user_id = user_id;
    }

    public void setProduto(Produto produto) {
        this.produto_id = produto_id;
    }
}

