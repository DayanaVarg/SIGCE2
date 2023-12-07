package com.sena.sigce.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sena.sigce.model.Funcionario;

import java.util.Optional;


public interface FuncionarioRepository extends CrudRepository<Funcionario, String>  {

    @Query("SELECT f FROM Funcionario f WHERE f.identificacion_Fun = :identificacion_Fun")
    Funcionario findByDocumento(String identificacion_Fun);

    @Query("SELECT f FROM Funcionario f WHERE f.identificacion_Fun = :identificacion_Fun")
    Optional<Funcionario> findById(String identificacion_Fun);
}
