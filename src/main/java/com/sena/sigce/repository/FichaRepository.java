package com.sena.sigce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sena.sigce.model.Ficha;

public interface FichaRepository extends CrudRepository<Ficha, Integer> {

    @Query("SELECT fi FROM Ficha fi WHERE fi.id_Fic = :id_Fic")
    Ficha findByDocumento(Integer id_Fic);

    @Query("SELECT fi FROM Ficha fi WHERE fi.id_Fic = :id_Fic")
    Optional<Ficha> findById(Integer id_Fic);
}
