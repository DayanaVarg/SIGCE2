package com.sena.sigce.service;

import com.sena.sigce.model.Funcionario;
import com.sena.sigce.repository.FuncionarioRepository;
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
public class _FuncionarioServiceImpl implements IFuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Funcionario> findAll() {
        return (List<Funcionario>) funcionarioRepository.findAll();
    }

    @Override
    public Funcionario save(Funcionario funcionario) {
        String encodedPassword = passwordEncoder.encode(funcionario.getPassword_Fun());
        funcionario.setPassword_Fun(encodedPassword);
        return funcionarioRepository.save(funcionario);
    }


    @Override
    public Funcionario findByDocumento(String identificacion_Fun) {
        return funcionarioRepository.findByDocumento(identificacion_Fun);
    }

    @Override
    public Optional<Funcionario> findById(String identificacion_Fun) {
        return funcionarioRepository.findById(identificacion_Fun);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Funcionario funcionario = funcionarioRepository.findByDocumento(username);
        if (funcionario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        Collection<? extends GrantedAuthority> authorities = Collections.emptyList();
        return new org.springframework.security.core.userdetails.User(
                funcionario.getIdentificacion_Fun(),
                funcionario.getPassword_Fun(),
                authorities
        );
    }

   
}
