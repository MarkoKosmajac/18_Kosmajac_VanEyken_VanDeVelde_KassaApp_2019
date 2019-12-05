package database;

import model.Artikel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class TekstLoadSaveTemplate implements LoadSaveStrategy {
    //TODO: nog aan te vullen, hier komen abstracte methodes save en load om bijvoorbeeld een KLANT object in te lezen en te saven
    //TODO: STANDAARDCODE;

    //LOAD EN SAVE METHODE DIE MOETEN FINAL ZIJN

    final ArrayList<Object> load() {

        ArrayList a = new ArrayList<Artikel>();
        bestandsnaam();
        if (bestandsnaam() == null || bestandsnaam().trim().isEmpty()) throw new DBException("Artikel mag niet leeg zijn");
        File artikelenFile = new File(bestandsnaam());

        return openScannerEnLeesIn();


    }

    final void save(){

    }

    abstract void artikelOmzettenNaarLijn();
    abstract String bestandsnaam();
    abstract ArrayList<Object> openScannerEnLeesIn();





}
