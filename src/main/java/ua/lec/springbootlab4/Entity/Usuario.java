package ua.lec.springbootlab4.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "usr_usuario")
public class Usuario {
    
    //não usar tipo primitivo, banco precisa aceitar valores nulos
    @Column(name = "usr_id")
    private Long id;

    @Column(name = "usr_nome")
    private String nome;

    @Column(name = "usr_senha")
    private String senha;

}
