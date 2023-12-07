package com.sena.sigce.model;

import javax.persistence.*;

@Entity
@Table(name = "resultadoApre")
public class ResultadoApre {

    //Atributos (columnas)
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idResultado;

    @Column(name = "nombre_Res")
    private String nombre_Res;

    //Relaciones
    @ManyToOne
    @JoinColumn(name = "FK_id_Com", nullable = false)
    private Competencia competencia;

    //Constructores
    public ResultadoApre() {
    }

    public ResultadoApre(Integer idResultado, String nombre_Res, Competencia competencia) {
        this.idResultado = idResultado;
        this.nombre_Res = nombre_Res;
        this.competencia = competencia;
    }

    //Getters and Setters

    public Integer getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(Integer idResultado) {
        this.idResultado = idResultado;
    }

    public String getNombre_Res() {
        return nombre_Res;
    }

    public void setNombre_Res(String nombre_Res) {
        this.nombre_Res = nombre_Res;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }
}
