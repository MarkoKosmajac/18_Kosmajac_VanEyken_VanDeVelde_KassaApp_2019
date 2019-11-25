package model;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ArtikelCompany {
    private ObservableList<Artikel> data;
    private String bestand = "src\\bestanden\\artikel.txt"; //Filepath

    public ArtikelCompany(){
        data = FXCollections.observableArrayList(new ArrayList<Artikel>());
        UITestStory1 a = new UITestStory1();
        data.addAll(a.load(bestand));
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

    public void verwijderArtikel(String artikelcode) {
        ArrayList<Artikel> artikelenLijst = new ArrayList<Artikel>(data);
        for(Artikel a : artikelenLijst){
            if(a.getArtikelCode().equalsIgnoreCase(artikelcode)){
                artikelenLijst.remove(artikelcode);
            }
        }
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
