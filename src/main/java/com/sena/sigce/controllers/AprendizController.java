package com.sena.sigce.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sena.sigce.model.Caso;
import com.sena.sigce.model.Ficha;
import com.sena.sigce.model.Programa;
import com.sena.sigce.service.IAprendizService;
import com.sena.sigce.service.ICasoService;
import com.sena.sigce.service.IFichaService;
import com.sena.sigce.service.IProgramaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sena.sigce.model.Aprendiz;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/Aprendiz")
public class AprendizController {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private IAprendizService aprendizd;

    @Autowired
    private IFichaService fichad;

    @Autowired
    private IProgramaService programad;


    @Autowired
    private ICasoService casod;


    //Agregar aprendices

    @PostMapping("/registrarAprendices")
     public String registroAp(Model model, Aprendiz aprendiz){
        try{
            aprendizd.save(aprendiz);
        }catch(Exception e){
            model.addAttribute("MensajeError", "Error en el registro del aprendiz.");
        }
        
        return "redirect:/Aprendiz/listarAprendices";
    }

    //Vista registro aprendices
    @GetMapping(value = "/registroAprendiz")
    public String registrar(Model m){
        // //Envía lista de fichas
        List<Ficha> fichas = fichad.findAll();
        m.addAttribute("ficha", fichas);

        return "aprendiz/listarAprendiz";

    }

    //Menu Aprendiz
    @GetMapping(value="/menuAprendiz")
    public String menu( Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Caso> citacionesEncontradas = casod.findByAprendiz(userDetails.getUsername());
        if (!citacionesEncontradas.isEmpty()) {
            model.addAttribute("caso", citacionesEncontradas);
        }
        return "citacion/listarCitacionApr";
    }


    //Registrar Descargos
    @GetMapping(value="/registrarDes")
    public String descargos(@RequestParam("id_Caso") Integer id_Caso,Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Caso citacionesEncontradas = casod.findByDocumento(id_Caso);
        model.addAttribute("caso", citacionesEncontradas);
        model.addAttribute("username", userDetails.getUsername());
        return "aprendiz/registrarDescargos";
    }

    //Agregar descargos
    @PostMapping("/descargosAd")
    public String descargosAd(Caso caso, Aprendiz aprendiz, RedirectAttributes redirectAttributes){
        Optional<Caso> casoExistente = casod.findByAprendizI(caso.getId_Caso());

        System.out.println(caso.getId_Caso());
        System.out.println(caso.getDesc_Cas());
        try{
            if (casoExistente.isPresent()) {
            Caso cas = casoExistente.get();
            cas.setDesc_Cas(caso.getDesc_Cas());
            casod.save(cas);
            redirectAttributes.addFlashAttribute("success", "Sus descargos han sido registrados correctamente");
            return "redirect:/Caso/listarCitacionApr";
            }
        }
        catch(Exception e)
        {
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error, vuelve a intentarlo");
           
        }
         return "redirect:/Caso/listarCitacionApr";
    }

     //Observar descargos
     @GetMapping(value="/descargos")
     public String descargosVer(@RequestParam("id_Caso") Integer id_Caso,Model model){
         UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         Caso citacionesEncontradas = casod.findByDocumento(id_Caso);
         model.addAttribute("caso", citacionesEncontradas);
         model.addAttribute("username", userDetails.getUsername());
         return "aprendiz/observarDescargos";
     }

     //Actualizar Usuario vista
    @GetMapping(value="/actualizarUs")
    public String datosIsn(  Model m, RedirectAttributes redirectAttributes){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        m.addAttribute("aprendiz", aprendizd.findByDocumento(userDetails.getUsername()));
        m.addAttribute("success", "Al actualizar sus datos, deberá también cambiar la contraseña");
        return "aprendiz/actualizarUsuarioApr";
    }

    //ACTUALIZAR usu
    @PostMapping("/actualizarUsu")
    public String actualizar( Model model, Aprendiz aprendiz, RedirectAttributes redirectAttributes) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Aprendiz> aprendizExistente = aprendizd.findById(userDetails.getUsername());

        if (aprendizExistente.isPresent()) {
            Aprendiz apre = aprendizExistente.get();
            apre.setCorreo_Apr(aprendiz.getCorreo_Apr());
            apre.setPassword_Apr(aprendiz.getPassword_Apr());
            aprendizd.save(apre);
            redirectAttributes.addFlashAttribute("success", "La información se ha actualizado correctamente");
            return "redirect:/logout";
        } else {
            // El aprendiz no existe
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error, vuelve a intentarlo");
            return "redirect:/Aprendiz/actualizarUs";
        }
    }


}
