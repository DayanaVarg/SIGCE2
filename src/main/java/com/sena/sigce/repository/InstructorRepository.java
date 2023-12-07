package com.sena.sigce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.sena.sigce.model.Instructor;

public interface InstructorRepository extends CrudRepository<Instructor, String> {

    @Query("SELECT i FROM Instructor i WHERE i.identificacion_Ins = :identificacion_Ins")
    Instructor findByDocumento(String identificacion_Ins);

    @Query("SELECT i FROM Instructor i WHERE i.identificacion_Ins = :identificacion_Ins")
    Optional<Instructor> findById(String identificacion_Ins);
}
