package com.sena.sigce.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sena.sigce.model.Citacion;



public interface CitacionRepository extends CrudRepository<Citacion, Integer>{

    @Query("SELECT c FROM Citacion c WHERE c.idCitacion= :idCitacion")
    Citacion findByDocumento(Integer idCitacion);
    
    @Query("SELECT c FROM Citacion c WHERE c.idCitacion= :idCitacion")
    Optional<Citacion> findById(Integer idCitacion);

    @Query("SELECT COUNT(c)  FROM Citacion c WHERE MONTH(c.fecha_Cit)= :mes")
    long countByMonth(int mes);
}
