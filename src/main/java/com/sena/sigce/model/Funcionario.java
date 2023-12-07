package com.sena.sigce.model;

import javax.persistence.*;

@Entity
@Table(name="funcionario", uniqueConstraints = @UniqueConstraint(columnNames = "identificacion_Fun"))
public class Funcionario {
     //Atributos

    @Id
    private String identificacion_Fun;

    private boolean isFuncionario = true;

    @Column(name="tipoIde_Fun",nullable = false)
    private String tipoIde_Fun;

    @Column(name="nombre_Fun",nullable = false)
    private String nombre_Fun;

    @Column(name="apellido_Fun",nullable = false)
    private String apellido_Fun;

    @Column(name="correo_Fun",nullable = false)
    private String correo_Fun;

    @Column(name="password_Fun",nullable = false)
    private String password_Fun;

    //Relacionaes

    @ManyToOne
    @JoinColumn(name="FK_id_Estado",nullable = false)
    private Estado estado;


    //Constructores
    public Funcionario() {
    }

    public Funcionario(String identificacion_Fun, boolean isFuncionario, String tipoIde_Fun, String nombre_Fun, String apellido_Fun, String correo_Fun, String password_Fun, Estado estado) {
        this.identificacion_Fun = identificacion_Fun;
        this.isFuncionario = isFuncionario;
        this.tipoIde_Fun = tipoIde_Fun;
        this.nombre_Fun = nombre_Fun;
        this.apellido_Fun = apellido_Fun;
        this.correo_Fun = correo_Fun;
        this.password_Fun = password_Fun;
        this.estado = estado;
    }

    //Getters and Setters


    public String getIdentificacion_Fun() {
        return identificacion_Fun;
    }

    public void setIdentificacion_Fun(String identificacion_Fun) {
        this.identificacion_Fun = identificacion_Fun;
    }

    public boolean isFuncionario() {
        return isFuncionario;
    }

    public void setFuncionario(boolean funcionario) {
        isFuncionario = funcionario;
    }

    public String getTipoIde_Fun() {
        return tipoIde_Fun;
    }

    public void setTipoIde_Fun(String tipoIde_Fun) {
        this.tipoIde_Fun = tipoIde_Fun;
    }

    public String getNombre_Fun() {
        return nombre_Fun;
    }

    public void setNombre_Fun(String nombre_Fun) {
        this.nombre_Fun = nombre_Fun;
    }

    public String getApellido_Fun() {
        return apellido_Fun;
    }

    public void setApellido_Fun(String apellido_Fun) {
        this.apellido_Fun = apellido_Fun;
    }

    public String getCorreo_Fun() {
        return correo_Fun;
    }

    public void setCorreo_Fun(String correo_Fun) {
        this.correo_Fun = correo_Fun;
    }

    public String getPassword_Fun() {
        return password_Fun;
    }

    public void setPassword_Fun(String password_Fun) {
        this.password_Fun = password_Fun;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }



}