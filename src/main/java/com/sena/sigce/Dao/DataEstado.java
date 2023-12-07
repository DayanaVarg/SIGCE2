package com.sena.sigce.Dao;

import com.sena.sigce.model.Estado;

import com.sena.sigce.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataEstado implements CommandLineRunner {


    private final EstadoRepository estadoRepository;

    @Autowired
    public DataEstado(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;


    }

    @Override
    public void run(String... args) throws Exception {

        Estado estado = new Estado();
        estado.setId_Est(1);
        estado.setNombre_Est("Activo");

        Estado estado1 = new Estado();
        estado1.setId_Est(2);
        estado1.setNombre_Est("Inactivo");


        estadoRepository.save(estado);
        estadoRepository.save(estado1);
    }
}
