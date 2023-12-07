package com.sena.sigce.service;

import com.sena.sigce.model.Articulo;
import com.sena.sigce.model.TipoDecision;
import com.sena.sigce.repository.ArticuloRepository;
import com.sena.sigce.repository.TpdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class _TpdServiceImpl implements ITpdService{

    @Autowired
    private TpdRepository tpdRepository;

    @Override
    public List<TipoDecision> findAll() {
        return (List<TipoDecision>) tpdRepository.findAll();
    }

    @Override
    public TipoDecision save(TipoDecision tipoDecision) {
        return tpdRepository.save(tipoDecision);
    }


}
