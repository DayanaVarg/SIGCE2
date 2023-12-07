package com.sena.sigce.controllers;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import com.sena.sigce.service.IFichaService;
import com.sena.sigce.service.IProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.sigce.model.Ficha;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/Ficha")
public class FichaController {
    
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private IFichaService fichad;

    @Autowired
    private IProgramaService programad;

    //Lista de fichas
    @GetMapping(value = "/listarFicha")
    public String listar(Model model){
        model.addAttribute("Fichax", fichad.findAll());
        model.addAttribute("listPrograma", programad.findAll());
        return "ficha/listarFicha";
    }

    //Lista de fichas inactivas
    @GetMapping(value = "/fichasInac")
    public String listarFiI(Model model){
        model.addAttribute("Fichax", fichad.findAll());
        model.addAttribute("listPrograma", programad.findAll());
        return "ficha/fichasInac";
    }

    //Vista de formulario registrar ficha
    @GetMapping(value = "/registrarFicha")
    public String formRegister(Model model){
        Ficha ficha = new Ficha();
        model.addAttribute("fichaResult", ficha);
        model.addAttribute("listPrograma", programad.findAll());
        return "ficha/registrarFicha";
    }

    //Agregar ficha
    @PostMapping("/add")
    public String save( Ficha ficha, RedirectAttributes redirectAttributes){
        try{
            fichad.save(ficha);
            redirectAttributes.addFlashAttribute("success", "Se ha registrado exitósamente");
        }catch(Exception e){
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error, vuelve a intentarlo");
        }
        return "redirect:/Ficha/listarFicha";
    }

     //Vista formulario editar ficha
    @GetMapping(value = "/editar/{id}")
    public String formEditarFicha(@PathVariable Integer id, Model model){
        model.addAttribute("ficha",fichad.findByDocumento(id));
        model.addAttribute("listPrograma", programad.findAll());
        return "ficha/updateFicha";
    }
    // Funcion de editar
    @PostMapping("/{id}")
    public String editarficha(@PathVariable Integer id, @ModelAttribute("ficha")Ficha ficha, RedirectAttributes redirectAttributes){

        try{
            Ficha fichaEx = fichad.findByDocumento(id);
            fichaEx.setId_Fic(ficha.getId_Fic());
            fichaEx.setFechaComienzo_Fic(ficha.getFechaComienzo_Fic());
            fichaEx.setFechaFin_Fic(ficha.getFechaFin_Fic());
            fichaEx.setJornada_Fic(ficha.getJornada_Fic());
            fichaEx.setEstado(ficha.getEstado());
            fichaEx.setPrograma(ficha.getPrograma());
            fichad.update(fichaEx);
            redirectAttributes.addFlashAttribute("success", "La información se ha actualizado correctamente");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error, vuelve a intentarlo");
        }

        return "redirect:/Ficha/listarFicha";
    }

    
    @PostMapping("/inactivarFic")
    public String inactivarFic(Ficha ficha,  RedirectAttributes redirectAttributes) {
        Optional<Ficha> fExistente = fichad.findById(ficha.getId_Fic());
        
        if (fExistente.isPresent()) {
            Ficha fichas = fExistente.get();
            fichas.setEstado(ficha.getEstado());
            fichad.save(fichas);
            redirectAttributes.addFlashAttribute("success", "Se ha inactivado correctamente");
            return "redirect:/Ficha/listarFicha";
        } else {
           
            return "redirect:/Ficha/listarFicha";
        }
    }

    @PostMapping("/activarFic")
    public String activarFic(Ficha ficha,  RedirectAttributes redirectAttributes) {
        Optional<Ficha> fExistente = fichad.findById(ficha.getId_Fic());

        if (fExistente.isPresent()) {
            Ficha fichas = fExistente.get();
            fichas.setEstado(ficha.getEstado());
            fichad.save(fichas);
            redirectAttributes.addFlashAttribute("success", "Se ha activado correctamente");
            return "redirect:/Ficha/listarFicha";
        } else {

            return "redirect:/Ficha/listarFicha";
        }
    }
    
}
