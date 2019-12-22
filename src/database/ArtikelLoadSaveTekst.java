package database;

import model.Artikel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Phonkrit Van de Velde
 */

public class ArtikelLoadSaveTekst extends TekstLoadSaveTemplate {


    public ArtikelLoadSaveTekst() {

    }

    @Override
    Scanner getBestand() throws FileNotFoundException {
        String bestandPath = "src" + File.separator + "bestanden" + File.separator + "artikel.txt";
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
        Artikel artikel = new Artikel(id, omschrijving, groep, prijs, stock);
        return artikel;
    }


}
