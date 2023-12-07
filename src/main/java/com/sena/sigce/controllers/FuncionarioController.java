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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/Funcionario")
public class FuncionarioController {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private IFuncionarioService funcionariod;

    @Autowired
    private IInstructorService instructord;

    @Autowired
    private IAprendizService aprendizd;

    @Autowired
    private IFichaService fichad;

    @Autowired
    private IProgramaService programad;


    @Autowired
    private ICasoService casod;
   

    @GetMapping(value="/menuFuncionario")
    public String menu(Model model){
        List <Caso> citacionesEncontradas = casod.findAll();
        model.addAttribute("caso", citacionesEncontradas);
        return "citacion/listarCitacion";
    }

    //Vista registro aprendices
    @GetMapping(value = "/registroAprendiz")
    public String registrar(Model m){
        // //Envía lista de fichas
        List<Ficha> fichas = fichad.findAll();
        m.addAttribute("ficha", fichas);

        return "aprendiz/listarAprendiz";

    }

    //Agregar aprendices

    @PostMapping("/registrarAprendices")
    public String registroAp( Aprendiz aprendiz, RedirectAttributes redirectAttributes){
        try{
            aprendizd.save(aprendiz);
            redirectAttributes.addFlashAttribute("success", "Se ha registrado exitósamente");
        }catch(Exception e){
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error, vuelve a intentarlo");
        }

        return "redirect:/Funcionario/listarAprendices";
    }



    //Listar aprendices
    @GetMapping(value="/listarAprendices")
    public String listarAp(Model m){
        m.addAttribute("aprendiz", aprendizd.findAll());

        List<Ficha> fichas = fichad.findAll();
        m.addAttribute("ficha", fichas);
        List<Programa> programa = programad.findAll();
        m.addAttribute("programa", programa);
        return "aprendiz/listarAprendiz";
    }

   
    //Listar aprendices inactivos
    @GetMapping(value="/aprendicesInac")
    public String listarApI(Model m){
        m.addAttribute("aprendiz", aprendizd.findAll());

        List<Ficha> fichas = fichad.findAll();
        m.addAttribute("ficha", fichas);
        List<Programa> programa = programad.findAll();
        m.addAttribute("programa", programa);
        return "aprendiz/aprendicesInactivos";
    }

    //vista actualizar

    @GetMapping(value="/actualizarApr")
    public String datosApr(@RequestParam("identificacion_Apr") String identificacion_Apr, Model m){
        m.addAttribute("aprendiz", aprendizd.findByDocumento(identificacion_Apr));
        List<Ficha> fichas = fichad.findAll();
        m.addAttribute("ficha", fichas);
        List<Programa> programa = programad.findAll();
        m.addAttribute("programa", programa);
        return "aprendiz/actualizarAprendiz";
    }

    //ACTUALIZAR APRENDIZ
    @PostMapping("/actualizarA")
    public String actualizar( Model model, Aprendiz aprendiz, RedirectAttributes redirectAttributes) {
        Optional<Aprendiz> aprendizExistente = aprendizd.findById(aprendiz.getIdentificacion_Apr());

        if (aprendizExistente.isPresent()) {
            Aprendiz apre = aprendizExistente.get();
            apre.setTipoIde_Apr(aprendiz.getTipoIde_Apr());
            apre.setCorreo_Apr(aprendiz.getCorreo_Apr());
            apre.setFicha(aprendiz.getFicha());
            aprendizd.save(apre);
            redirectAttributes.addFlashAttribute("success", "La información se ha actualizado correctamente");
            return "redirect:/Funcionario/listarAprendices";
        } else {
            // El aprendiz no existe
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error, vuelve a intentarlo");
            return "redirect:/Funcionario/listarAprendices";
        }
    }

    //ACTUALIZAR ESTADO APRENDIZ
    @PostMapping("/inactivarAp")
    public String inactivarAp( Aprendiz aprendiz, RedirectAttributes redirectAttributes) {
        Optional<Aprendiz> aprendizExistente = aprendizd.findById(aprendiz.getIdentificacion_Apr());
        if (aprendizExistente.isPresent()) {
            Aprendiz apre = aprendizExistente.get();
            apre.setEstado(aprendiz.getEstado());
            aprendizd.save(apre);
            redirectAttributes.addFlashAttribute("success", "Se ha inactivado correctamente");
            return "redirect:/Funcionario/listarAprendices";
        } else {

            // El aprendiz no existe
            return "redirect:/Funcionario/listarAprendices";
        }
    }

    @PostMapping("/actualizarEst")
    public String actualizarEst( Model model, Aprendiz aprendiz, RedirectAttributes redirectAttributes) {
        Optional<Aprendiz> aprendizExistente = aprendizd.findById(aprendiz.getIdentificacion_Apr());

        if (aprendizExistente.isPresent()) {
            Aprendiz apre = aprendizExistente.get();
            apre.setEstado(aprendiz.getEstado());
            aprendizd.save(apre);
            redirectAttributes.addFlashAttribute("success", "Se ha activado correctamente");
            return "redirect:/Funcionario/listarAprendices";
        } else {

            // El aprendiz no existe
            return "redirect:/Funcionario/listarAprendices";
        }
    }


    //CONSULTAR HISTORIAL

    @GetMapping(value="/consultarHistorial")
    public String historialA(Model m){
        return "aprendiz/consultarHistorial";
    }

    //Consultar aprendiz

    @PostMapping(value="/consult")
    public String datosApre( Aprendiz aprendiz, RedirectAttributes redirectAttributes){

        Aprendiz aprendizEncontrado = aprendizd.findByDocumento(aprendiz.getIdentificacion_Apr());
        List<Caso> casoEncontrado = casod.findByAprendiz(aprendiz.getIdentificacion_Apr());


        if (aprendizEncontrado != null) {
            redirectAttributes.addFlashAttribute("caso", casoEncontrado);

            redirectAttributes.addFlashAttribute("aprendiz", aprendizEncontrado);
            return "redirect:/Funcionario/consultarHistorial";
        } else {
            redirectAttributes.addFlashAttribute("error", "Aprendiz no encontrado.");
            return "redirect:/Funcionario/consultarHistorial";
        }

    }


//INSTRUCTOR

    //LISTA
    @GetMapping(value="/listarInstructores")
    public String listar(Model m){
        m.addAttribute("instructor", instructord.findAll());
        return "instructor/listarInstructores";
    }

    //LISTA INACTIVOS
    @GetMapping(value="/instructoresInac")
    public String listarI(Model m){
        m.addAttribute("instructor", instructord.findAll());
        return "instructor/instructoresInac";
    }


    //VISTA ACTUALIZAR
    @GetMapping(value="/actualizarIns")
    public String datosIns(@RequestParam("identificacion_Ins") String identificacion_Ins,  Model m){
        m.addAttribute("instructor", instructord.findByDocumento(identificacion_Ins));
        return "instructor/actualizarInstructor";
    }

    //ACTUALIZAR
    @PostMapping("/actualizarI")
    public String actualizar(Model model, Instructor instructor, RedirectAttributes redirectAttributes) {
        Optional<Instructor> instructorExistente = instructord.findById(instructor.getIdentificacion_Ins());

        if (instructorExistente.isPresent()) {
            Instructor ins = instructorExistente.get();
            ins.setCorreo_Ins(instructor.getCorreo_Ins());
            instructord.save(ins);
            redirectAttributes.addFlashAttribute("success", "La información se ha actualizado correctamente");
            return "redirect:/Funcionario/listarInstructores";
        } else {
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error, vuelve a intentarlo");
            return "redirect:/Funcionario/listarInstructores";
        }
    }

    //ACTUALIZAR ESTADO
    @PostMapping("/actualizarEstIns")
    public String actualizarEst(Instructor instructor, RedirectAttributes redirectAttributes) {
        Optional<Instructor> instructorExistente = instructord.findById(instructor.getIdentificacion_Ins());

        if (instructorExistente.isPresent()) {
            Instructor ins = instructorExistente.get();
            ins.setEstado(instructor.getEstado());
            instructord.save(ins);
            redirectAttributes.addFlashAttribute("success", "Se ha inactivado correctamente");
            return "redirect:/Funcionario/listarInstructores";
        } else {

            return "redirect:/Funcionario/listarInstructores";
        }
    }

//Funcionario
    //Actualizar Usuario
    @GetMapping(value="/actualizarUsu")
    public String datosIsn(  Model m, RedirectAttributes redirectAttributes){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        m.addAttribute("funcionario", funcionariod.findByDocumento(userDetails.getUsername()));
        m.addAttribute("success", "Al actualizar sus datos, deberá también cambiar la contraseña");
        return "Funcionario/actualizarUsuarioFun";
    }

    @PostMapping("/actualizarUs")
    public String actualizarUs(Model model, Funcionario funcionario, RedirectAttributes redirectAttributes) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Funcionario> funcionarioExiste = funcionariod.findById(userDetails.getUsername());

        if (funcionarioExiste.isPresent()) {
            Funcionario fun = funcionarioExiste.get();
            fun.setNombre_Fun(funcionario.getNombre_Fun());
            fun.setApellido_Fun(funcionario.getApellido_Fun());
            fun.setCorreo_Fun(funcionario.getCorreo_Fun());
            fun.setPassword_Fun(funcionario.getPassword_Fun());
            funcionariod.save(fun);
            redirectAttributes.addFlashAttribute("MensajeExitoso", "La información se ha actualizado correctamente");
            return "redirect:/logout";
        } else {
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error, vuelve a intentarlo");
            return "redirect:/Funcionario/actualizarUsu";
        }
    }
}



