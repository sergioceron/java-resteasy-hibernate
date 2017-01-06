package com.dotrow.estudiapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "attachments" )
public class Attachment implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private String filename;

    public Attachment() {
        this.id = 0l;
        this.filename = "";
    }

    public Attachment( String filename ) {
        this.id = 0l;
        this.filename = filename;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename( String filename ) {
        this.filename = filename;
    }
}
