package com.dotrow.estudiapp.model;

import javax.persistence.*;

/**
 * Created by sergio on 05/01/17.
 */
@Entity
@Table( name = "planes" )
public class Plan {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private String name;
    private Float precio;
    private String imagen;
    private String descripcion;

    public Plan() {
        this.name = "";
        this.precio = 0f;
        this.descripcion = "";
        this.imagen = "";
    }

    public Plan( String name, Float precio ) {
        this.name = name;
        this.precio = precio;
        this.descripcion = "";
        this.imagen = "";
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio( Float precio ) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen( String imagen ) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion( String descripcion ) {
        this.descripcion = descripcion;
    }
}
