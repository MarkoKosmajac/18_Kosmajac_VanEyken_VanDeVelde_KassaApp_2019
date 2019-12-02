package packagestory1;

import model.Artikel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ArtikelDBInMemory implements ArtikelDBStrategy {
    //Hierin zit hashmap -lees uit, uit artikel.txt
    //Enum van types van  databases
    //Methode: Load en Save
    //Dit is nu de context klasse voor load en save strategy
    private LoadSaveStrategy loadSaveStrategy;
    private HashMap artikelen = new HashMap<String, Artikel>();


    public ArtikelDBInMemory(String bestand) {
        ArrayList<Artikel> a = load(bestand);

        for(Artikel artikel : a){
            artikelen.put(artikel.getArtikelCode(), artikel);
        }
    }

    public ArrayList<Artikel> load(String bestand){
        return null;
    }


    public void save(ArrayList<Artikel> artikelArrayList){

    }


}
