package com.sena.sigce.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sena.sigce.model.Caso;

import java.util.List;
import java.util.Optional;

public interface CasoRepository extends CrudRepository<Caso, Integer> {

    @Query("SELECT c FROM Caso c WHERE c.id_Caso= :idCaso")
    Caso findByDocumento(Integer idCaso);

    @Query("SELECT c FROM Caso c WHERE c.instructor.identificacion_Ins = :idInstructor")
    List<Caso> findByInstructor(String idInstructor);

    @Query("SELECT c FROM Caso c WHERE c.aprendiz.identificacion_Apr = :idAprendiz")
    List<Caso> findByAprendiz(String  idAprendiz);

    @Query("SELECT c FROM Caso c WHERE c.aprendiz.identificacion_Apr = :idAprendiz")
   Caso findByAprendizC(String  idAprendiz);

    @Query("SELECT c FROM Caso c WHERE c.id_Caso = :idCaso")
    Optional<Caso> findByAprendizI(Integer  idCaso);

    @Query("SELECT c FROM Caso c WHERE c.citacion.idCitacion= :idCitacion")
    List <Caso> findByCitacion(Integer idCitacion);



}