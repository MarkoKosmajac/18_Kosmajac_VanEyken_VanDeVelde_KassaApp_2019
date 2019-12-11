package controller;

import model.Artikel;
import model.ArtikelModel;
import model.observer.Observer;
import view.panels.KlantOverviewPane;

import java.util.ArrayList;

public class KlantProductOverviewController implements Observer {

    private KlantOverviewPane klantOverviewPane;
    private ArtikelModel artikelModel;

    public KlantProductOverviewController(ArtikelModel artikelModel) {
        this.artikelModel = artikelModel;
        artikelModel.register(this);
    }

    public double getTotPrijs(){
        double tot = 0.0;
        try {
            tot = artikelModel.getTotPrijs();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return tot;
    }

    public void setPane(KlantOverviewPane klantOverviewPane){
        this.klantOverviewPane = klantOverviewPane;
    }

    @Override
    public void update(ArrayList<Artikel> artikelijst) {
        klantOverviewPane.setArtikellijst(artikelijst);
    }
}
