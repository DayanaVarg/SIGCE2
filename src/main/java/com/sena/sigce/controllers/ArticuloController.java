package com.sena.sigce.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
@RequestMapping ("/Articulo")
public class ArticuloController {
    @PersistenceContext
    private EntityManager em;

}
