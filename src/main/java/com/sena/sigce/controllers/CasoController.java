package com.sena.sigce.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sena.sigce.model.*;
import com.sena.sigce.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.beans.PropertyEditorSupport;
import java.sql.Time;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/Caso")
public class CasoController {
    
    @PersistenceContext
    private EntityManager em;

   
    @Autowired
    private ICasoService casod;

    @Autowired
    private ICompetenciaService competenciad;

    @Autowired
    private IResultadoService resultadod;

    @Autowired
    private IArticuloService articulod;


    @Autowired
    private IFichaService fichad;

    @Autowired
    private IProgramaService programad;

    @Autowired
    private ITpdService tpdD;

    
    //Vista formulario Registrar Caso
    @GetMapping(value="/registrarCitacion")
    public String registrar(@ModelAttribute("aprendiz") Aprendiz aprendiz, Model model){
        model.addAttribute("caso", casod);

        List<Articulo> articulos = articulod.findAll();
        model.addAttribute("articulo",articulos );

        List<Ficha> fichas = fichad.findAll();
        model.addAttribute("ficha", fichas);

        List<TipoDecision> tipoDecision = tpdD.findAll();
        model.addAttribute("tdp", tipoDecision);

        List<Programa> programa = programad.findAll();
        model.addAttribute("programa", programa);

        model.addAttribute("aprendiz", aprendiz);

        List<Competencia> competencias = competenciad.findAll();
        model.addAttribute("competencia", competencias);

        List<ResultadoApre> resultados = resultadod.findAll();
        model.addAttribute("resultadoApre", resultados);

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("username", userDetails.getUsername());
        return "citacion/registrarCitacion";
    }

    //Agregar citacion
    @PostMapping("/add")
    public String add(Caso caso){
        casod.save(caso);
        return "redirect:/Caso/listarCitacionIns";
    }
    //Formulario
    @GetMapping(value="/registrar")
    public String registrar(Model model){
        List<Articulo> articulos = articulod.findAll();
        model.addAttribute("articulo",articulos );

        List<Competencia> competencias = competenciad.findAll();
        model.addAttribute("competencia", competencias);

        List<ResultadoApre> resultados = resultadod.findAll();
        model.addAttribute("resultadoApre", resultados);

        List<Ficha> fichas = fichad.findAll();
        model.addAttribute("ficha", fichas);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("username", userDetails.getUsername());
        return "citacion/registrarCitacion";
    }


    //Listar
    @GetMapping(value ="/listarCitacion")
    public String listar(Model model){
        List <Caso> citacionesEncontradas = casod.findAll();
        model.addAttribute("caso", citacionesEncontradas);
        return "citacion/listarCitacion";
    }


     //Listar propias
     @GetMapping(value = "/listarCitacionIns")
     public String listarIns(Model model) {
         UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         List<Caso> citacionesEncontradas = casod.findByInstructor(userDetails.getUsername());
         if (!citacionesEncontradas.isEmpty()) {
             model.addAttribute("caso", citacionesEncontradas);
         }
         return "citacion/listarCitacionIns";
     }

    //Listar Caso A
    @GetMapping(value ="/listarCitacionApr")
    public String listarApr(Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Caso> citacionesEncontradas = casod.findByAprendiz(userDetails.getUsername());
        if (!citacionesEncontradas.isEmpty()) {
            model.addAttribute("caso", citacionesEncontradas);
        }
        return "citacion/listarCitacionApr";
    }

    //Agregar citacion al caso

    //Agregar citacion
    @PostMapping("/agendaCom")
    public String agendarC( Caso caso, RedirectAttributes redirectAttributes){
        Optional <Caso> citacionesEncontradas = casod.findByAprendizI(caso.getId_Caso());
        System.out.println(caso.getId_Caso());
        if(citacionesEncontradas.isPresent()){
            Caso cas = citacionesEncontradas.get();
            cas.setCitacion(caso.getCitacion());
            casod.save(cas);
            
            redirectAttributes.addFlashAttribute("success", "Citación agendada con éxito");
            return "redirect:/Funcionario/menuFuncionario";
        } else {
      
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error, vuelve a intentarlo");
            return "redirect:/Funcionario/menuFuncionario";
        }
       
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Time.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(Time.valueOf(text + ":00"));
            }
        });
    }



}
