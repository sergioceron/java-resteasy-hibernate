package com.dotrow.estudiapp.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sergio on 06/01/17.
 */
@Entity
@Table( name = "videos_comentarios")
public class Comentario {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Video video;

    private String texto;
    private Date fecha;
    private Long likes;
    private Boolean subcomentario;
    private Integer subcomentarios;

    public Comentario() {
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario( Usuario usuario ) {
        this.usuario = usuario;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo( Video video ) {
        this.video = video;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto( String texto ) {
        this.texto = texto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha( Date fecha ) {
        this.fecha = fecha;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes( Long likes ) {
        this.likes = likes;
    }

    public Boolean getSubcomentario() {
        return subcomentario;
    }

    public void setSubcomentario( Boolean subcomentario ) {
        this.subcomentario = subcomentario;
    }

    public Integer getSubcomentarios() {
        return subcomentarios;
    }

    public void setSubcomentarios( Integer subcomentarios ) {
        this.subcomentarios = subcomentarios;
    }
}
