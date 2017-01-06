package com.dotrow.estudiapp.model;

import javax.persistence.*;

/**
 * Created by sergio on 06/01/17.
 */
@Entity
@Table( name = "profesores" )
public class Profesor {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private String nombre;
    private String apellidos;
    private Integer edad;
    private String escuela;
    private String materia;
    private Integer puntuacion;

    public Profesor() {
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos( String apellidos ) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad( Integer edad ) {
        this.edad = edad;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela( String escuela ) {
        this.escuela = escuela;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria( String materia ) {
        this.materia = materia;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion( Integer puntuacion ) {
        this.puntuacion = puntuacion;
    }
}
