package database;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import model.Artikel;


public class JarJavaClass {

    public ArrayList<Object> read(String inputFile) throws IOException {
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
                    //TODO: new artikel...
                }
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return null; //TODO: return fixen
    }

    public void write(ArrayList<Object> artikelsArraylist, String inputFile) throws IOException, WriteException {
        File file = new File(inputFile);
        WorkbookSettings wbSettings = new WorkbookSettings();

        wbSettings.setLocale(new Locale("en", "EN"));

        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
        workbook.createSheet("Report", 0);
        WritableSheet excelSheet = workbook.getSheet(0);


        int rijnr = 0;

        ArrayList<Artikel> artikels = new ArrayList<>();

        for (Object o : artikelsArraylist) {
            if (o instanceof Artikel) {
                artikels.add((Artikel) o);
            } else {
                throw new DBException("Object is geen artikel");
            }
        }

        for (Artikel a : artikels) {
            //int kolomnr = 0;
            //for(int i = 0; i < 5;i++){
            Label code = new Label(0, rijnr, a.getArtikelCode());
            excelSheet.addCell(code);
            //Cell cell = excelSheet.getCell(i, 1);

            Label omschrijving = new Label(1, rijnr, a.getOmschrijving());
            excelSheet.addCell(omschrijving);
            Label groep = new Label(2, rijnr, a.getArtikelGroep());
            excelSheet.addCell(groep);
            Label prijs = new Label(3, rijnr, String.valueOf(a.getPrijs()));
            excelSheet.addCell(prijs);
            Label stock = new Label(4, rijnr, String.valueOf(a.getStock()));
            excelSheet.addCell(stock);

            // kolomnr++;
            //}

            rijnr++;
        }


        workbook.write();
        workbook.close();

    }
}
