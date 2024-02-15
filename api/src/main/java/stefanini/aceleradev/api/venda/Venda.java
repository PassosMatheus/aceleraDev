package stefanini.aceleradev.api.venda;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import stefanini.aceleradev.api.produto.Produto;
import stefanini.aceleradev.api.usuario.DadosUsuario;
import stefanini.aceleradev.api.usuario.Usuario;

import java.time.LocalDate;

@Table(name = "vendas")
@Entity
@Getter
@Setter
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantidade;
    private LocalDate data_venda;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Venda(DadosVenda dados) {
        this.usuario = new Usuario(dados.usuario());
        this.produto = new Produto(dados.produto());
        this.data_venda = dados.data_venda();
        this.quantidade = dados.quantidade();
    }
}