package packagestory1;

import model.Artikel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ArtikelLoadSaveTekst extends TekstLoadSaveTemplate {


    public ArtikelLoadSaveTekst(String bestand) {

    }

    public ArrayList<Artikel> load(String bestand){
        ArrayList a = new ArrayList<Artikel>();

        if (bestand == null || bestand.trim().isEmpty()) throw new IllegalArgumentException("Artikel mag niet leeg zijn");
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
            throw new IllegalArgumentException("Fout bij het inlezen", e);
        }

    }


    public void save(ArrayList<Artikel> artikelArrayList){

        File personenFile = new File("Personen.txt");
        try{
            PrintWriter writer = new PrintWriter(personenFile);
            writer.println("Max " + "Van de Velde");
            writer.println("Luca " + "VH");
            writer.close();
        } catch (FileNotFoundException e1) {
            throw new IllegalArgumentException("Bestand niet gevonden" + e1);
        }
qsdqsdqsdqsdqdqsdqsdqd

    }


}
