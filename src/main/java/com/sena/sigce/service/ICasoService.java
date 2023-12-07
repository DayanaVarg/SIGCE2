package com.sena.sigce.service;

import java.util.List;
import java.util.Optional;

import com.sena.sigce.model.Caso;

public interface ICasoService {
    
    
    //LISTAR

    List<Caso> findAll();

    //Registrar Citacion
    Caso save (Caso caso);

     //Listar por identificacion
    Caso findByDocumento(Integer idCaso);

    //Listar citacion propias del instructor
    List <Caso> findByInstructor(String idInstructor);

    //Listar citacion propias del aprendiz
    List <Caso> findByAprendiz(String idAprendiz);

    Caso findByAprendizC(String idAprendiz);

    //Listar citacion propias del aprendiz para descargos
    Optional<Caso> findByAprendizI(Integer idCaso);

    //Listar citaciones del comité
    List <Caso> findByCitacion(Integer idCitacion);

}
