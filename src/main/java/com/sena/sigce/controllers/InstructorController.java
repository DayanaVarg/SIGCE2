package com.sena.sigce.controllers;

import ch.qos.logback.classic.Logger;
import com.sena.sigce.model.Aprendiz;
import com.sena.sigce.model.Caso;
import com.sena.sigce.model.Ficha;
import com.sena.sigce.model.Instructor;
import com.sena.sigce.service.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
@RequestMapping("/Instructor")
public class InstructorController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(InstructorController.class);
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private IInstructorService instructord;

    @Autowired
    private ICasoService citaciond;

    @Autowired
    private IArticuloService articulod;


    @Autowired
    private IAprendizService aprendizd;

    @Autowired
    private IFichaService fichad;

    @Autowired
    private IProgramaService programad;
    @Autowired
    private ICasoService casod;


    @PostMapping("/registroInstructor")
    public String registroIns(@ModelAttribute Instructor instructor, Model model){
        System.out.println("Recibido: " + instructor); // Depuración: verifica si los datos del formulario están llegando correctamente

        try {
            instructord.save(instructor);
            model.addAttribute("MensajeExitoso", "Se ha registrado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("MensajeError", "Error en el registro del instructor: " + e.getMessage()); // Muestra detalles del error en la página
        }

        return "index";
    }



    @GetMapping(value="/menuInstructor")
    public String menu(Model model){
        model.addAttribute("citacion", citaciond);
        model.addAttribute("articulo", articulod.findAll());
        List<Ficha> fichas = fichad.findAll();
        model.addAttribute("ficha", fichas);
        return "citacion/registrarCitacion";
    }

    @GetMapping(value="/actualizarIns")
    public String datosApr(@RequestParam("identificacion_Ins") String identificacion_Ins,  Model m){
        m.addAttribute("instructor", instructord.findByDocumento(identificacion_Ins));
        return "instructor/actualizarInstructor";
    }

    @PostMapping("/actualizar")
    public String actualizar(Instructor instructor) {
        Optional<Instructor> instructorExistente = instructord.findById(instructor.getIdentificacion_Ins());

        if (instructorExistente.isPresent()) {
            Instructor ins = instructorExistente.get();
            ins.setCorreo_Ins(instructor.getCorreo_Ins());
            instructord.save(ins);

            return "redirect:/Instructor/listarInstructores";
        } else {
            return "redirect:/Instructor/listarInstructores";
        }
    }

    @PostMapping("/inactivarIns")
    public String inactivarIns(Instructor instructor, RedirectAttributes redirectAttributes) {
        Optional<Instructor> instructorExistente = instructord.findById(instructor.getIdentificacion_Ins());

        if (instructorExistente.isPresent()) {
            Instructor ins = instructorExistente.get();
            ins.setEstado(instructor.getEstado());
            instructord.save(ins);
            redirectAttributes.addFlashAttribute("success", "Se ha inactivado correctamente");
            return "redirect:/Instructor/listarInstructores";
        } else {
            return "redirect:/Instructor/listarInstructores";
        }
    }

    @PostMapping("/activarIns")
    public String activarIns(Instructor instructor, RedirectAttributes redirectAttributes) {
        Optional<Instructor> instructorExistente = instructord.findById(instructor.getIdentificacion_Ins());

        if (instructorExistente.isPresent()) {
            Instructor ins = instructorExistente.get();
            ins.setEstado(instructor.getEstado());
            instructord.save(ins);
            redirectAttributes.addFlashAttribute("success", "Se ha activado correctamente");
            return "redirect:/Instructor/listarInstructores";
        } else {
            return "redirect:/Instructor/listarInstructores";
        }
    }

    @PostMapping(value="/consult")
    public String datosApre( Aprendiz aprendiz, RedirectAttributes redirectAttributes){
        
        Aprendiz aprendizEncontrado = aprendizd.findByDocumento(aprendiz.getIdentificacion_Apr());

        if (aprendizEncontrado != null) {
            redirectAttributes.addFlashAttribute("aprendiz", aprendizEncontrado);
            return "redirect:/Caso/registrarCitacion";
        } else {
            redirectAttributes.addFlashAttribute("error", "Aprendiz no encontrado, por favor regístrelo");
            return "redirect:/Caso/registrar";
        }

    }


    @GetMapping(value="/consultarHistorial")
    public String historialA(Model m){
        return "aprendiz/consultarHistorialIns";
    }

    //Consultar aprendiz

    @PostMapping(value="/consultA")
    public String datosApreH( Aprendiz aprendiz, RedirectAttributes redirectAttributes){

        Aprendiz aprendizEncontrado2 = aprendizd.findByDocumento(aprendiz.getIdentificacion_Apr());
        List<Caso> casoEncontrado = casod.findByAprendiz(aprendiz.getIdentificacion_Apr());

        if (aprendizEncontrado2 != null) {
            redirectAttributes.addFlashAttribute("caso", casoEncontrado);

            redirectAttributes.addFlashAttribute("aprendiz", aprendizEncontrado2);
            return "redirect:/Instructor/consultarHistorial";
        } else {
            redirectAttributes.addFlashAttribute("error", "Aprendiz no encontrado.");
            return "redirect:/Instructor/consultarHistorial";
        }

    }

    //Registrar Aprendiz
    @PostMapping("/registrarAprendices")
    public String registroAp(Model model, Aprendiz aprendiz, RedirectAttributes redirectAttributes){
        try{
            Aprendiz aprendizRegistrado = aprendizd.save(aprendiz);
            redirectAttributes.addFlashAttribute("aprendiz", aprendizRegistrado);
        }catch(Exception e){
            model.addAttribute("MensajeError", "Error en el registro del aprendiz.");
        }

        return "redirect:/Caso/registrarCitacion";
    }

    @GetMapping(value="/actualizarUsu")
    public String datosIsn(  Model m){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        m.addAttribute("success", "Al actualizar sus datos, deberá también cambiar la contraseña");
        m.addAttribute("instructor", instructord.findByDocumento(userDetails.getUsername()));
        return "instructor/actualizarUsuarioIns";
    }

   
    @PostMapping("/actualizarUs")
    public String actualizarUs(Model model, Instructor instructor, RedirectAttributes redirectAttributes) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Instructor> instructorExistente = instructord.findById(userDetails.getUsername());

        if (instructorExistente.isPresent()) {
            Instructor ins = instructorExistente.get();
            ins.setCorreo_Ins(instructor.getCorreo_Ins());
            ins.setPass_Ins(instructor.getPass_Ins());
            instructord.save(ins);
            redirectAttributes.addFlashAttribute("success", "La información se ha actualizado correctamente");
            return "redirect:/logout";
        } else {
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error, vuelve a intentarlo");
            return "redirect:/Instructor/actualizarUsu";
        }
    }
}
