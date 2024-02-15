package stefanini.aceleradev.api.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import stefanini.aceleradev.api.venda.DadosVenda;
import stefanini.aceleradev.api.venda.Venda;

import java.time.LocalDate;
import java.util.List;

@Table(name="usuarios")
@Entity(name="usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    @Column(unique = true)
    private String cpf;
    private String cep;

    @OneToMany(mappedBy = "usuario")
    private List<Venda> vendas;

    public Usuario(DadosUsuario dados) {
        this.id = dados.id();
        this.nome = dados.nome();
        this.dataNascimento = dados.dataNascimento();
        this.cpf = dados.cpf();
        this.cep = dados.cep();
    }

    public Usuario(Usuario dados) {
        this.id = dados.getId();
        this.nome = dados.getNome();
        this.cpf = dados.getCpf();
        this.cep = dados.getCep();
    }

    public void atualizarDados(DadosAtualizarUsuario dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.dataNascimento() != null) {
            this.dataNascimento = dados.dataNascimento();
        }
        if(dados.cpf() != null) {
            this.cpf = dados.cpf();
        }
        if(dados.cep() != null) {
            this.cep = dados.cep();
        }
    }
}
