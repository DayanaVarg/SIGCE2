package com.sena.sigce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ficha")
public class Ficha {

    //Atributos

    @Id
    private Integer id_Fic;

    @Column(name="jornada",nullable = false)
    private String jornada_Fic;

    @Column(name="fechaComienzo",nullable = false)
    private String fechaComienzo_Fic;

    @Column(name="fechaFin",nullable = false)
    private String fechaFin_Fic;

    //Relaciones

    @ManyToOne
    @JoinColumn(name="FK_id_Pro",nullable = false)
    private Programa programa;

    @ManyToOne
    @JoinColumn(name="Fk_id_Est",nullable = false)
    private Estado estado;
    
    //CONSTRUCTORES

    public Ficha() {
    }

    public Ficha(Integer id_Fic, String jornada_Fic, String fechaComienzo_Fic, String fechaFin_Fic, Programa programa,
            Estado estado) {
        this.id_Fic = id_Fic;
        this.jornada_Fic = jornada_Fic;
        this.fechaComienzo_Fic = fechaComienzo_Fic;
        this.fechaFin_Fic = fechaFin_Fic;
        this.programa = programa;
        this.estado = estado;
    }

    //Getters and Setters
    public Integer getId_Fic() {
        return id_Fic;
    }

    public void setId_Fic(Integer id_Fic) {
        this.id_Fic = id_Fic;
    }

    public String getJornada_Fic() {
        return jornada_Fic;
    }

    public void setJornada_Fic(String jornada_Fic) {
        this.jornada_Fic = jornada_Fic;
    }

    public String getFechaComienzo_Fic() {
        return fechaComienzo_Fic;
    }

    public void setFechaComienzo_Fic(String fechaComienzo_Fic) {
        this.fechaComienzo_Fic = fechaComienzo_Fic;
    }

    public String getFechaFin_Fic() {
        return fechaFin_Fic;
    }

    public void setFechaFin_Fic(String fechaFin_Fic) {
        this.fechaFin_Fic = fechaFin_Fic;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
  
}
