package com.dotrow.estudiapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "users" )
public class Usuario implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private String correo;
    private String nombre;
    private String apellidos;
    private String nickname;
    private Integer edad;
    private String perfil;
    private String escuela;
    private String password;

    public Usuario() {
        this.correo = "";
        this.password = "";
    }

    public Usuario( String correo, String password ) {
        this.correo = correo;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo( String email ) {
        this.correo = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }
}
