package database;

import java.io.IOException;
import java.util.*;

import controller.ControllerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jdk.jshell.spi.ExecutionControl;
import model.*;

public class ArtikelDBContext {
    private ArrayList<Artikel> data;
    private String bestand; //Filepath
    public LoadSaveStrategyFactory loadSaveStrategyFactory; //TODO: DEEL VAN FACTORY PATTERN WITH SINGLETON
    public ArtikelDBStrategyFactory artikelDBStrategyFactory;
    private static ArtikelDBContext uniqueInstance; //TODO: deel van singleton
    private String opgezochteCode;
    private List<Artikel> artikelList;

    //TODO: PRIVATE MAKEN = deel van singleton
    private ArtikelDBContext(LoadSaveStrategy loadSaveStrategy) {
        //TODO: GEEN EFFECT WHEN IN COMMENTS
        if (System.getProperty("os.name").equals("Mac OS X")){
            bestand = "src/bestanden/artikel.txt";
        } else {
            bestand = "src\\bestanden\\artikel.txt";
        }
        artikelList = new ArrayList<>();
        loadSaveStrategyFactory = new LoadSaveStrategyFactory();
        artikelDBStrategyFactory = new ArtikelDBStrategyFactory();

        //ArtikelLoadSaveTekst artikelLoadSaveTekst = new ArtikelLoadSaveTekst(); //tot nu toe zo
        //artikelDBInMemory = new ArtikelDBInMemory(artikelLoadSaveTekst, bestand);
        //TODO: BOVENSTE 2 LIJNTJES OMGEVORMD NAAR HIERONDER 1 LIJN:
        //TODO: VERANDERINGENDOCUMENT MARKO: DIT HIER LINKS VAN TOEGEVOEGD
                try {
                    ArrayList<Object> aa = loadSaveStrategyFactory.makeLoadSaveStrategy("ArtikelLoadSaveTekst").load(bestand);
                    data = new ArrayList<Artikel>();
                    ArrayList<Artikel> newArrList = new ArrayList<>();
                    for(Object o : aa){
                        if(o instanceof Artikel){
                            newArrList.add((Artikel) o);
                        }
                    }
                    data.addAll(newArrList);
                }
                catch (IOException exception){
                    throw new DBException(exception.getMessage());
                }
        //ArrayList<Object> aa = artikelDBInMemory.load(bestand);
        //TODO: NAAR
        //FOUT: DIT KIEST TUSSEN EXCEL EN TEKST: ArrayList<Object> aa = loadSaveStrategyFactory.makeLoadSaveStrategy("ArtikelLoadSaveTekst").load(bestand);
        //JUSIT: EENTJE DIE KIEST TUSSEN ARTIKELDBINMEMORY OF DBSQL
        //ArrayList<Object> aa = artikelDBStrategyFactory.makeArtikelDBStrategy("ArtikelDBInMemory").load(bestand);
    }

    public static synchronized ArtikelDBContext getInstance() throws IOException {
        if(uniqueInstance == null){
            uniqueInstance = new ArtikelDBContext(new ArtikelLoadSaveTekst());
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
        for(Artikel artikel : artikelList){
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
