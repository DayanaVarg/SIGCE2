package com.sena.sigce.service;

import com.sena.sigce.model.Competencia;

import java.util.List;

//Interfaz de Competencia Service (Definición de métodos)
public interface ICompetenciaService {
    
    //Listar

    List<Competencia> findAll();

    //Registrar Competencia

    Competencia save(Competencia competencia);


}
