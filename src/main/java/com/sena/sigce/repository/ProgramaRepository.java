package com.sena.sigce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sena.sigce.model.Programa;

public interface ProgramaRepository extends CrudRepository<Programa, Integer> {

    @Query("SELECT p FROM Programa p WHERE p.id_Pro = :id_Pro")
    Programa findByDocumento(Integer id_Pro);

    @Query("SELECT p FROM Programa p WHERE p.id_Pro = :id_Pro")
    Optional<Programa> findById(Integer id_Pro);
}
