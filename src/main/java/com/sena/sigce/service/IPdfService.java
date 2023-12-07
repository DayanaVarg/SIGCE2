package com.sena.sigce.service;

import com.sena.sigce.model.PDF;
import java.io.ByteArrayOutputStream;
import java.util.List;

public interface IPdfService {

    List<PDF> findAll();

    ByteArrayOutputStream getPDF(Integer Identificacion);


}
