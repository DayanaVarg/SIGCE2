package com.sena.sigce.service;

import com.sena.sigce.model.Articulo;
import com.sena.sigce.model.TipoDecision;

import java.util.List;

public interface ITpdService {
    //Listar
    List<TipoDecision> findAll();
    //Agregar
    TipoDecision save(TipoDecision tipoDecision);
}
