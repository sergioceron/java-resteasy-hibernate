package com.dotrow.estudiapp.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by sergio on 05/01/17.
 */
@Entity
@Table( name = "materias" )
public class Materia {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private String nombre;
    private String imagen;

    @OneToMany( fetch = FetchType.LAZY )
    private List<Tema> temas;

    public Materia() {
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre( String nombre ) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen( String imagen ) {
        this.imagen = imagen;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas( List<Tema> temas ) {
        this.temas = temas;
    }
}
