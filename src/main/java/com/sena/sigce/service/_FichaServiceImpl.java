package com.sena.sigce.service;

import com.sena.sigce.model.Ficha;
import com.sena.sigce.repository.FichaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class _FichaServiceImpl implements IFichaService{
 @Autowired
    private FichaRepository fichaRepository;

    @Override
    public List<Ficha> findAll() {
        return (List<Ficha>) fichaRepository.findAll();
    }

    @Override
    public Ficha save(Ficha ficha) {
        return fichaRepository.save(ficha);
    }

    @Override
    public Ficha findByDocumento(Integer id_Fic) {
        return fichaRepository.findByDocumento(id_Fic);
    }

    @Override
    public Ficha update(Ficha ficha) {
        return fichaRepository.save(ficha);
    }

    @Override
    public Optional<Ficha> findById(Integer id_Fic) {
        return fichaRepository.findById(id_Fic);
    }
}
