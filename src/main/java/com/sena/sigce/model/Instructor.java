package com.sena.sigce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="instructor")
public class Instructor {
     //Atributos

    @Id
    private String identificacion_Ins;

    private boolean isInstructor = true;

    @Column(name="tipoIde_Ins",nullable = false)
    private String tipoIde_Ins;

    @Column(name="nombre_Ins",nullable = false)
    private String nombre_Ins;

    @Column(name="apellido_Ins",nullable = false)
    private String apellido_Ins;

    @Column(name="correo_Ins",nullable = false)
    private String correo_Ins;

    @Column(name="pass_Ins",nullable = false)
    private String pass_Ins;

    //Relacionaes

    @ManyToOne
    @JoinColumn(name="FK_id_Estado",nullable = false)
    private Estado estado;

    //Constructores
    public Instructor() {
    }

     public Instructor(String identificacion_Ins, boolean isInstructor, String tipoIde_Ins, String nombre_Ins, String apellido_Ins,
                       String correo_Ins, String pass_Ins, Estado estado) {
        this.identificacion_Ins = identificacion_Ins;
         this.isInstructor = isInstructor;
         this.tipoIde_Ins = tipoIde_Ins;
        this.nombre_Ins = nombre_Ins;
        this.apellido_Ins = apellido_Ins;
        this.correo_Ins = correo_Ins;
        this.pass_Ins = pass_Ins;
        this.estado = estado;
    }

    //Getters and Setters

    public String getIdentificacion_Ins() {
        return identificacion_Ins;
    }

    public void setIdentificacion_Ins(String identificacion_Ins) {
        this.identificacion_Ins = identificacion_Ins;
    }

    public String getTipoIde_Ins() {
        return tipoIde_Ins;
    }

    public void setTipoIde_Ins(String tipoIde_Ins) {
        this.tipoIde_Ins = tipoIde_Ins;
    }

    public String getNombre_Ins() {
        return nombre_Ins;
    }

    public void setNombre_Ins(String nombre_Ins) {
        this.nombre_Ins = nombre_Ins;
    }

    public String getApellido_Ins() {
        return apellido_Ins;
    }

    public void setApellido_Ins(String apellido_Ins) {
        this.apellido_Ins = apellido_Ins;
    }

    public String getCorreo_Ins() {
        return correo_Ins;
    }

    public void setCorreo_Ins(String correo_Ins) {
        this.correo_Ins = correo_Ins;
    }

    public String getPass_Ins() {
        return pass_Ins;
    }

    public void setPass_Ins(String pass_Ins) {
        this.pass_Ins = pass_Ins;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean isInstructor() {
        return isInstructor;
    }

    public void setInstructor(boolean instructor) {
        isInstructor = instructor;
    }
}