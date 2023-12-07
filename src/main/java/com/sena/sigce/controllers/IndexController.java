package com.sena.sigce.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.sigce.model.Aprendiz;
import com.sena.sigce.model.Funcionario;
import com.sena.sigce.model.Instructor;
import com.sena.sigce.service.IAprendizService;
import com.sena.sigce.service.IFuncionarioService;
import com.sena.sigce.service.IInstructorService;

@Controller
@RequestMapping("/")
public class IndexController {

       @PersistenceContext
    private EntityManager em;

    @Autowired
    private IInstructorService instructord;

    @Autowired
    private IAprendizService aprendizd;
    
    @Autowired
    private IFuncionarioService funcionarod;
    
    
    @GetMapping(value = "/login")
    public String index(){
        return "index";
    }

//
}
