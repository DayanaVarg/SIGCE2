package com.sena.sigce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="articulo")
public class Articulo {
    
    @Id
    private Integer id_Aart;

    @Column(name="nombre_Art")
    private String nombre_Art;

    //Constructores
    public Articulo() {
    }

    public Articulo(Integer id_Aart, String nombre_Art) {
        this.id_Aart = id_Aart;
        this.nombre_Art = nombre_Art;
    }

    //Getters and Setters
    public Integer getId_Aart() {
        return id_Aart;
    }

    public void setId_Aart(Integer id_Aart) {
        this.id_Aart = id_Aart;
    }

    public String getNombre_Art() {
        return nombre_Art;
    }

    public void setNombre_Art(String nombre_Art) {
        this.nombre_Art = nombre_Art;
    }

    
}
