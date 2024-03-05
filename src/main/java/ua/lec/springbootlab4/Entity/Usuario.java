package ua.lec.springbootlab4.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


//MAPEAMENTO DA TABELA USUARIO
@Entity
@Table(name = "usr_usuario")
public class Usuario {
    
    //não usar tipo primitivo, banco precisa aceitar valores nulos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private Long id;

    @Column(name = "usr_nome")
    @JsonView(Usuario.class)
    private String nome;

    @Column(name = "usr_senha")
    private String senha;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    };

    //spring necessita do construtor vazio também
    public Usuario(){};

    public Long getId() {
        return id;
    };

    public void setId(Long id) {
        this.id = id;
    };

    public String getNome() {
        return nome;
    };

    public void setNome(String nome) {
        this.nome = nome;
    };

    public String getSenha() {
        return senha;
    };

    public void setSenha(String senha) {
        this.senha = senha;
    };

}
