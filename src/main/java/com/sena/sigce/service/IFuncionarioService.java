package com.sena.sigce.service;

import java.util.List;
import java.util.Optional;

import com.sena.sigce.model.Funcionario;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IFuncionarioService extends UserDetailsService {
    
     // LISTAR
    List<Funcionario> findAll();

    // REGISTRAR FUNCIONARIO
    Funcionario save (Funcionario funcionario);
    //Listar por identificacion
    Funcionario findByDocumento(String identificacion_Fun);

    //Listar actualizar
    Optional<Funcionario> findById(String identificacion_Fun);


}
