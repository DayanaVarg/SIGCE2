package com.sena.sigce.service;

import com.sena.sigce.model.ResultadoApre;
import com.sena.sigce.repository.ResultadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class _ResultadoServiceImpl implements IResultadoService {


    @Autowired
    private ResultadoRepository resultadoRepository;

    @Override
    public List<ResultadoApre> findAll() {
        return (List<ResultadoApre>) resultadoRepository.findAll() ;
    }

    @Override
    public ResultadoApre save(ResultadoApre resultadoApre) {
        return resultadoRepository.save(resultadoApre);
    }

}
