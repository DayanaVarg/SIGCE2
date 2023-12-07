package com.sena.sigce.service;

import java.util.List;
import java.util.Optional;

import com.sena.sigce.model.Instructor;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IInstructorService extends UserDetailsService {
    
    // LISTAR
    List<Instructor> findAll();

    // REGISTRAR INSTRUCTOR
    Instructor save (Instructor instructor);

    //Listar por identificacion
    Instructor findByDocumento(String identificacion_Ins);

    //lista Actualizar
    Optional<Instructor> findById(String identificacion_Ins);


}
