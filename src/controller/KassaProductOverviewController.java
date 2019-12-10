package controller;

import database.DBException;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import database.ArtikelDBContext;
import model.Artikel;
import model.ArtikelModel;
import model.observer.Observer;
import view.panels.KassaTab1OverviewPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KassaProductOverviewController implements Observer {


    private ArtikelModel artikelModel; //Model
    private KassaTab1OverviewPane kassaTab1OverviewPaneView; //View
    private ArtikelDBContext artikelDBContext;

    public KassaProductOverviewController(ArtikelModel artikelModel){
        this.artikelModel = artikelModel;
        artikelModel.register(this);

        try {
            artikelDBContext = ArtikelDBContext.getInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO: Controller functie add observer met 'this'
    }

    public void addToWinkelMandje(Artikel artikel) {
        artikelModel.addToWinkelMandje(artikel);

    }

    public void setPane(KassaTab1OverviewPane kassaTab1OverviewPaneView){
        this.kassaTab1OverviewPaneView = kassaTab1OverviewPaneView;
    }

    public ArrayList<Artikel> getArtikels(){
        return artikelDBContext.getArtikels();
    }

    public Artikel getArtikel(String ingevuldeWaarde) {
        Artikel res = null;
        for (Artikel a: getArtikels()){
            if (a.getArtikelCode().equalsIgnoreCase(ingevuldeWaarde)){
                res = a;
            }
        }
        return res;
    }

    @Override
    public void update(ArrayList<Artikel> artikellijst) {
        kassaTab1OverviewPaneView.setArtikellijst(artikellijst);
    }
}
