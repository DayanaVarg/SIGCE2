package com.sena.sigce.model;


import javax.persistence.*;

@Entity
@Table(name="Acta")
public class PDF {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Act;
    @ManyToOne
    @JoinColumn(name="Fk_id_Caso",nullable = false)
    private Caso caso;
    @ManyToOne
    @JoinColumn(name="Fk_id_Citacion",nullable = false)
    private Citacion citacion;

}
