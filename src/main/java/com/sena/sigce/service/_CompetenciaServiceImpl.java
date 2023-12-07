package com.sena.sigce.service;

import com.sena.sigce.model.Competencia;
import com.sena.sigce.repository.CompetenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class _CompetenciaServiceImpl implements ICompetenciaService {


    @Autowired
    private CompetenciaRepository competenciaRepository;

    @Override
    public List<Competencia> findAll() {
        return (List<Competencia>) competenciaRepository.findAll();
    }

    @Override
    public Competencia save(Competencia competencia) {
        return competenciaRepository.save(competencia);
    }

}
