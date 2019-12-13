package controller;

import database.DBException;
import database.ArtikelDBContext;
import model.Artikel;
import model.ArtikelModel;
import model.observer.Observer;
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
        kassaOverviewPaneView.setArtikellijst(artikellijst);
        kassaOverviewPaneView.setTotaalBedrag(getTotPrijs());
    }


    public double getEindPrijs() {
        InputStream in = null;
        try {
            in = new FileInputStream(new File("src" + File.separator + "database" + File.separator + "KassaApp.properties"));
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        double percent = Double.parseDouble(properties.getProperty("Kortingspercent"));
        double totprijs = artikelModel.getTotPrijs();
        double korting = (percent*totprijs)/100;
        return  totprijs-korting;

    }
}
