package controller;

import database.DBException;
import database.ArtikelDBContext;
import model.Artikel;
import model.ArtikelModel;
import model.observer.Observer;
import view.panels.KassaTab1OverviewPane;
import java.util.ArrayList;

/**
 * @author Max Van De Velde, Marko Kosmajac
 */

public class KassaProductOverviewController implements Observer {

    private ArtikelModel artikelModel; //Model
    private KassaTab1OverviewPane kassaTab1OverviewPaneView; //View
    private ArtikelDBContext artikelDBContext;

    public KassaProductOverviewController(ArtikelModel artikelModel){
        this.artikelModel = artikelModel;
        artikelModel.register(this);

        artikelDBContext = ArtikelDBContext.getInstance();
    }

    public void addToLijst(Artikel artikel) {
        try {
            artikelModel.addToLijst(artikel);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void verwijderVanLijst(Artikel artikel){
        try {
            artikelModel.verwijderVanLijst(artikel);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
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

    public void setPane(KassaTab1OverviewPane kassaTab1OverviewPaneView){
        this.kassaTab1OverviewPaneView = kassaTab1OverviewPaneView;
    }

    public ArrayList<Artikel> getArtikels(){
        return artikelDBContext.getArtikels();
    }
    public ArrayList<Artikel> getAlleCurrentArtikelen(){
        return artikelModel.getAlleCurrentArtikelen();
    }
    public Artikel getArtikel(String ingevuldeWaarde) {
        Artikel res = null;
        for (Artikel a: getArtikels()){
            if (a.getArtikelCode().equalsIgnoreCase(ingevuldeWaarde)){
                res = a;
            }
        }
        if(res == null) throw new DBException("Artikel bestaat niet!");
        return res;
    }
    public void setOnHoldList() {
        artikelModel.setOnHoldlist();
    }
    public void returnToPreviousList(){
        artikelModel.returnToPreviousList();
    }
    @Override
    public void update(ArrayList<Artikel> artikellijst) {
        kassaTab1OverviewPaneView.setArtikellijst(artikellijst);
        kassaTab1OverviewPaneView.setTotaalBedrag(getTotPrijs());
    }

    public void setCurrentList(ArrayList<Artikel> list) {
        artikelModel.setCurrentLijst(list);
    }
}
