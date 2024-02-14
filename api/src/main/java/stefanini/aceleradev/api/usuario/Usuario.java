package stefanini.aceleradev.api.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    @Column(name="dataNascimento")
    private LocalDate dataNascimento;
    @Column(unique = true)
    private String cpf;
    private String cep;

    public Usuario(DadosUsuario dados) {
        this.nome = dados.nome();
        this.dataNascimento = dados.dataNascimento();
        this.cpf = dados.cpf();
        this.cep = dados.cep();
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
