package com.sena.sigce.service;

import com.sena.sigce.model.Citacion;

import java.util.List;
import java.util.Optional;

public interface ICitacionService {
    
    
    //LISTAR

    List<Citacion> findAll();

    //Registrar Citacion
    Citacion save (Citacion citacion);

    //Listar citaciones por id
    Optional <Citacion> findById(Integer idCitacion);

    //Listar citaciones por id
     Citacion findByDocumento(Integer idCitacion);
    
     //Contar citaciones por mes
     long countByMonth(int mes);

}
