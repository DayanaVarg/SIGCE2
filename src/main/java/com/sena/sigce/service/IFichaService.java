package com.sena.sigce.service;

import java.util.List;
import java.util.Optional;

import com.sena.sigce.model.Ficha;

public interface IFichaService {
       
     //LISTA
    List<Ficha>findAll();

    //Registrar
    Ficha save(Ficha ficha);

    //Listar por identificacion
    Ficha findByDocumento(Integer id_Fic);

    //Actualizar
    Ficha update(Ficha ficha);

     //Inactivar
    Optional<Ficha> findById(Integer id_Fic);
    
}
