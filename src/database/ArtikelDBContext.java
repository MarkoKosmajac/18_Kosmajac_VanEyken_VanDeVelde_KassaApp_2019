package database;

import java.io.File;
import java.io.IOException;
import java.util.*;

import controller.ControllerException;
import controller.InstellingenController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

public class ArtikelDBContext {
    private ArrayList<Artikel> data;
    private File bestand; //Filepath
    private static ArtikelDBContext uniqueInstance; //TODO: deel van singleton
    private String opgezochteCode;
    private LoadSaveStrategy loadSaveStrategy;
    private LoadSaveStrategyFactory loadSaveStrategyFactory;

    private ArtikelDBContext() {
        loadSaveStrategyFactory = new LoadSaveStrategyFactory();
        bestand = new File("src" + File.separator + "bestanden" + File.separator + "artikel.xls");
        data = new ArrayList<>();
        loadSaveStrategy = loadSaveStrategyFactory.makeLoadSaveStrategy("ArtikelLoadSaveTekst"); //todo: getProperties()
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

    public String zoekArtikelEnKrijgOmschrijvingEnPrijs(String artikelcode) {
        ArrayList<Artikel> artikelenLijst = new ArrayList<Artikel>(data);
        for(Artikel a : artikelenLijst){
            if(a.getArtikelCode().equalsIgnoreCase(artikelcode)){
                return a.getOmschrijving() + "," + a.getPrijs();
            }
        }
        return "Niet bestaande code";
    }

    public void verwijderArtikel(String code) {
        System.out.println(this.data);

        Artikel em = new Artikel("00","dummy","groep0",0,0);
        for(Artikel a : this.data){
            if(a.getArtikelCode().equalsIgnoreCase(code)){
                em = a;
            }
        }
        this.data.remove(em);
        System.out.println(this.data);
    }

    public void zoekCodeOp(String code){
        if(code.equalsIgnoreCase(opgezochteCode)){
            opgezochteCode = code;
        }
        throw new NumberFormatException("Code bestaat niet.");
    }

    public ArrayList<Artikel> getArtikelen() {
        return (ArrayList<Artikel>) data; //TODO: ALLE ARTIKELEN
    }

    public Artikel getArtikel(String ingevuldeWaarde) {
        Artikel a = null;
        for(Artikel artikel : data){
            if(artikel.getArtikelCode().equalsIgnoreCase(ingevuldeWaarde)){
                a = artikel;
            }
        }
        if(a == null){
            throw new ControllerException("Geen artikel gevonden.");
        }else{
            return a;
        }
    }
}
