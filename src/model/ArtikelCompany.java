package model;

import java.util.ArrayList;

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

    public int getAantalArtikels(){
        return data.size()-1;
    }

    public void addDummyArtikel(){
        Artikel artikel = new Artikel("50", "Rotte appel","001", 0.01, 10);
        data.add(artikel);
    }
}
