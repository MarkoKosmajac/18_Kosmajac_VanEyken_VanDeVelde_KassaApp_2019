package database;

import model.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Max Van De Velde, Marko Kosmajac, Brent Van Eyken
 */

public class ArtikelDBInMemory implements ArtikelDBStrategy {

    private LoadSaveStrategy loadSaveStrategy;
    private HashMap<String, Artikel> artikelen;

    public ArtikelDBInMemory(LoadSaveStrategy loadSaveStrategy) {
        this.loadSaveStrategy = loadSaveStrategy;
        artikelen = new HashMap<String, Artikel>();
    }


    public List<Artikel> load(File bestand) {
        List<Artikel> artikels = new ArrayList<Artikel>();
        List<Object> objectenList = new ArrayList<>();

        try {
            objectenList = this.loadSaveStrategy.load(bestand);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Object o : objectenList) {
            if (o instanceof Artikel) {
                artikels.add((Artikel) o);
            }
        }
        return artikels;
    }

    @Override
    public void save(ArrayList<Artikel> artikelArrayList) {
        List<Object> objectenList = new ArrayList<>();
        objectenList.addAll(artikelArrayList);
        try {
            loadSaveStrategy.save(objectenList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
