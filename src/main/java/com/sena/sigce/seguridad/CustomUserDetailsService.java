package com.sena.sigce.seguridad;

import com.sena.sigce.model.Aprendiz;
import com.sena.sigce.model.Estado;
import com.sena.sigce.model.Funcionario;
import com.sena.sigce.model.Instructor;
import com.sena.sigce.service.IAprendizService;
import com.sena.sigce.service.IFuncionarioService;
import com.sena.sigce.service.IInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private IInstructorService instructorService;

    @Autowired
    private IFuncionarioService funcionarioService;

    @Autowired
    private IAprendizService aprendizService;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Buscando usuario con nombre de usuario: " + username);

        Instructor instructor = instructorService.findByDocumento(username);
        Funcionario funcionario = funcionarioService.findByDocumento(username);
        Aprendiz aprendiz = aprendizService.findByDocumento(username);

        System.out.println("Encontrado instructor: " + (instructor != null));
        System.out.println("Encontrado funcionario: " + (funcionario != null));
        System.out.println("Encontrado aprendiz: " + (aprendiz != null));


//      INSTRUCTOR

        if (instructor != null && instructor.isInstructor()) {
            System.out.println("Usuario es un instructor.");
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_INSTRUCTOR"));
            return new org.springframework.security.core.userdetails.User(
                    instructor.getIdentificacion_Ins(),
                    instructor.getPass_Ins(),
                    grantedAuthorities
        );

//      FUNCIONARIO

        } else if (funcionario != null && funcionario.isFuncionario()) {
            System.out.println("Usuario es un funcionario.");
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_FUNCIONARIO"));
            return new org.springframework.security.core.userdetails.User(
                    funcionario.getIdentificacion_Fun(),
                    funcionario.getPassword_Fun(),
                    grantedAuthorities
            );

//      APRENDIZ

        } else if (aprendiz != null && aprendiz.isAprendiz()) {
            System.out.println("Usuario es un aprendiz.");
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_APRENDIZ"));
            return new org.springframework.security.core.userdetails.User(
                    aprendiz.getIdentificacion_Apr(),
                    aprendiz.getPassword_Apr(),
                    grantedAuthorities
            );

        } else {
            System.out.println("Usuario no encontrado o no tiene roles válidos.");
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }
}
