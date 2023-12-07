package com.sena.sigce.controllers;

import com.sena.sigce.model.Caso;
import com.sena.sigce.model.Citacion;
import com.sena.sigce.model.Funcionario;
import com.sena.sigce.service.ICasoService;
import com.sena.sigce.service.ICitacionService;
import com.sena.sigce.service.IFuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter.DataWithMediaType;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Citacion")
public class CitacionController {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ICitacionService citaciond;


    @Autowired
    private IFuncionarioService funcionariod;

    @Autowired
    private ICasoService casod;

    //vista formulario
    @GetMapping(value ="/registrarC")
    public String comite(@RequestParam("id_Caso") Integer id_Caso, Model m,  RedirectAttributes redirectAttributes){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         Caso citacionesEncontradas = casod.findByDocumento(id_Caso);
       List <Citacion> comites = citaciond.findAll();
       if(!comites.isEmpty()){
            m.addAttribute("username", userDetails.getUsername());
            m.addAttribute("citacion", comites);
            m.addAttribute("caso", citacionesEncontradas);
             return "citacion/registrarCom";
            
       }
        m.addAttribute("success","Aún no existen comités agendados, por favor agende uno");
        m.addAttribute("caso", citacionesEncontradas);
        m.addAttribute("username", userDetails.getUsername());
         return "comite/registrarNCom";
    }

    
    //vista formulario
    @GetMapping(value ="/elegirC")
    public String comiteS(Model m,  RedirectAttributes redirectAttributes){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       List <Citacion> comites = citaciond.findAll();

            m.addAttribute("username", userDetails.getUsername());
            m.addAttribute("citacion", comites);
             return "citacion/registrarCom";

    }

    @PostMapping("/add")
    public String registrarCom(@RequestParam("id_Caso") Integer id_Caso,Citacion citacion, RedirectAttributes redirectAttributes){

        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Optional<Funcionario> funcionarioEncontrado = funcionariod.findById(userDetails.getUsername());
             Caso citacionesEncontradas = casod.findByDocumento(id_Caso);
            Funcionario fun= funcionarioEncontrado.get();
            citacion.setFun(fun);
            citaciond.save(citacion);
            redirectAttributes.addFlashAttribute("success","Comité agendado con éxito, seleccione el que desea");
            redirectAttributes.addFlashAttribute("caso",citacionesEncontradas);
            return "redirect:/Citacion/elegirC";
        } catch (Exception e){

            redirectAttributes.addFlashAttribute("error","Ha ocurrido un error, inténtalo de nuevo");
            return "redirect:/Citacion/registrarC";
        }
    }

    
    @PostMapping("/addC")
    public String registrarComi(Citacion citacion, RedirectAttributes redirectAttributes){

        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Optional<Funcionario> funcionarioEncontrado = funcionariod.findById(userDetails.getUsername());
            Funcionario fun= funcionarioEncontrado.get();

            LocalDate fechaCitacion = citacion.getFecha_Cit();
            int mesCitacion = fechaCitacion.getMonthValue();

            long citacionesMes = citaciond.countByMonth(mesCitacion);

            if(citacionesMes < 2){
            citacion.setFun(fun);
            citaciond.save(citacion);
            redirectAttributes.addFlashAttribute("success","Comité agendado con éxito.");
            return "redirect:/Citacion/listarComite";
            }else{
                 redirectAttributes.addFlashAttribute("error","Ha llegado al límite de comités en el mes. Seleccione otra fecha");
            return "redirect:/Citacion/listarComite";
            }
        } catch (Exception e){

            redirectAttributes.addFlashAttribute("error","Ha ocurrido un error, inténtalo de nuevo");
            return "redirect:/Citacion/listarComite";
        }
    }


    //Listar
    @GetMapping(value ="/listarComite")
    public String listar(Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("citacion", citaciond.findAll());
        model.addAttribute("username", userDetails.getUsername());
        return "comite/listarComite";
    }

    //LISTAR APRENDICES DEL COMITÉ
    @GetMapping(value = "/aprendicesC/{id}")
    public String listarApe(@PathVariable Integer id, Model model){
        List <Caso> AprendicesComi = casod.findByCitacion(id);
        model.addAttribute("caso",AprendicesComi );
        return "aprendiz/aprendicesCom";
        
    }

    //Vista Actualizar Comité
    @GetMapping(value="/actualizarC")
    public String datosApr(@RequestParam("idCitacion") Integer idCitacion, Model m){
        m.addAttribute("citacion", citaciond.findByDocumento(idCitacion));
        return "comite/actualizaComite";
    }

     //ACTUALIZAR COMITÉ
    @PostMapping("/actualizarCo")
    public String actualizar( Model model, Citacion citacion, RedirectAttributes redirectAttributes) {
        Optional<Citacion> citacionE = citaciond.findById(citacion.getIdCitacion());

        if (citacionE.isPresent()) {
            Citacion citac = citacionE.get();
            citac.setFecha_Cit(citacion.getFecha_Cit());
            citac.setHora_Cit(citacion.getHora_Cit());
            citaciond.save(citac);
            redirectAttributes.addFlashAttribute("success", "Comité actualizado correctamente");
            return "redirect:/Citacion/listarComite";
        } else {
            // El aprendiz no existe
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error, vuelve a intentarlo");
            return "redirect:/Citacion/listarComite";
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
