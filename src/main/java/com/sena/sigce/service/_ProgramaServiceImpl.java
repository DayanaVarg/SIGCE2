package com.sena.sigce.service;

import com.sena.sigce.model.Programa;
import com.sena.sigce.repository.ProgramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class _ProgramaServiceImpl implements IProgramaService {


    @Autowired
    private ProgramaRepository programaRepository;

    @Override
    public List<Programa> findAll() {
        return (List<Programa>) programaRepository.findAll() ;
    }

    @Override
    public Programa save(Programa programa) {
        return programaRepository.save(programa);
    }

    @Override
    public Programa findByDocumento(Integer id_Pro) {
        return programaRepository.findByDocumento(id_Pro);
    }

    @Override
    public Programa update(Programa programa) {
       return programaRepository.save(programa);
    }
    @Override
    public Optional<Programa> findById(Integer id_Pro) {
        return programaRepository.findById(id_Pro);
    }
}
