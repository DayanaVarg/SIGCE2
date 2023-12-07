package com.sena.sigce.controllers;


import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sena.sigce.service.IProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.sigce.model.Programa;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/Programa")
public class ProgramaController {
    
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private IProgramaService programad;

     //funcion agregar programa
    @PostMapping("/add")
    public String save(@ModelAttribute("programa") Programa programa, RedirectAttributes redirectAttributes){
        try{
            programad.save(programa);
            redirectAttributes.addFlashAttribute("success", "Se ha registrado exitósamente");
        }catch(Exception e){
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error, vuelve a intentarlo");
        }
        return "redirect:/Programa/listarPrograma";
    }

    //Vista formulario Registrar Programa
    @GetMapping(value="/registrarPrograma")
    public String registrar(Model model){
         Programa programa = new Programa();
         model.addAttribute("program", programad);
         return "Program/registrarPrograma";
    }

     //listar los programas
    @GetMapping(value="/listarPrograma")
    public String listar(Model model){
        model.addAttribute("programas", programad.findAll());
        return "Program/Programa";
    }

    //listar los programas inactivos
    @GetMapping(value="/programasInac")
    public String listarProI(Model model){
        model.addAttribute("programas", programad.findAll());
        return "Program/programasInac";
    }


    //Vista formulario editar 
    @GetMapping(value = "/editar/{id}")
    public String formEditarPrograma(@PathVariable Integer id,Model model){
        model.addAttribute("programa",programad.findByDocumento(id));
        return "Program/programaEditar";
    }

    // Funcion de editar
    @PostMapping("/{id}")
    public String editarPrograma(@PathVariable Integer id, @ModelAttribute("programa") Programa programa, RedirectAttributes redirectAttributes){
        try{
            Programa programaExistente = programad.findByDocumento(id);
            programaExistente.setId_Pro(id);
            programaExistente.setNombre_Pro(programa.getNombre_Pro());
            programaExistente.setEstado(programa.getEstado());
            programad.update(programaExistente);
            redirectAttributes.addFlashAttribute("success", "La información se ha actualizado correctamente");
        }catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error, vuelve a intentarlo");
        }

        return "redirect:/Programa/listarPrograma";
    }
    
    @PostMapping("/inactivarPro")
    public String inactivarPro(Programa programa, RedirectAttributes redirectAttributes) {
        Optional<Programa> pExistente = programad.findById(programa.getId_Pro());
        if (pExistente.isPresent()) {
            Programa programa1 = pExistente.get();
            programa1.setEstado(programa.getEstado());
            programad.save(programa1);
            redirectAttributes.addFlashAttribute("success", "Se ha inactivado correctamente");
            return "redirect:/Programa/listarPrograma";
        } else {

            // El aprendiz no existe
            return "redirect:/Programa/listarPrograma";
        }
    }

    @PostMapping("/activarPro")
    public String activarPro(Programa programa, RedirectAttributes redirectAttributes) {
        Optional<Programa> pExistente = programad.findById(programa.getId_Pro());
        if (pExistente.isPresent()) {
            Programa programa1 = pExistente.get();
            programa1.setEstado(programa.getEstado());
            programad.save(programa1);
            redirectAttributes.addFlashAttribute("success", "Se ha activado correctamente");
            return "redirect:/Programa/listarPrograma";
        } else {

            // El aprendiz no existe
            return "redirect:/Programa/listarPrograma";
        }
    }
}
