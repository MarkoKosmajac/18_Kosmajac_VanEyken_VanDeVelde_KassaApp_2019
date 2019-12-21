package database;

import controller.InstellingenController;
import model.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Max Van De Velde, Marko Kosmajac, Brent Van Eyken
 */

public class ArtikelDBInMemory implements ArtikelDBStrategy {

    private LoadSaveStrategy loadSaveStrategy;
    private HashMap<String, Artikel> artikelen;
    private ArtikelDBStrategy artikelDBStrategy;
    private LoadSaveStrategyFactory loadSaveStrategyFactory;
    private InstellingenController instellingenController;
    private ArtikelDBContext artikelDBContext;

    public ArtikelDBInMemory(LoadSaveStrategy loadSaveStrategy) {

        instellingenController = new InstellingenController();
        loadSaveStrategyFactory = new LoadSaveStrategyFactory();

        loadSaveStrategy = loadSaveStrategyFactory.makeLoadSaveStrategy(instellingenController.getProperties());
        this.loadSaveStrategy = loadSaveStrategy;



        artikelen = new HashMap<String, Artikel>();
    }

    public ArtikelDBInMemory() {
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
        List<Object> objectenList = new ArrayList<>(artikelArrayList);
        try {
            ArtikelDBInMemory artikelDBInMemory = new ArtikelDBInMemory(loadSaveStrategy);
            this.loadSaveStrategy = artikelDBInMemory.getLoadSaveStrategy();
            this.loadSaveStrategy.save(objectenList);
        } catch ( IOException e) {

            System.out.println(e.getMessage() + " Artikellijst is niet weggeschreven  " + Arrays.toString(e.getStackTrace()));
        }
    }

    public LoadSaveStrategy getLoadSaveStrategy() {
        return loadSaveStrategy;
    }
}
