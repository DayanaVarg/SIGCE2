package com.sena.sigce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.sigce.model.Caso;
import com.sena.sigce.repository.CasoRepository;

@Service
public class _CasoServiceImpl implements ICasoService{

    @Autowired
    private CasoRepository casoD;

    @Override
    public List<Caso> findAll() {

        return (List<Caso>)casoD.findAll();
    }

    @Override
    public Caso save(Caso caso) {

        return casoD.save(caso);
    }

    @Override
     public Caso findByDocumento(Integer idCaso) {
        return casoD.findByDocumento(idCaso);
    }

    @Override
    public List <Caso> findByInstructor(String idInstructor) {
        return casoD.findByInstructor(idInstructor);
    }

    @Override
    public List<Caso> findByAprendiz(String idAprendiz) {

        return casoD.findByAprendiz(idAprendiz);
    }

    @Override
    public Caso findByAprendizC(String idAprendiz) {
        return casoD.findByAprendizC(idAprendiz);
    }

    @Override
    public Optional<Caso> findByAprendizI(Integer idCaso) {

        return casoD.findByAprendizI(idCaso);
    }

    @Override
    public List<Caso> findByCitacion(Integer idCitacion) {
        return casoD.findByCitacion(idCitacion);
    }

}
