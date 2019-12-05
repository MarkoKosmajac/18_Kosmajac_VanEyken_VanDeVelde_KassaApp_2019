package database;

import java.io.File;
import java.io.IOException;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import jxl.read.biff.BiffException;


public class JarJavaClass {
    private String inputFile;
    public JarJavaClass(String inputFile) {
        this.inputFile = inputFile;
    }

    public void read(){
        File inputWorkbook = new File(inputFile);
        Workbook w;
        try {
            w = Workbook.getWorkbook(inputWorkbook);
            Sheet sheet = w.getSheet(0); // Pak de eerste sheet
            // Loop over de eerste 10 kolommen en lijnen
            for (int j = 0; j < sheet.getRows(); j++) {
                for (int i = 0; i < sheet.getColumns(); i++) {
                    Cell cell = sheet.getCell(i, j);
                    System.out.println(cell.getContents());
                }
            }
        } catch (BiffException | IOException e) {
            e.printStackTrace();
        }

    }

    public void write(){

    }

}
