package com.dotrow.estudiapp.model;

import javax.persistence.*;

/**
 * Created by sergio on 05/01/17.
 */
@Entity
@Table( name = "subtemas" )
public class Subtema {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private String titulo;
    private String imagen;

    @Transient
    private Float puntaje;

    @Transient
    private Float avance;

    @Transient
    private Boolean bloqueado;

    @ManyToOne
    private Tema tema;

    public Subtema() {
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo( String titulo ) {
        this.titulo = titulo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen( String imagen ) {
        this.imagen = imagen;
    }

    public Boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado( Boolean bloqueado ) {
        this.bloqueado = bloqueado;
    }

    public Float getPuntaje() {
        return puntaje;
    }

    public void setPuntaje( Float puntaje ) {
        this.puntaje = puntaje;
    }

    public Float getAvance() {
        return avance;
    }

    public void setAvance( Float avance ) {
        this.avance = avance;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema( Tema tema ) {
        this.tema = tema;
    }
}
