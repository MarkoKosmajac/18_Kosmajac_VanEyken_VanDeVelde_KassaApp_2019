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
    private InstellingenController instellingenController;
    private ArtikelDBInMemory artikelDBInMemory;

    private ArtikelDBContext() {
        artikelDBInMemory = new ArtikelDBInMemory();
        instellingenController = new InstellingenController();
        bestand = instellingenController.geefPathFile();
        data = new ArrayList<>();
        loadSaveStrategy = LoadSaveStrategyFactory.getInstance().makeLoadSaveStrategy(instellingenController.getProperties());
        this.setData((ArrayList<Artikel>) new ArtikelDBInMemory(loadSaveStrategy).load(bestand));

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

    public void setData(ArrayList<Artikel> data) {
        this.data = data;
    }

    public void save(ArrayList<Artikel> artikels){
        artikelDBInMemory.save(artikels);
    }

    public void setArtikelDBInMemory(ArtikelDBInMemory artikelDBInMemory) {
        this.artikelDBInMemory = artikelDBInMemory;
    }
}
