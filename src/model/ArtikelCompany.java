package model;

import java.util.*;

import database.InMemoryArtikelDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

public class ArtikelCompany {
    private ObservableList<Artikel> data;
    private ObservableMap<String, Artikel> dek;
    private String bestand = "src\\bestanden\\artikel.txt"; //Filepath

    public ArtikelCompany(){
        //data = FXCollections.observableArrayList(new ArrayList<Artikel>());
        dek = FXCollections.observableHashMap();
        InMemoryArtikelDatabase b = new InMemoryArtikelDatabase(bestand);
        //dek.put("1", new Artikel("01","appel","5",5,5));
        dek.putAll(b.getArtikelen());
        System.out.println(dek);
        //data.addAll(a.load(bestand));
        //data.addAll((ArrayList<Artikel>) b.getArtikelen().values());
        //data.add(new Artikel("01", "Peer", "Groep 01", 100,50));
        //dek.putAll(b.getArtikelen());

    }

    public ObservableMap<String, Artikel> loadData()     {
        return dek;
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
        System.out.println(data);
        ArrayList<Artikel> artikelenLijst = new ArrayList<Artikel>(data);
        System.out.println(artikelenLijst);

        System.out.println("keke=" + artikelenLijst.toString());
        for(Artikel a : artikelenLijst){
            if(a.getArtikelCode().equalsIgnoreCase(code)){
                System.out.println(a.toString() + "sdffsdfsfsdfs");
                artikelenLijst.remove(a);
            }
            System.out.println("zmldkfsmdkfsfsdfsdf");
        }
        System.out.println("mlqdfkmlqsdkfsmdlfk");
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
