package com.sena.sigce.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sena.sigce.model.PDF;
import com.sena.sigce.repository.PdfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class _PdfServiceImpl implements  IPdfService{

    @Autowired
    private PdfRepository pdfRepository;
    @Override
    public List<PDF> findAll() {
        return (List<PDF>) pdfRepository.findAll();
    }

    @Override
    public ByteArrayOutputStream getPDF(Integer Identificacion) {
        // Creamos la instancia de memoria en la que se escribirá el archivo temporalmente
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {

            Document document = new Document(PageSize.A4);
            Calendar calendario = new GregorianCalendar();
            Integer ide = Identificacion;
            Font fuenteTitulo = new Font();
            fuenteTitulo.setSize(20);

            Font negrita = new Font();
            negrita.setStyle(Font.BOLD);


            Chunk titulo = new Chunk("ACTA");
            titulo.setUnderline(2f, -2f);

            titulo.setFont(fuenteTitulo);

            Chunk fecha = new Chunk(
                    "FECHA COMITE" );

            Paragraph parrafo = new Paragraph("Nombre del aprendiz identificado" +
                    ide);

            parrafo.setLeading(5.0f, 1.0f);

            Chunk firma = new Chunk("_____________________________________");

            Chunk nom = new Chunk(""+ide+".pdf");
            nom.setFont(negrita);

            PdfPTable tabla = new PdfPTable(1);

            PdfPCell celda0 = new PdfPCell(new Phrase(" "));
            PdfPCell celda1 = new PdfPCell(new Phrase(titulo));
            PdfPCell celda2 = new PdfPCell(new Phrase(fecha));
            PdfPCell celda3 = new PdfPCell(parrafo);
            PdfPCell celda4 = new PdfPCell(new Phrase(firma));
            PdfPCell celda5 = new PdfPCell(new Phrase(nom));

            tabla.addCell(celda0);
            tabla.addCell(celda1);
            tabla.addCell(celda2);
            tabla.addCell(celda3);
            tabla.addCell(celda4);
            tabla.addCell(celda5);

            // Asignamos la variable ByteArrayOutputStream bos donde se escribirá el documento
            PdfWriter.getInstance(document, bos);
            document.open();
            document.add(tabla);
            document.close();
            // Retornamos la variable al finalizar
            return bos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
