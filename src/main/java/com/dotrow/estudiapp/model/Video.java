package com.dotrow.estudiapp.model;

import javax.persistence.*;

/**
 * Created by sergio on 05/01/17.
 */
@Entity
@Table( name = "videos" )
public class Video {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String titulo;
    private String descripcion;
    private Profesor profesor;
    private Float duracion;
    private Integer status;
    private Materia materia;
    private String imagen;

    @Transient
    private Boolean visto;

    @Transient
    private Boolean favorito;

    @Transient
    private Integer comentarios;

    public Video() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion( String descripcion ) {
        this.descripcion = descripcion;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor( Profesor profesor ) {
        this.profesor = profesor;
    }

    public Float getDuracion() {
        return duracion;
    }

    public void setDuracion( Float duracion ) {
        this.duracion = duracion;
    }

    public Boolean getVisto() {
        return visto;
    }

    public void setVisto( Boolean visto ) {
        this.visto = visto;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen( String imagen ) {
        this.imagen = imagen;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria( Materia materia ) {
        this.materia = materia;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito( Boolean favorito ) {
        this.favorito = favorito;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus( Integer status ) {
        this.status = status;
    }

    public Integer getComentarios() {
        return comentarios;
    }

    public void setComentarios( Integer comentarios ) {
        this.comentarios = comentarios;
    }
}
