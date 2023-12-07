package com.sena.sigce.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="citacion")
public class Citacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCitacion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="fecha_Cit")
    private LocalDate fecha_Cit;

    @Column(name="hora_Cit")
     @DateTimeFormat(pattern = "HH:mm")
    private Time hora_Cit;
  

    //Relaciones

    @ManyToOne
    @JoinColumn(name="Fk_id_Est",nullable = false)
    private Estado estado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="FK_id_Fun",nullable = false)
    private Funcionario fun;


    //Constructores
    public Citacion() {
    }




    public Citacion(Integer idCitacion, LocalDate fecha_Cit, Time hora_Cit, Estado estado, Funcionario fun) {
        this.idCitacion = idCitacion;
        this.fecha_Cit = fecha_Cit;
        this.hora_Cit = hora_Cit;
        this.estado = estado;
        this.fun = fun;
    }




    //Getters and Setters
    public Integer getIdCitacion() {
        return idCitacion;
    }


    public void setIdCitacion(Integer idCitacion) {
        this.idCitacion = idCitacion;
    }


    





    public Time getHora_Cit() {
        return hora_Cit;
    }





    public void setHora_Cit(Time hora_Cit) {
        this.hora_Cit = hora_Cit;
    }





    public Estado getEstado() {
        return estado;
    }


    public void setEstado(Estado estado) {
        this.estado = estado;
    }


    public Funcionario getFun() {
        return fun;
    }


    public void setFun(Funcionario fun) {
        this.fun = fun;
    }




    public LocalDate getFecha_Cit() {
        return fecha_Cit;
    }




    public void setFecha_Cit(LocalDate fecha_Cit) {
        this.fecha_Cit = fecha_Cit;
    }

    
}
