package com.sena.sigce.model;

import javax.persistence.*;

@Entity
@Table(name = "competencia")
public class Competencia {

    //Atributos (columnas)
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idCompetencia;

    @Column(name = "nombre_Comp", nullable = false, unique = true)
    private String nombre_Comp;

    //Relaciones
    @ManyToOne
    @JoinColumn(name = "FK_id_Pro", nullable = false)
    private Programa programa;

    //Constructores
    public Competencia() {
    }

    public Competencia(Integer idCompetencia, String nombre_Comp, Programa programa) {
        this.idCompetencia = idCompetencia;
        this.nombre_Comp = nombre_Comp;
        this.programa = programa;
    }

    //Getters and Setters
    public Integer getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(Integer idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    public String getNombre_Comp() {
        return nombre_Comp;
    }

    public void setNombre_Comp(String nombre_Comp) {
        this.nombre_Comp = nombre_Comp;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }
}
