package com.sena.sigce.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sena.sigce.model.Aprendiz;
import com.sena.sigce.repository.AprendizRepository;
  

@Service
public class _AprendizServiceImpl implements IAprendizService {

    @Autowired
    private AprendizRepository aprendizRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    // Obtencion de datos para la consulta (Listar)
    @Override
    public List<Aprendiz> findAll() {
        return (List<Aprendiz>) aprendizRepository.findAll();
    }

     // Obtencion de datos para registrar un Aprendiz 

    @Override
    public Aprendiz save(Aprendiz aprendiz) {

        String encodedPassword = passwordEncoder.encode(aprendiz.getPassword_Apr());
        aprendiz.setPassword_Apr(encodedPassword);

        return aprendizRepository.save(aprendiz);
    }




    //Lista por identificacion

   @Override
    public Aprendiz findByDocumento(String identificacion_Apr) {
        return aprendizRepository.findByDocumento(identificacion_Apr);

    }

    @Override
    public Aprendiz findValidar(String documento, String tipoDoc, String password) {
        return aprendizRepository.findValidar(documento, tipoDoc, password);
    }

    @Override
    public Optional<Aprendiz> findById(String identificacion_Apr) {
        return aprendizRepository.findById(identificacion_Apr);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Aprendiz aprendiz = aprendizRepository.findByDocumento(username);
        if (aprendiz == null) {
            throw new UsernameNotFoundException("Documento o contraseña inválidos");
        }

        Collection<? extends GrantedAuthority> authorities = Collections.emptyList();
        return new org.springframework.security.core.userdetails.User(
                aprendiz.getIdentificacion_Apr(),
                aprendiz.getPassword_Apr(),
                authorities
        );
    }


}
