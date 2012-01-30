/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Info;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author miguel
 */
public class pdf {

    private static String FILE = "FirstPdf.pdf";
    private static Font catFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);

    public static void main(String[] args) {
        try {
            System.out.println("A começar a gerar pdf...");

            JFileChooser chooser = new JFileChooser();
            chooser.setApproveButtonText("Save");

            File theFileToSave = null;
            int option = chooser.showOpenDialog(null);
            if (option == JFileChooser.APPROVE_OPTION) {
                if (chooser.getSelectedFile() != null) {
                    theFileToSave = chooser.getSelectedFile();
                }
            }

            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream(theFileToSave));
            //PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            createPDF(document);
            document.close();
            System.out.println("Gerou.");
            /*
            SendMail mail = new SendMail();
            mail.sendMail(
            "miguelpintodacosta@gmail.com",
            "miguelpintodacosta@hotmail.com",
            "Testar envio de email",
            "Esta é a mensagem do email");*/

            System.out.println("Terminou de gerar.");

        } catch (Exception ex) {
            Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao gerar pdf: " + ex.getMessage());
        }

    }

    private static void createPDF(Document document) {
        try {
            addMetaData(document);
            addLogo(document);
            addAdress(document);
            addTitlePage(document);
            addContent(document);
        } catch (DocumentException ex) {
            Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // iText allows to add metadata to the PDF which can be viewed in your Adobe
    // Reader
    // under File -> Properties
    private static void addMetaData(Document document) {
        document.addTitle("Norconcept");
        document.addSubject("Orçamento");
        document.addKeywords("Norconcept, PDF, orçamento, Cozinhas, mármore, granito");
        document.addAuthor("Miguel Costa");
        document.addCreator("Miguel Costa");
    }

    private static void addTitlePage(Document document) throws DocumentException {
        try {

            // adicina texto
            Paragraph preface = new Paragraph();
            // We add one empty line
            addEmptyLine(preface, 1);
            // Lets write a big header
            preface.add(new Paragraph(
                    "Orçamento Gerado Automaticamente", smallBold));
            GregorianCalendar data = new GregorianCalendar();
            preface.add(new Paragraph(
                    "Data: " + data.get(Calendar.DAY_OF_MONTH) + "/" + data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR)));
            addEmptyLine(preface, 1);


            //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            addEmptyLine(preface, 3);

            //addEmptyLine(preface, 8);

            preface.add(new Paragraph(
                    "Os preços podem não estar de acordo com a realidade.",
                    redFont));

            document.add(preface);
            // Start a new page
            document.newPage();
        } catch (BadElementException ex) {
            Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void addLogo(Document document) {
        try {
            // Adicionar a Imagem do logo
            System.out.println("Add logo");
            URL i = pdf.class.getClass().getResource("/Imagens/logo6.png");
            System.out.println(i.toURI());
            Image img = Image.getInstance(i);
            img.setAlignment(Image.RIGHT);
            document.add(img);
            System.out.println("Add logo end");
        } catch (BadElementException ex) {
            Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void addAdress(Document document) {
        try {
            // Morada
            Paragraph morada = new Paragraph();
            morada.setAlignment(Image.RIGHT);
            morada.add(new Paragraph(
                    "Bloco A1, 5ºE"));
            morada.add(new Paragraph(
                    "Urbanização Quinta dos Orfãos"));
            morada.add(new Paragraph(
                    "4700-000 Braga"));
            morada.add(new Paragraph(
                    "Protugal"));
            document.add(morada);
        } catch (DocumentException ex) {
            Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void addContent(Document document) throws DocumentException {
        Anchor anchor = new Anchor(
                "First Chapter",
                catFont);

        anchor.setName("First Chapter 2");

        // Second parameter is the number of the chapter
        Chapter catPart = new Chapter(new Paragraph(anchor), 1);

        Paragraph subPara = new Paragraph(
                "Subcategory 1",
                subFont);
        Section subCatPart = catPart.addSection(subPara);
        subCatPart.add(new Paragraph("Hello"));

        subPara = new Paragraph("Subcategory 2", subFont);
        subCatPart = catPart.addSection(subPara);
        subCatPart.add(new Paragraph("Paragraph 1"));
        subCatPart.add(new Paragraph("Paragraph 2"));
        subCatPart.add(new Paragraph("Paragraph 3"));

        // Add a list
        createList(subCatPart);
        Paragraph paragraph = new Paragraph();
        addEmptyLine(paragraph, 5);
        subCatPart.add(paragraph);

        // Add a table
        createTable(subCatPart);

        // Now add all this to the document
        document.add(catPart);

        // Next section
        anchor = new Anchor("Second Chapter", catFont);
        anchor.setName("Second Chapter");

        // Second parameter is the number of the chapter
        catPart = new Chapter(new Paragraph(anchor), 1);

        subPara = new Paragraph("Subcategory", subFont);
        subCatPart = catPart.addSection(subPara);
        subCatPart.add(new Paragraph("This is a very important message"));

        // Now add all this to the document
        document.add(catPart);

    }

    private static void createTable(Section subCatPart) throws BadElementException {
        PdfPTable table = new PdfPTable(3);

        // t.setBorderColor(BaseColor.GRAY);
        // t.setPadding(4);
        // t.setSpacing(4);
        // t.setBorderWidth(1);

        PdfPCell c1 = new PdfPCell(new Phrase("Table Header 1"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Table Header 2"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Table Header 3"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);

        table.addCell("1.0");
        table.addCell("1.1");
        table.addCell("1.2");
        table.addCell("2.1");
        table.addCell("2.2");
        table.addCell("2.3");

        subCatPart.add(table);
    }

    private static void createList(Section subCatPart) {
        List list = new List(true, false, 10);
        list.add(new ListItem("First point"));
        list.add(new ListItem("Second point"));
        list.add(new ListItem("Third point"));
        subCatPart.add(list);
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
