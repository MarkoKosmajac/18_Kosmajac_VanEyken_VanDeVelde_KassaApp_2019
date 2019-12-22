package controller;

import database.DBException;
import database.ArtikelDBContext;
import model.Artikel;
import model.ArtikelModel;
import model.observer.Observer;
import model.state.VerkoopState;
import view.panels.KassaOverviewPane;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @author Max Van De Velde, Marko Kosmajac
 */

public class KassaController implements Observer {

    private ArtikelModel artikelModel; //Model
    private KassaOverviewPane kassaOverviewPaneView; //View
    private ArtikelDBContext artikelDBContext;
    private Properties properties;


    public KassaController(ArtikelModel artikelModel){
        properties = new Properties();
        this.artikelModel = artikelModel;
        artikelModel.register(this);

        artikelDBContext = ArtikelDBContext.getInstance();
    }


    public void addToLijst(Artikel artikel) {
        try {
            if (!artikelModel.getKassaKlantList().contains(artikel)){
                artikelModel.addToLijst(artikel);
                artikelModel.addToLijstKassa(artikel);
            } else {
                artikelModel.addToLijst(artikel);
                artikelModel.veranderAantalPositief(artikel);
            }
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
        return  artikelModel.getTotPrijs();
    }

    public void setPane(KassaOverviewPane kassaOverviewPaneView){
        this.kassaOverviewPaneView = kassaOverviewPaneView;
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
            if (a.getArtikelCode().equalsIgnoreCase(ingevuldeWaarde) && a.getStock() >= 1){
                a.setStock(a.getStock()-1);
                if (a.getStock() >= 0){
                    res = a;
                }
            }
        }
        if(res == null){
            throw new DBException("Artikel bestaat niet! (Niet bestaande code) of artikel is out of stock");
        }
        return res;
    }
    public void setOnHoldList() {
        try {
            artikelModel.setOnHoldlist();
        }
        catch (Exception e){
            throw new ControllerException(e.getMessage());
        }
    }

    public void returnToPreviousList(){
        try {
            artikelModel.returnToPreviousList();
        }
        catch (Exception e){
            throw new ControllerException(e.getMessage());
        }
    }

    @Override
    public void update(ArrayList<Artikel> artikellijst) {
        kassaOverviewPaneView.setArtikellijst(artikellijst);
        kassaOverviewPaneView.setTotaalBedrag(Math.floor(getTotPrijs()*100)/100);
        kassaOverviewPaneView.setEindTotaal(Math.floor(getEindPrijs()*100)/100);
        kassaOverviewPaneView.setKorting(Math.floor((getTotPrijs()-getEindPrijs())*100)/100);
    }

    public double getKorting(){
        return artikelModel.getKorting();
    }


    public double getEindPrijs() {

        return artikelModel.getEindPrijs();
    }

    public double getKortingBedrag(){
        return artikelModel.getKortingBedrag();
    }

    public void nieuwVenster() {
        artikelModel.nieuwVenster();
    }

    public void werkStockBij() {
        artikelModel.werkStockBij();
    }

    public void resetOnHoldListAls3keerBetaald(){
        artikelModel.resetOnHoldListAls3keerBetaald();
    }


    public String printKassaBon() {
        return artikelModel.kassaBonPrintModel();
    }

    public void setState(VerkoopState state){
        artikelModel.setVerkoopState(state);
    }
}
