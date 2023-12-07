package com.sena.sigce.PDF;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PdfGenerator {

    public ByteArrayOutputStream getPDF() {


        // Creamos la instancia de memoria en la que se escribirá el archivo temporalmente
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {

            Document document = new Document(PageSize.A4);
            Calendar calendario = new GregorianCalendar();
            Font fuenteTitulo = new Font();
            fuenteTitulo.setSize(20);

            Font negrita = new Font();
            negrita.setStyle(Font.BOLD);


            Chunk titulo = new Chunk("Acta");
            titulo.setUnderline(2f, -2f);

            titulo.setFont(fuenteTitulo);

            Chunk cabeza = new Chunk("COMITÉ DE EVALUACIÓN Y SEGUIMIENTO");
            Chunk fecha = new Chunk("CIUDAD Y FECHA Bogotá, 31 DE OCTUBRE 2023");
            Chunk horas = new Chunk("HORA INICIO: 10:00 AM");
            Chunk lugar = new Chunk("LUGAR Y/O ENLACE: Plataforma Virtual Meet");

            Paragraph parrafo = new Paragraph("AGENDA O PUNTOS PARA DESARROLLAR:\n" +
                    "\n" +
                    "TEMA (S):\n" +
                    "Tratar los casos de aprendices citados por los instructores en proceso de formación de etapa lectiva, quienes se relacionan a continuación:\n");

            parrafo.setLeading(5.0f, 1.0f);

            Chunk ide = new Chunk("1018479035");
            Chunk name = new Chunk("DAYANA");
            Chunk ape = new Chunk("VARGAS");
            Paragraph parrafoA = new Paragraph("OBJETIVO(S) DE LA REUNIÓN: Analizar las situaciones presentadas por cada aprendiz citado y sugerir acciones decisorias para la aprobación de la Subdirección de Centro, teniendo en cuenta el Reglamento del Aprendiz SENA y notificar la decisión tomada por el Comité, previa autorización de la Subdirección, a cada uno de los aprendices.");

            parrafo.setLeading(5.0f, 1.0f);

            Chunk firma = new Chunk("_____________________________________");

            Chunk nombre = new Chunk("Uldarico Andrade");
            nombre.setFont(negrita);

            PdfPTable tabla = new PdfPTable(1);

            PdfPCell celda0 = new PdfPCell(new Phrase(" "));
            PdfPCell celda1 = new PdfPCell(new Phrase(cabeza));
            PdfPCell celda2 = new PdfPCell(new Phrase(titulo));
            PdfPCell celda3 = new PdfPCell(new Phrase(fecha));
            PdfPCell celda4 = new PdfPCell(new Phrase(horas));
            PdfPCell celda5 = new PdfPCell(new Phrase(lugar));
            PdfPCell celda6 = new PdfPCell(parrafo);
            PdfPCell celda7 = new PdfPCell(new Phrase(ide));
            PdfPCell celda8 = new PdfPCell(new Phrase(name));
            PdfPCell celda9 = new PdfPCell(new Phrase(ape));
            PdfPCell celda10 = new PdfPCell(parrafoA);
            PdfPCell celda11 = new PdfPCell(new Phrase(firma));
            PdfPCell celda12 = new PdfPCell(new Phrase(nombre));

            tabla.addCell(celda0);
            tabla.addCell(celda1);
            tabla.addCell(celda2);
            tabla.addCell(celda3);
            tabla.addCell(celda4);
            tabla.addCell(celda5);
            tabla.addCell(celda6);
            tabla.addCell(celda7);
            tabla.addCell(celda8);
            tabla.addCell(celda9);
            tabla.addCell(celda10);
            tabla.addCell(celda11);
            tabla.addCell(celda12);

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
