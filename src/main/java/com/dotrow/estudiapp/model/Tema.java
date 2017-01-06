package com.dotrow.estudiapp.model;

import com.sun.tools.javac.util.List;

import javax.persistence.*;

/**
 * Created by sergio on 05/01/17.
 */
@Entity
@Table( name = "temas" )
public class Tema {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private String titulo;

    @OneToMany( fetch = FetchType.LAZY )
    private List<Subtema> subtemas;

    public Tema() {
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

    public List<Subtema> getSubtemas() {
        return subtemas;
    }

    public void setSubtemas( List<Subtema> subtemas ) {
        this.subtemas = subtemas;
    }
}
