package database;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import excel.ExcelPlugin;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

/**
 * @author Marko Kosmajac, Phonkrit Van de Velde, Brent Van Eyken
 */

public class JarJavaClass {

    private excel.ExcelPlugin excelPlugin = new ExcelPlugin();

    public ArrayList<ArrayList<String>> load(File file){
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        try {
            result = excelPlugin.read(file); //file en arraylist vn arraylist vn string meegeven.
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void save(File file, ArrayList<ArrayList<String>> list){
        try {
            excelPlugin.write(file,list);
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }

    /*public ArrayList<Object> read(String inputFile) throws IOException  {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        ArrayList<Object> a = new ArrayList<>();

        try {
            w = Workbook.getWorkbook(inputWorkbook);
            Sheet sheet = w.getSheet(0); // Pak de eerste sheet

            for (int row=0; row < sheet.getRows();row++) {
                Artikel event = new Artikel(null);
                event.setArtikelCode(sheet.getCell(0, row).getContents());
                event.setOmschrijving(sheet.getCell(1,row).getContents());
                event.setArtikelGroep(sheet.getCell(2,row).getContents());
                event.setPrijs(Double.parseDouble(sheet.getCell(3,row).getContents()));
                event.setStock(Integer.parseInt(sheet.getCell(4,row).getContents()));
                a.add(event);
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return a;
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
            Label code = new Label(0, rijnr, a.getArtikelCode());
            excelSheet.addCell(code);

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

    }*/
}
