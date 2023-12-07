package com.sena.sigce.service;

import com.sena.sigce.model.Citacion;
import com.sena.sigce.repository.CitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class _CitacionServiceImpl implements ICitacionService{

    @Autowired
    private CitacionRepository citacionD;

    @Override
    public List<Citacion> findAll() {

        return (List<Citacion>)citacionD.findAll();
    }

    @Override
    public Citacion save(Citacion citacion) {
        return citacionD.save(citacion);
    }

    @Override
    public Optional<Citacion> findById(Integer idCitacion) {
        return citacionD.findById(idCitacion);
    }

    @Override
    public Citacion findByDocumento(Integer idCitacion) {
        return citacionD.findByDocumento(idCitacion);
    }

    @Override
    public long countByMonth(int mes) {
        return citacionD.countByMonth(mes);
    }

}
