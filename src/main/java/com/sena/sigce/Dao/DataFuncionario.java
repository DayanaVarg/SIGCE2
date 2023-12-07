package com.sena.sigce.Dao;

import com.sena.sigce.model.Estado;
import com.sena.sigce.model.Funcionario;
import com.sena.sigce.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataFuncionario implements CommandLineRunner {


    private final FuncionarioRepository funcionarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public DataFuncionario(FuncionarioRepository funcionarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.funcionarioRepository = funcionarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        String password = "1013106777";
        String hashedPassword = passwordEncoder.encode(password);

        Funcionario funcionario = new Funcionario();
        funcionario.setIdentificacion_Fun("1013106777");
        funcionario.setTipoIde_Fun("CC");
        funcionario.setNombre_Fun("JHON JAIRO");
        funcionario.setApellido_Fun("LEURO DELGADO");
        funcionario.setCorreo_Fun("jjleuro@sena.edu.co");
        funcionario.setPassword_Fun(hashedPassword);


        Estado estado = new Estado();
        estado.setId_Est(1);
        funcionario.setEstado(estado);


        funcionarioRepository.save(funcionario);
    }
}
