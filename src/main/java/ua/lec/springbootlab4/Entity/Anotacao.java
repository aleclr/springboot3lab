package ua.lec.springbootlab4.Entity;

import java.time.LocalDateTime;

// import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ant_anotacao")
public class Anotacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ant_id")
    private Long id;

    public Long getId() {
        return id;
    };

    public void setId(Long id) {
        this.id = id;
    };

    @Column(name = "ant_texto")
    private String texto;

    public String getTexto() {
        return texto;
    };

    public void setTexto(String texto) {
        this.texto = texto;
    };
    
    @Column(name = "ant_data_hora")
    private LocalDateTime dataHora;


    public LocalDateTime getDataHora() {
        return dataHora;
    };

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    };

    // colocar a classe inteira como atributo para a chave estrangeira, para manter a programação orientada a objeto
    @ManyToOne
    @JoinColumn(name = "ant_usr_id")
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    };

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    };

}
