package com.sena.sigce.service;


import java.util.List;
import java.util.Optional;

import com.sena.sigce.model.Aprendiz;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAprendizService extends UserDetailsService {

    //Listar
    List<Aprendiz> findAll();

    // REGISTRAR APRENDIZ
    Aprendiz save (Aprendiz aprendiz);

    //Listar por identificacion
     Aprendiz findByDocumento(String identificacion_Apr);

     //Validacion
     Aprendiz findValidar(String documento, String tipoDoc, String password);

    //listar por id (actualizar)
    Optional<Aprendiz> findById(String identificacion_Apr);
}
