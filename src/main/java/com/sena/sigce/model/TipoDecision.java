package com.sena.sigce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="tipoDecision")
public class TipoDecision {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_Tpd;

    @Column(name="nombre_Tpd" ,nullable = false)
    private String nombre_Tpd;

    @Column(name="descripcion_Tpd" ,nullable = false)
    private String descripcion_Tpd;

    //Constructores


    public TipoDecision() {
    }

    public TipoDecision(Integer id_Tpd, String nombre_Tpd, String descripcion_Tpd) {
        this.id_Tpd = id_Tpd;
        this.nombre_Tpd = nombre_Tpd;
        this.descripcion_Tpd = descripcion_Tpd;
    }

    //Getters and Setters
    public Integer getId_Tpd() {
        return id_Tpd;
    }

    public void setId_Tpd(Integer id_Tpd) {
        this.id_Tpd = id_Tpd;
    }

    public String getNombre_Tpd() {
        return nombre_Tpd;
    }

    public void setNombre_Tpd(String nombre_Tpd) {
        this.nombre_Tpd = nombre_Tpd;
    }

    public String getDescripcion_Tpd() {
        return descripcion_Tpd;
    }

    public void setDescripcion_Tpd(String descripcion_Tpd) {
        this.descripcion_Tpd = descripcion_Tpd;
    }
}
