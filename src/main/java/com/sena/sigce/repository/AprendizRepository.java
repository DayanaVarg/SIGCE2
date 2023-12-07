package com.sena.sigce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.sena.sigce.model.Aprendiz;



public interface AprendizRepository extends CrudRepository<Aprendiz, String>{
    
    @Query("SELECT a FROM Aprendiz a WHERE a.identificacion_Apr = :identificacion_Apr")
    Aprendiz findByDocumento(String identificacion_Apr);

    @Query("SELECT a FROM Aprendiz a WHERE a.identificacion_Apr = :documento and a.tipoIde_Apr = :tipoDoc and a.password_Apr= :password and FK_id_Ficha = 1 ")
    Aprendiz findValidar(String documento, String tipoDoc, String password);

    @Query("SELECT a FROM Aprendiz a WHERE a.identificacion_Apr = :identificacion_Apr")
    Optional<Aprendiz> findById(String identificacion_Apr);
    
}
