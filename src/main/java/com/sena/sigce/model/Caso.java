package com.sena.sigce.model;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="caso")
public class Caso {
    
    //Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id_Caso;
  

    @Column(name="motivo_Cit",nullable = false)
    private String motivo_Cit;

    @Column(name="gravedad_Cit",nullable = false)
    private String gravedad_Cit;

    @Column(name="docu_Cit",nullable = false)
    private String docu_Cit;

    @Column(name="desc_Cas", length = 2000)
    private String desc_Cas;

    @Column(name="comp_Cas")
    private String comp_Cas;

    @Column(name="fecha_Cas")
    private Date fecha_Cas;

    @Column(name="hora_Cas")
    @DateTimeFormat(pattern = "HH:mm")
    private Time hora_Cas;

    //Relaciones

    @ManyToOne
    @JoinColumn(name="FK_id_Tpd")
    private TipoDecision tipoDecision;

    @ManyToOne
    @JoinColumn(name="FK_id_Apr",nullable = false)
    private Aprendiz aprendiz;

    @ManyToOne
    @JoinColumn(name="FK_id_Ins",nullable = false)
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name="Fk_id_Est",nullable = false)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name="Fk_id_Art",nullable = false)
    private Articulo articulo;

    @ManyToOne
    @JoinColumn(name="Fk_id_Res",nullable = false)
    private ResultadoApre resultado;

    @ManyToOne
    @JoinColumn(name="Fk_id_Cit",nullable = true)
    private Citacion citacion;

    public Caso() {
    }

  




    public Caso(Integer id_Caso, String motivo_Cit, String gravedad_Cit, String docu_Cit, String desc_Cas,
            String comp_Cas, Date fecha_Cas, Time hora_Cas, TipoDecision tipoDecision, Aprendiz aprendiz,
            Instructor instructor, Estado estado, Articulo articulo, ResultadoApre resultado, Citacion citacion) {
        this.id_Caso = id_Caso;
        this.motivo_Cit = motivo_Cit;
        this.gravedad_Cit = gravedad_Cit;
        this.docu_Cit = docu_Cit;
        this.desc_Cas = desc_Cas;
        this.comp_Cas = comp_Cas;
        this.fecha_Cas = fecha_Cas;
        this.hora_Cas = hora_Cas;
        this.tipoDecision = tipoDecision;
        this.aprendiz = aprendiz;
        this.instructor = instructor;
        this.estado = estado;
        this.articulo = articulo;
        this.resultado = resultado;
        this.citacion = citacion;
    }






    public Integer getId_Caso() {
        return id_Caso;
    }

    public void setId_Caso(Integer id_Caso) {
        this.id_Caso = id_Caso;
    }

    public String getMotivo_Cit() {
        return motivo_Cit;
    }

    public void setMotivo_Cit(String motivo_Cit) {
        this.motivo_Cit = motivo_Cit;
    }

    public String getGravedad_Cit() {
        return gravedad_Cit;
    }

    public void setGravedad_Cit(String gravedad_Cit) {
        this.gravedad_Cit = gravedad_Cit;
    }


    public String getDocu_Cit() {
        return docu_Cit;
    }

    public void setDocu_Cit(String docu_Cit) {
        this.docu_Cit = docu_Cit;
    }

    public String getDesc_Cas() {
        return desc_Cas;
    }

    public void setDesc_Cas(String desc_Cas) {
        this.desc_Cas = desc_Cas;
    }

    public String getComp_Cas() {
        return comp_Cas;
    }

    public void setComp_Cas(String comp_Cas) {
        this.comp_Cas = comp_Cas;
    }

    

    public Date getFecha_Cas() {
        return fecha_Cas;
    }



    public void setFecha_Cas(Date fecha_Cas) {
        this.fecha_Cas = fecha_Cas;
    }



    public Time getHora_Cas() {
        return hora_Cas;
    }



    public void setHora_Cas(Time hora_Cas) {
        this.hora_Cas = hora_Cas;
    }



    public TipoDecision getTipoDecision() {
        return tipoDecision;
    }

    public void setTipoDecision(TipoDecision tipoDecision) {
        this.tipoDecision = tipoDecision;
    }

    public Aprendiz getAprendiz() {
        return aprendiz;
    }

    public void setAprendiz(Aprendiz aprendiz) {
        this.aprendiz = aprendiz;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public ResultadoApre getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoApre resultado) {
        this.resultado = resultado;
    }

    public Citacion getCitacion() {
        return citacion;
    }

    public void setCitacion(Citacion citacion) {
        this.citacion = citacion;
    }

    
}
