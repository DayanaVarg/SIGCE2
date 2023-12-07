package com.sena.sigce.controllers;

import com.sena.sigce.PDF.PdfGenerator;
import com.sena.sigce.model.Ficha;
import com.sena.sigce.model.PDF;
import com.sena.sigce.service.IAprendizService;
import com.sena.sigce.service.ICasoService;
import com.sena.sigce.service.ICitacionService;
import com.sena.sigce.service.IPdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Controller
@RequestMapping("/Pdf")
public class PdfController {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private IPdfService iPdfd;

    @Autowired
    private ICasoService casod;

    @Autowired
    private IAprendizService aprendizd;

    @Autowired
    private ICitacionService citaciond;

    //Vista de formulario registrar ficha
    @GetMapping(value = "/GenerarPDF/{id}")
    public String PDF(@PathVariable String id, Model model){
       PDF pdf = new PDF();
        model.addAttribute("data", pdf);
        model.addAttribute("listaCaso", casod.findAll());
        model.addAttribute("aprendiz", aprendizd.findByDocumento(id));
        model.addAttribute("listaCit", citaciond.findAll());
        return "Pdf/download";
    }

    @GetMapping("/download")
    public void downloadFile(HttpServletResponse response) throws IOException {
        PdfGenerator generator = new PdfGenerator();
        byte[] pdfReport = generator.getPDF().toByteArray();

        String mimeType =  "application/pdf";
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", "reporte.pdf"));

        response.setContentLength(pdfReport.length);

        ByteArrayInputStream inStream = new ByteArrayInputStream( pdfReport);

        FileCopyUtils.copy(inStream, response.getOutputStream());
    }
}
