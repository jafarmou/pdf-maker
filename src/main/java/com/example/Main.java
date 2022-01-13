package com.example;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author jafarmou
 */
public class Main {
    public static void main(String[] args) throws DocumentException, FileNotFoundException {
        IText iText = new IText();

        iText.addText();

        Document document = iText.getDocument();

        try {
            saveFileToDirectory(iText.getByteArrayOutputStream(), "pdf", "hello.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }


    private static void saveFileToDirectory(ByteArrayOutputStream is, String filePath, String name) throws IOException {

        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss-"));
        String fileName = date + name;

        if(!Files.exists(Paths.get(filePath)))
            Files.createDirectories(Paths.get(filePath));

        String path = filePath + "/" + fileName;

        Files.write(Paths.get(path), is.toByteArray());

    }
}
