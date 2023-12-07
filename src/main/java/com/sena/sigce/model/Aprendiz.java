package com.sena.sigce.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="aprendiz")
public class Aprendiz {
     //Atributos

    @Id
    private String identificacion_Apr;

    private boolean isAprendiz = true;

    @Column(name="tipoIde_Apr",nullable = false)
    private String tipoIde_Apr;

    @Column(name="nombre_Apr",nullable = false)
    private String nombre_Apr;

    @Column(name="apellido_Apr",nullable = false)
    private String apellido_Apr;

    @Column(name="correo_Apr",nullable = false)
    private String correo_Apr;

    @Column(name="password_Apr",nullable = false)
    private String password_Apr;

    //Relacionaes

    @ManyToOne
    @JoinColumn(name="FK_id_Ficha",nullable = true)
    private Ficha ficha;

    @ManyToOne
    @JoinColumn(name="FK_id_Estado",nullable = false)
    private Estado estado;

    //Constructores
    public Aprendiz() {
    }

   

    //Getters and Setters


    public Aprendiz(String identificacion_Apr, boolean isAprendiz, String tipoIde_Apr, String nombre_Apr, String apellido_Apr, String correo_Apr, String password_Apr, Ficha ficha, Estado estado) {
        this.identificacion_Apr = identificacion_Apr;
        this.isAprendiz = isAprendiz;
        this.tipoIde_Apr = tipoIde_Apr;
        this.nombre_Apr = nombre_Apr;
        this.apellido_Apr = apellido_Apr;
        this.correo_Apr = correo_Apr;
        this.password_Apr = password_Apr;
        this.ficha = ficha;
        this.estado = estado;
    }

    public String getIdentificacion_Apr() {
        return identificacion_Apr;
    }


    public void setIdentificacion_Apr(String identificacion_Apr) {
        this.identificacion_Apr = identificacion_Apr;
    }

    public String getTipoIde_Apr() {
        return tipoIde_Apr;
    }

    public void setTipoIde_Apr(String tipoIde_Apr) {
        this.tipoIde_Apr = tipoIde_Apr;
    }

    public String getNombre_Apr() {
        return nombre_Apr;
    }

    public void setNombre_Apr(String nombre_Apr) {
        this.nombre_Apr = nombre_Apr;
    }

    public String getApellido_Apr() {
        return apellido_Apr;
    }

    public void setApellido_Apr(String apellido_Apr) {
        this.apellido_Apr = apellido_Apr;
    }

    public String getCorreo_Apr() {
        return correo_Apr;
    }

    public void setCorreo_Apr(String correo_Apr) {
        this.correo_Apr = correo_Apr;
    }

    public String getPassword_Apr() {
        return password_Apr;
    }

    public void setPassword_Apr(String password_Apr) {
        this.password_Apr = password_Apr;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean isAprendiz() {
        return isAprendiz;
    }

    public void setAprendiz(boolean aprendiz) {
        isAprendiz = aprendiz;
    }
}