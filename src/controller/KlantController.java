package controller;

import model.Artikel;
import model.ArtikelModel;
import model.observer.Observer;
import view.panels.KassaOverviewPane;
import view.panels.KlantOverviewPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @author Max Van De Velde, Marko Kosmajac
 */

public class KlantController implements Observer {

    private KlantOverviewPane klantOverviewPane;
    private ArtikelModel artikelModel;
    private Properties properties;
    private KassaOverviewPane kassaOverviewPane;
    private KassaController kassaController;

    public KlantController(ArtikelModel artikelModel) {
        properties = new Properties();
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
        klantOverviewPane.setArtikellijst(artikelModel.getKassaKlantList());
        klantOverviewPane.setTotaalBedrag(Math.floor(getTotPrijs()*100)/100);
        klantOverviewPane.setEindTotaal(Math.floor(getEindPrijs()*100)/100);
        klantOverviewPane.setKorting(Math.floor((getTotPrijs()-getEindPrijs())*100)/100);
    }

    public double getKorting(){
        InputStream in = null;
        try {
            in = new FileInputStream(new File("src" + File.separator + "bestanden" + File.separator + "KassaApp.properties"));
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Double.parseDouble(properties.getProperty("Kortingspercent"));
    }

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
            in = new FileInputStream(new File("src" + File.separator + "bestanden" + File.separator + "KassaApp.properties"));
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Double.parseDouble(properties.getProperty("Kortingsbedrag"));
    }

    public KlantOverviewPane getKlantOverviewPane() {
        return klantOverviewPane;
    }

    public void setKlantOverviewPane(KlantOverviewPane klantOverviewPane) {
        this.klantOverviewPane = klantOverviewPane;
    }

    public ArtikelModel getArtikelModel() {
        return artikelModel;
    }

    public void setArtikelModel(ArtikelModel artikelModel) {
        this.artikelModel = artikelModel;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public KassaOverviewPane getKassaOverviewPane() {
        return kassaOverviewPane;
    }

    public void setKassaOverviewPane(KassaOverviewPane kassaOverviewPane) {
        this.kassaOverviewPane = kassaOverviewPane;
    }

    public KassaController getKassaController() {
        return kassaController;
    }

    public void setKassaController(KassaController kassaController) {
        this.kassaController = kassaController;
    }
}
