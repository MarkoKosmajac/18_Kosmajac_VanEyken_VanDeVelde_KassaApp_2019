package controller;

import model.Artikel;
import model.ArtikelModel;
import model.observer.Observer;
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
            in = new FileInputStream(new File("src" + File.separator + "database" + File.separator + "KassaApp.properties"));
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Double.parseDouble(properties.getProperty("Kortingspercent"));
    }


    public double getEindPrijs() {

        double percent = getKorting();
        double totprijs = artikelModel.getTotPrijs();
        double korting = (percent*totprijs)/100;
        return  totprijs-korting;

    }
}
