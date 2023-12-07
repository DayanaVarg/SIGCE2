package com.sena.sigce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estado")
public class Estado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Est;

    @Column(name="nombre_Est")
    private String nombre_Est;

    //Constrcutores
    public Estado() {
    }

    //Getters and Setters
    public Estado(Integer id_Est, String nombre_Est) {
        this.id_Est = id_Est;
        this.nombre_Est = nombre_Est;
    }

    public Integer getId_Est() {
        return id_Est;
    }

    public void setId_Est(Integer id_Est) {
        this.id_Est = id_Est;
    }

    public String getNombre_Est() {
        return nombre_Est;
    }

    public void setNombre_Est(String nombre_Est) {
        this.nombre_Est = nombre_Est;
    }

    
}