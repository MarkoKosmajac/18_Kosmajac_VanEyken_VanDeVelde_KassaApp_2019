package controller;

import database.ArtikelDBContext;
import model.Artikel;
import model.ArtikelModel;
import model.observer.Observer;
import view.KlantViewMainPane;
import view.panels.KlantOverviewPane;

import java.util.ArrayList;

public class KlantProductOverviewController implements Observer {

    private KlantOverviewPane klantOverviewPane; //View

    public KlantProductOverviewController(ArtikelModel artikelModel) {
        artikelModel.register(this);
    }

    public void setPane(KlantOverviewPane klantOverviewPane){
        this.klantOverviewPane = klantOverviewPane;
    }

    @Override
    public void update(ArrayList<Artikel> artikelijst) {
        klantOverviewPane.setArtikellijst(artikelijst);
    }
}
