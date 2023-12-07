package com.sena.sigce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="programa")
public class Programa {

    //Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id_Pro;

    @Column(name="nombre",nullable = false)
    private String nombre_Pro;
     
        //Relaciones
    @ManyToOne
    @JoinColumn(name="Fk_ide_Est",nullable = false)
    private Estado estado;

    //Contructores
    public Programa() {
    }

    public Programa(Integer id_Pro, String nombre_Pro, Estado estado) {
        this.id_Pro = id_Pro;
        this.nombre_Pro = nombre_Pro;
        this.estado = estado;
    }

    //Getters and Setters
    public Integer getId_Pro() {
        return id_Pro;
    }

    public void setId_Pro(Integer id_Pro) {
        this.id_Pro = id_Pro;
    }

    public String getNombre_Pro() {
        return nombre_Pro;
    }

    public void setNombre_Pro(String nombre_Pro) {
        this.nombre_Pro = nombre_Pro;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    
}
