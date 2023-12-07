package com.sena.sigce.service;

import java.util.List;
import java.util.Optional;

import com.sena.sigce.model.Programa;

public interface IProgramaService {
    
    //Listar

    List<Programa> findAll();

    //Registrar Programa

    Programa save(Programa programa);

    //Listar por identificacion
    Programa findByDocumento(Integer id_Pro);

    //Actualizar programa
    Programa update(Programa programa);

    //Inactivar
    Optional<Programa> findById(Integer id_Pro);
}
