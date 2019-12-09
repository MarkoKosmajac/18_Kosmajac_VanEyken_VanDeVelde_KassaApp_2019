package controller;

import model.Artikel;

import java.util.ArrayList;
import java.util.List;

public class ProductOverviewController {

    List<Artikel> winkelmandje;

    public ProductOverviewController() {
        winkelmandje = new ArrayList<>();
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
        //TODO: IETS
    }
}
