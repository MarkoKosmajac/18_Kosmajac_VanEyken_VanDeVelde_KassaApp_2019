package database;

import jxl.write.WriteException;
import model.Artikel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Phonkrit Van de Velde
 */

public class ArtikelLoadSaveTekst extends TekstLoadSaveTemplate {


    public ArtikelLoadSaveTekst() {

    }


   /* public void save(ArrayList<Object> artikelArrayList, String bestand){
        ArrayList<Artikel> artikelen = new ArrayList<>();

        for(Object o : artikelArrayList){
            if(o instanceof Artikel){
                artikelen.add((Artikel)o);
            }
        }

        File personenFile = new File(bestand);
        try{
            PrintWriter writer = new PrintWriter(personenFile);
            for(Artikel a : artikelen){
                writer.printf(a.toString());
            }
            writer.close();
        } catch (FileNotFoundException e1) {
            throw new DBException("Bestand niet gevonden" + e1);
        }

    }

    abstract FileWriter getFileWriter() throws IOException;

    public final void save(ArrayList<Object> objecten){
        PrintWriter print_line = null;
        try {
            FileWriter write = getFileWriter();
            print_line = new PrintWriter(write);
        } catch (IOException x) {
            System.out.println(x.getMessage());
        }
        for (Object object: objecten) {
            print_line.printf(object.toString());
        }
        print_line.close();
    }


    */


    @Override
    Scanner getBestand() throws FileNotFoundException {
        String bestandPath;
        //aa
        if (System.getProperty("os.name").equals("Mac OS X")){
            bestandPath = "src/bestanden/artikel.txt";
        } else {
            bestandPath = "src\\bestanden\\artikel.txt";
        }
        return new Scanner(new File(bestandPath));
    }

    @Override
    Object getObject(Scanner scannerLine) {
        String id = scannerLine.next();
        String omschrijving = scannerLine.next();
        String groep = scannerLine.next();
        String pris = scannerLine.next();
        double prijs = Double.parseDouble(pris);
        String stok = scannerLine.next();
        int stock = Integer.parseInt(stok);
        //vb: 1,artikel1,gr1,12.5,10
        Artikel artikel = new Artikel(id, omschrijving, groep, prijs, stock);
        return artikel;
    }


}
