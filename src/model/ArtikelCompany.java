package model;

import java.util.*;

import database.ArtikelDBInMemory;
import database.ArtikelLoadSaveTekst;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ArtikelCompany {
    private ObservableList<Artikel> data;
    private String bestand; //Filepath
    private ArtikelLoadSaveTekst artikelLoadSaveTekst;

    public ArtikelCompany(){
        if (System.getProperty("os.name").equals("Mac OS X")){
            bestand = "src/bestanden/artikel.txt";
        } else {
            bestand = "src\\bestanden\\artikel.txt";
        }

        data = FXCollections.observableArrayList(new ArrayList<Artikel>());
        artikelLoadSaveTekst = new ArtikelLoadSaveTekst(); //tot nu toe zo
        ArtikelDBInMemory b = new ArtikelDBInMemory(artikelLoadSaveTekst, bestand);

        data.add(new Artikel("05","appel","gr01",5,10));

        //data.addAll(b.load(bestand));
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
