package ua.lec.springbootlab4.Entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "aut_autorizacao")
public class Autorizacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aut_id")
    private Long id;

    public Long getId() {
        return id;
    };

    public void setId(Long id) {
        this.id = id;
    };

    @Column(name = "aut_nome")
    private String nome;

    public String getNome() {
        return nome;
    };

    public void setNome(String nome) {
        this.nome = nome;
    };

    @ManyToMany(mappedBy = "autorizacoes")
    @JsonIgnore
    private Set<Usuario> usuarios;

    public Set<Usuario> getUsuarios() {
        return usuarios;
    };

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    };

    public Autorizacao() {
        setUsuarios(new HashSet<Usuario>());
    };
}
