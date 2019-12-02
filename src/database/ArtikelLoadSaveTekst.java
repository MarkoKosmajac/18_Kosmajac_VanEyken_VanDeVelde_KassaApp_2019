package database;

import model.Artikel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ArtikelLoadSaveTekst extends TekstLoadSaveTemplate {


    public ArtikelLoadSaveTekst() {

    }

    public ArrayList<Object> load(String bestand){
        ArrayList a = new ArrayList<Artikel>();

        if (bestand == null || bestand.trim().isEmpty()) throw new DBException("Artikel mag niet leeg zijn");
        File artikelenFile = new File(bestand);
        try {
            Scanner scannerFile = new Scanner(artikelenFile);
            while (scannerFile.hasNextLine()) {
                Scanner scannerLijn = new Scanner(scannerFile.nextLine());
                scannerLijn.useDelimiter(",");
                String id = scannerLijn.next();
                String omschrijving = scannerLijn.next();
                String groep = scannerLijn.next();
                String pris = scannerLijn.next();
                double prijs = Double.parseDouble(pris);
                String stok = scannerLijn.next();
                int stock = Integer.parseInt(stok);
                //vb: 1,artikel1,gr1,12.5,10
                Artikel artikel = new Artikel(id, omschrijving, groep, prijs, stock);
                a.add(artikel);
            }
            return a;

            //artikelen = sortByValues(artikelen);
        } catch (FileNotFoundException e) {
            throw new DBException("Fout bij het inlezen", e);
        }

    }




    public void save(ArrayList<Object> artikelArrayList, String bestand){
        ArrayList<Artikel> artikelen = new ArrayList<>();

        for(Object o : artikelArrayList){
            if(o instanceof Artikel){
                artikelen.add((Artikel)o);
            }
        }

        File personenFile = new File(bestand); //TODO: RENAME TO artikel.txt
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


}
