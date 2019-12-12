package database;

import model.Artikel;
import model.ArtikelDBStrategy;
import model.LoadSaveStrategy;
import model.LoadSaveStrategyFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArtikelDBInMemory implements ArtikelDBStrategy {
    private ArtikelDBStrategy artikelDBStrategy;
    private HashMap artikelen;
    //private TreeMap treeMap;
    //private LoadSaveStrategyFactory loadSaveStrategyFactory;

    public ArtikelDBInMemory(LoadSaveStrategy loadSaveStrategy){

        artikelen = new HashMap<String, Artikel>();

        loadSaveStrategy = new LoadSaveStrategyFactory().makeLoadSaveStrategy(/*getStrategy()*/""); //TODO: replace uit properties ingelezen.
    }


    public List<Artikel> load(File bestand){
        List<Artikel> artikels = new ArrayList<>();
        List<Object> objectenList = new ArrayList<>();

            artikels = artikelDBStrategy.load(bestand);

        for (Object o : objectenList) {
            if (o instanceof Artikel) {
                artikelen.put(((Artikel) o).getArtikelCode(), o);

            }
        }
        return artikels;
    }

    @Override
    public void save(ArrayList<Artikel> artikelArrayList) {

    }


}
