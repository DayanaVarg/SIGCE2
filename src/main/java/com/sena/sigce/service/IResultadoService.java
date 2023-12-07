package com.sena.sigce.service;

import com.sena.sigce.model.Programa;
import com.sena.sigce.model.ResultadoApre;

import java.util.List;

//Interfaz de Resultados de Aprendizaje (Definición de métodos)
public interface IResultadoService {
    
    //Listar

    List<ResultadoApre> findAll();

    //Registrar Resultado de Aprendizaje

    ResultadoApre save(ResultadoApre resultadoApre);

}
