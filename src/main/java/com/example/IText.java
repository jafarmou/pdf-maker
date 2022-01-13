package com.example;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author jafarmou
 */
public class IText {

    private Document document = new Document();
    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private FileOutputStream iTextHelloWorld;
//    private Path path = Paths.get(ClassLoader.getSystemResource("Java_logo.png").toURI());

    {
        try {
            iTextHelloWorld = new FileOutputStream("iTextHelloWorld.pdf");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addText() throws FileNotFoundException, DocumentException {
//        PdfWriter.getInstance(document, iTextHelloWorld);

        PdfWriter instance = PdfWriter.getInstance(document, byteArrayOutputStream);
//        instance.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);

        document.open();
        Font font2 = FontFactory.getFont(FontFactory.TIMES, 16, BaseColor.BLACK);
        Chunk chunk1 = new Chunk("Hello World", font2);
        BaseFont base = null;
        try {
            base = BaseFont.createFont("assets/Titr_bold.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Font font = new Font(base, 12f, Font.NORMAL);
        font.setColor(BaseColor.RED);

//        Font font = FontFactory.getFont("Simplified Arabic", 16, BaseColor.BLACK);


        PdfPTable table = new PdfPTable(1);

        PdfPCell cell = new PdfPCell(new Phrase("سلام دنیا", font));
        cell.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
//        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);


        Chunk chunk = new Chunk("سلام دنیا 2", font);

        Phrase phrase = new Phrase();
        phrase.add(chunk);
        Paragraph para = new Paragraph();
        para.add(phrase);

        para.setAlignment(Element.ALIGN_RIGHT);


        PdfPTable table2 = new PdfPTable(8);
        PdfPCell hello = new PdfPCell(new Phrase("hello"));
        hello.setRowspan(4);
        hello.setPaddingLeft(12);
        hello.setPaddingTop(24);
        hello.setBorder(Rectangle.NO_BORDER);
        table2.addCell(hello);
        PdfPCell world = new PdfPCell(new Phrase("World"));
        world.setRowspan(2);
        table2.addCell(world);
        for(int aw = 0; aw < 25; aw++){
            table2.addCell("hi");
        }




        for(int aw = 0; aw < 9; aw++){
            table2.addCell("hi2");
        }

        File file = new File("assets/img.jpg");

        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(Paths.get("assets/img.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image img = null;
        Image img2 = null;
        try {
            img = Image.getInstance("assets/img.jpg");
            img.scaleAbsolute(240, 240);

            img2 = Image.getInstance("assets/pdf_logo.png");
            img2.scaleAbsolute(30, 20);
        } catch (IOException e) {
            e.printStackTrace();
        }

        PdfPCell world2 = new PdfPCell(new Phrase("World2"));
        world2.setRowspan(2);
        world2.setBorder(Rectangle.NO_BORDER);
        table2.addCell(world2);


        PdfPCell imgCell = new PdfPCell(img2);
        imgCell.setRowspan(2);
        imgCell.setBorder(Rectangle.NO_BORDER);
        table2.addCell(imgCell);

        for(int aw = 0; aw < 2; aw++){
            table2.addCell("img");
        }

        table2.addCell(img);

        for(int aw = 0; aw < 10; aw++){
            table2.addCell("img");
        }


        document.add(table);
        document.add(para);
        document.add(table);
        document.add(table2);
        document.add(img);
        document.close();


//        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("nameee"));
  //      PdfContentByte canvas = instance.getDirectContent();
    //    ColumnText.showTextAligned(canvas, Element.ALIGN_RIGHT, phrase, 10, 10, 0, PdfWriter.RUN_DIRECTION_RTL, 3);
    }


    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public ByteArrayOutputStream getByteArrayOutputStream() {
        return byteArrayOutputStream;
    }

    public void setByteArrayOutputStream(ByteArrayOutputStream byteArrayOutputStream) {
        this.byteArrayOutputStream = byteArrayOutputStream;
    }

    public FileOutputStream getiTextHelloWorld() {
        return iTextHelloWorld;
    }

    public void setiTextHelloWorld(FileOutputStream iTextHelloWorld) {
        this.iTextHelloWorld = iTextHelloWorld;
    }
}
