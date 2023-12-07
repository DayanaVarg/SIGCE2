package com.sena.sigce.service;

import com.sena.sigce.model.Instructor;
import com.sena.sigce.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class _InstructorServiceImpl implements IInstructorService {


    @Autowired
    private InstructorRepository instructorRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Instructor> findAll() {
        return (List<Instructor>) instructorRepository.findAll() ;
    }

    @Override
    public Instructor save(Instructor instructor) {
        String encodedPassword = passwordEncoder.encode(instructor.getPass_Ins());
        instructor.setPass_Ins(encodedPassword);
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor findByDocumento(String identificacion_Ins) {
        return instructorRepository.findByDocumento(identificacion_Ins);
    }


    @Override
    public Optional<Instructor> findById(String identificacion_Ins) {
        return instructorRepository.findById(identificacion_Ins);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Instructor instructor = instructorRepository.findByDocumento(username);
        if(instructor == null){
            throw new UsernameNotFoundException("Documento o contraseña inválidos");
        }

        Collection<? extends GrantedAuthority> authorities = Collections.emptyList();
        return new org.springframework.security.core.userdetails.User(
                instructor.getIdentificacion_Ins(),
                instructor.getPass_Ins(),
                authorities
        );
    }

}

