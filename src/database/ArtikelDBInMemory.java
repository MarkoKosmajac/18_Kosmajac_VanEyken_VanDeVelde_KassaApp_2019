package database;

import jxl.write.WriteException;
import model.Artikel;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ArtikelDBInMemory implements ArtikelDBStrategy {
    //Hierin zit hashmap -lees uit, uit artikel.txt
    //Enum van types van  databases
    //Methode: Load en Save
    //Dit is nu de context klasse voor load en save strategy
    private LoadSaveStrategy loadSaveStrategy;
    private HashMap artikelen = new HashMap<String, Artikel>();
    private TreeMap treeMap = new TreeMap<>(new ComparatorOpOmschrijving());



    public ArtikelDBInMemory(LoadSaveStrategy loadSaveStrategy, String bestand) throws IOException {
        this.loadSaveStrategy = loadSaveStrategy;
        ArrayList<Object> a = load(bestand);

        for (Object o : a) {
            if (o instanceof Artikel) {
                artikelen.put(((Artikel) o).getArtikelCode(), (Artikel) o);

            }
        }
    }



    public ArrayList<Object> load(String bestand) throws IOException {
        return loadSaveStrategy.load(bestand);
    }


    public void save(ArrayList<Object> artikelArrayList, String bestand) throws IOException, WriteException {
        loadSaveStrategy.save(artikelArrayList, bestand);
    }


}
