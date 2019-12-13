package database;

import java.io.File;
import java.util.*;

import controller.InstellingenController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

/**
 * @author Max Van De Velde, Marko Kosmajac, Brent Van Eyken
 */

public class ArtikelDBContext {
    private ArrayList<Artikel> data;
    private static ArtikelDBContext uniqueInstance;
    private File bestand;
    private LoadSaveStrategy loadSaveStrategy;
    private LoadSaveStrategyFactory loadSaveStrategyFactory;
    private InstellingenController instellingenController;

    private ArtikelDBContext() {
        instellingenController = new InstellingenController();
        loadSaveStrategyFactory = new LoadSaveStrategyFactory();
        bestand = new File("src" + File.separator + "bestanden" + File.separator + "artikel.xls");
        data = new ArrayList<>();
        loadSaveStrategy = loadSaveStrategyFactory.makeLoadSaveStrategy(instellingenController.getProperties()); //todo: getProperties()
        System.out.println(instellingenController.getProperties());
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
