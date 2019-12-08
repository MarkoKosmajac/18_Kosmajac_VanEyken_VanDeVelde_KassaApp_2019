package model;

import java.io.IOException;
import java.util.*;

import database.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ArtikelCompany {
    private ObservableList<Artikel> data;
    private String bestand; //Filepath
    //private ArtikelDBInMemory artikelDBInMemory;
    public LoadSaveStrategyFactory loadSaveStrategyFactory; //TODO: DEEL VAN FACTORY PATTERN WITH SINGLETON
    public ArtikelDBStrategyFactory artikelDBStrategyFactory;
    private static ArtikelCompany artikelCompany; //TODO: deel van singleton

    //TODO: PRIVATE MAKEN = deel van singleton
    private ArtikelCompany() throws IOException {
        //TODO: GEEN EFFECT WHEN IN COMMENTS
        if (System.getProperty("os.name").equals("Mac OS X")){
            bestand = "src/bestanden/artikel.txt";
        } else {
            bestand = "src\\bestanden\\artikel.txt";
        }

        loadSaveStrategyFactory = new LoadSaveStrategyFactory(); //TODO: DEEL VAN FACTORY PATTERN WITH SINGLETON
        artikelDBStrategyFactory = new ArtikelDBStrategyFactory();

        //ArtikelLoadSaveTekst artikelLoadSaveTekst = new ArtikelLoadSaveTekst(); //tot nu toe zo
        //artikelDBInMemory = new ArtikelDBInMemory(artikelLoadSaveTekst, bestand);
        //TODO: BOVENSTE 2 LIJNTJES OMGEVORMD NAAR HIERONDER 1 LIJN:
        ArrayList<Object> aa = //TODO: VERANDERINGENDOCUMENT MARKO: DIT HIER LINKS VAN TOEGEVOEGD
                loadSaveStrategyFactory.makeLoadSaveStrategy("ArtikelLoadSaveTekst").load(bestand);

        data = FXCollections.observableArrayList(new ArrayList<Artikel>());


        ArrayList<Artikel> newArrList = new ArrayList<>();

        //ArrayList<Object> aa = artikelDBInMemory.load(bestand);
        //TODO: NAAR
        //FOUT: DIT KIEST TUSSEN EXCEL EN TEKST: ArrayList<Object> aa = loadSaveStrategyFactory.makeLoadSaveStrategy("ArtikelLoadSaveTekst").load(bestand);
        //JUSIT: EENTJE DIE KIEST TUSSEN ARTIKELDBINMEMORY OF DBSQL
        //ArrayList<Object> aa = artikelDBStrategyFactory.makeArtikelDBStrategy("ArtikelDBInMemory").load(bestand);

        for(Object o : aa){
            if(o instanceof Artikel){
                newArrList.add((Artikel) o);
            }
        }
        data.addAll(newArrList);
    }

    public static ArtikelCompany getInstance() throws IOException {
        if(artikelCompany == null){
            artikelCompany = new ArtikelCompany();
        }
        return artikelCompany;
    }

    public ObservableList<Artikel> loadData()     {
        return data;
    }

    public String zoek(String artikelcode) {
        ArrayList<Artikel> artikelenLijst = new ArrayList<Artikel>(data);
        for(Artikel a : artikelenLijst){
            if(a.getArtikelCode().equalsIgnoreCase(artikelcode)){
                return a.getOmschrijving() + "," + a.getPrijs();
            }
        }
        return "Niet bestaande code";
    }

    public Artikel zoekArtikel(String artikelcode) {
        ArrayList<Artikel> artikelenLijst = new ArrayList<Artikel>(data);
        for(Artikel a : artikelenLijst){
            if(a.getArtikelCode().equalsIgnoreCase(artikelcode)){
                return a;
            }
        }
        return null;
    }

    public void verwijderArtikel(String code) {
        System.out.println(this.data);
        //ArrayList<Artikel> artikelenLijst = new ArrayList<Artikel>(data);

        Artikel em = new Artikel("00","dummy","groep0",0,0);
        for(Artikel a : this.data){
            if(a.getArtikelCode().equalsIgnoreCase(code)){
                em = a;
            }
        }
        this.data.remove(em);
        System.out.println(this.data);
    }




    /**
     * Convert a list to Map
     * @param data
     * @return HashMap<Calendar, OHLC>
     */
    /*public HashMap<Calendar, OHLC> listToMap(ObservableList<OHLC> data){
        HashMap<Calendar, OHLC> result = new HashMap();
        Iterator<OHLC> it = data.iterator();
        while (it.hasNext()){
            OHLC ohlc = it.next();
            result.put(ohlc.getDate(), ohlc);
        }
        return result;
    }*/

    /*public int getAantalArtikels(){
        return data.size()-1;
    }

    public void addDummyArtikel(){
        Artikel artikel = new Artikel("50", "Rotte appel","001", 0.01, 10);
        data.add(artikel);
    }*/
}
