package com.sena.sigce.service;

import com.sena.sigce.model.Articulo;

import java.util.List;

public interface IArticuloService {
    //Listar
    List<Articulo> findAll();
    //Agregar
    Articulo save(Articulo articulo);
}
