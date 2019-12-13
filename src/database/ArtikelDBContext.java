package database;

import java.io.File;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

/**
 * @author Max Van De Velde, Marko Kosmajac, Brent Van Eyken
 */

public class ArtikelDBContext {
    private ArrayList<Artikel> data;
    private File bestand; //Filepath
    private static ArtikelDBContext uniqueInstance;
    private LoadSaveStrategy loadSaveStrategy;
    private LoadSaveStrategyFactory loadSaveStrategyFactory;

    private ArtikelDBContext() {
        loadSaveStrategyFactory = new LoadSaveStrategyFactory();
        bestand = new File("src" + File.separator + "bestanden" + File.separator + "artikel.xls");
        data = new ArrayList<>();
        loadSaveStrategy = loadSaveStrategyFactory.makeLoadSaveStrategy("ArtikelLoadSaveExcel"); //todo: getProperties()
        data = (ArrayList<Artikel>) new ArtikelDBInMemory(loadSaveStrategy).load(bestand);
    }

    public static synchronized ArtikelDBContext getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new ArtikelDBContext();
        }
        return uniqueInstance;
    }

    public ArrayList<Artikel> getArtikels(){
        Collections.sort(data);
        return data;
    }

    public ObservableList<Artikel> loadData(){
        return FXCollections.observableArrayList(data);
    }

}
