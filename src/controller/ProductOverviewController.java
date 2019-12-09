package controller;

import database.ArtikelDBContext;
import model.Artikel;
import view.panels.KassaTab1OverviewPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductOverviewController {

    List<Artikel> winkelmandje;
    ArtikelDBContext db = ArtikelDBContext.getInstance();

    public ProductOverviewController() throws IOException {
        //db = ArtikelDBContext.getInstance();
        winkelmandje = new ArrayList<>();
        winkelmandje.addAll(db.loadData());
    }

    //TODO: MODELKLASSE ?
    public Artikel getArtikel(String ingevuldeWaarde) {
        Artikel a = null;
        for(Artikel artikel : winkelmandje){
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

    public void addToWinkelMandje(Artikel artikel) {
        winkelmandje.add(artikel);
        System.out.println(artikel);
        //theview.setWaarde("eee");

        //TODO: IETS
    }
}
