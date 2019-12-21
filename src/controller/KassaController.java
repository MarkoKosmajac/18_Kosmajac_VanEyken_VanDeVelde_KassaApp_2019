package controller;

import database.DBException;
import database.ArtikelDBContext;
import javafx.scene.control.Label;
import model.Artikel;
import model.ArtikelModel;
import model.decorator.*;
import model.observer.Observer;
import model.state.KassaState;
import model.state.OnHold;
import view.panels.KassaOverviewPane;

import java.io.*;
import java.net.ConnectException;
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
        double tot = 0.0;
        try {
            tot = artikelModel.getTotPrijs();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return tot;
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
        InputStream in = null;
        try {
            in = new FileInputStream(new File("src" + File.separator + "database" + File.separator + "KassaApp.properties"));
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Double.parseDouble(properties.getProperty("Kortingspercent"));
    }


    /*public double getEindPrijs() {

        double percent = getKorting();
        double totprijs = artikelModel.getTotPrijs();
        double korting = (percent*totprijs)/100;
        return  totprijs-korting;

    }*/

    public double getEindPrijs() {

        double totprijs = artikelModel.getTotPrijs();

        if(totprijs >= getKortingBedrag()){
            double percent = getKorting();
            double korting = (percent*totprijs)/100;
            return totprijs-korting;
        }else{
            return totprijs;
        }
    }

    public double getKortingBedrag(){
        InputStream in = null;
        try {
            in = new FileInputStream(new File("src" + File.separator + "database" + File.separator + "KassaApp.properties"));
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Double.parseDouble(properties.getProperty("Kortingsbedrag"));
    }

    //TODO: IN ANDERE CONTROLLER ?
    public String log(String totaalBedrag, String kortingBedrag, String eindTotaal) {
        return artikelModel.log(totaalBedrag,kortingBedrag,eindTotaal);
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


    /*public String printKassaBon(String text) {
        return artikelModel.kassaBonPrintModel(text);
    }*/

    public void setState(KassaState state){
        artikelModel.setKassaState(state);
    }
}
