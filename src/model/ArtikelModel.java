package model;

import controller.InstellingenController;
import controller.KassaController;
import database.ArtikelDBContext;
import database.DBException;
import model.decorator.FooterDecorator;
import model.decorator.HeaderDecorator;
import model.decorator.Kassabon;
import model.decorator.TekstKassabonLezer;
import model.kortingstrategie.KortingStrategie;
import model.observer.Observer;
import model.observer.Subject;
import model.state.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

/**
 * @author Max Van De Velde, Marko Kosmajac
 */


public class ArtikelModel implements Subject {

    private Collection<Observer> kassaObserver;
    private InstellingenController instellingenController = new InstellingenController();
    private ArrayList<Artikel> artikelList,onHoldList, kassaKlantList, kassaKlantListOnHold;
    private int onHoldTeller;
    private ArtikelDBContext artikelDBContext;
    private VerkoopState verkoopState;
    private KortingStrategie kortingStrategie;
    private Properties properties;
    private double kortingBedrag;
    private double kortingpercent;





    public ArtikelModel() {
        properties = new Properties();
        artikelDBContext = ArtikelDBContext.getInstance();
        kassaKlantListOnHold = new ArrayList<>();
        kassaObserver = new ArrayList<>();
        artikelList = new ArrayList<>();
        onHoldList = new ArrayList<>();
        kassaKlantList = new ArrayList<>();

        setVerkoopState(verkoopState);

    }

    public void veranderAantalPositief(Artikel artikel){
        int index = kassaKlantList.indexOf(artikel);
        kassaKlantList.get(index).setAantal(artikel.getAantal()+1);
        notifyObserver();

    }
    public void veranderAantalNegatief(Artikel artikel){
        int index = kassaKlantList.indexOf(artikel);
        kassaKlantList.get(index).setAantal(artikel.getAantal()-1);
        if (kassaKlantList.get(index).getAantal() == 0){
            kassaKlantList.remove(index);
        }
        notifyObserver();
    }
    public void addToLijst(Artikel artikel) {
       artikelList.add(artikel);
       notifyObserver();

    }

    public void addToLijstKassa(Artikel artikel) {
        if (!kassaKlantList.contains(artikel)){
            kassaKlantList.add(artikel);
            notifyObserver();
        }
        veranderAantalPositief(artikel);
        notifyObserver();

    }
    public void verwijderVanLijst(Artikel artikel){
        artikelList.remove(artikel);
        veranderAantalNegatief(artikel);
        notifyObserver();
    }
    public double getTotPrijs(){
        double tot = 0.0;
        for(Artikel a : artikelList){
            if(a != null){
                tot += a.getPrijs();
            }
        }
        return Math.floor(tot*100)/100;
    }

    public void setOnHoldlist() {
        if (this.onHoldList.isEmpty()){
            this.onHoldList.addAll(this.artikelList);
            this.kassaKlantListOnHold.addAll(this.kassaKlantList);



            for (Artikel a: this.kassaKlantList){
                a.setAantal(0);
            }


            this.artikelList.clear();
            this.kassaKlantList.clear();


            notifyObserver();
        } else {
            throw new DBException("Er mag maar 1 list tegelijk on hold gezet worden");
        }
    }

    public void returnToPreviousList(){
        if (!this.artikelList.isEmpty()){
            throw new DBException("Je huidige rekening moet eerst afgehandeld worden");
        } else {
            this.artikelList.addAll(this.onHoldList);
            this.kassaKlantList.addAll(this.kassaKlantListOnHold);

            for (Artikel a: this.kassaKlantList){
                for (Artikel b: this.artikelList){
                    if (a == b){
                        a.setAantal(a.getAantal()+1);
                    }
                }
            }




            this.kassaKlantListOnHold.clear();
            this.onHoldList.clear();
            notifyObserver();
        }
    }

    public ArrayList<Artikel> getAlleCurrentArtikelen(){
        return this.artikelList;
    }

    @Override
    public void register(Observer obs) {
        kassaObserver.add(obs);
    }
    @Override
    public void unregister(Observer o) {
        kassaObserver.remove(o);
    }
    @Override
    public void notifyObserver() {
        for(Observer observer : kassaObserver){
            observer.update(artikelList);
        }
    }
    public Collection<Observer> getKassaObserver() {
        return kassaObserver;
    }
    public ArrayList<Artikel> getArtikelList() {
        return artikelList;
    }
    public ArrayList<Artikel> getKassaKlantList() {
        return kassaKlantList;
    }


    public String log(String totaalBedrag, String kortingBedrag, String eindTotaal) {
        String res = "";
        res+="-----------------------------------------------------------------------------------------------------";
        res += "\nDATUM BETALING: ";

        //GET DATE + TIME
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        res+= dtf.format(now);
        res += "\nGEKOCHTE GOEDEREN: \n";

        //GET CURRENT LIST PRODUCTEN TOSTRING
        for(Artikel artikel : this.artikelList){
            res += artikel.cleanOutput();
        }
        res +="Totaalbedrag: " + totaalBedrag + "euro | Verkregen Korting: " + kortingBedrag + "euro | Te betalen Eindtotaal: " + eindTotaal +"euro";
        res += "\n";
        res+="-----------------------------------------------------------------------------------------------------";

        notifyObserver();
        return res;
    }

    public String kassaBonPrintModel(){
        String headerlijn = "";
        String footerlijn = "";


        if (instellingenController.getIngevuldeProperty("headerlijn") != null){
            for (SoortHeaderLijn e: SoortHeaderLijn.values()){
                if (instellingenController.getIngevuldeProperty("headerlijn").equalsIgnoreCase(e.toString())){
                    headerlijn +="-----------------------------------------------------------------------------------------------------";
                    headerlijn += "\nDATUM BETALING: ";
                    //GET DATE + TIME
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    headerlijn+= dtf.format(now) + "\n";
                    break;
                } else {
                    headerlijn = instellingenController.getIngevuldeProperty("headerlijn");
                }
            }
        }

        if (instellingenController.getIngevuldeProperty("footerlijn") != null){
            for (SoortFooterLijn e: SoortFooterLijn.values()){
                if (instellingenController.getIngevuldeProperty("footerlijn").equalsIgnoreCase(SoortFooterLijn.values()[0].toString())){
                    footerlijn += "Prijs zonder korting:" + "\t\t" + getTotPrijs() + " €" + "\n";
                    footerlijn += "Betaald (inclusief korting): " + getEindPrijs() + " €" + "\n";
                    //Kassabon kassabon1 = new FooterDecorator(new TekstKassabonLezer());
                    //footerlijn += kassabon1.toString();


                    break;

                } else if (instellingenController.getIngevuldeProperty("footerlijn").equalsIgnoreCase(SoortFooterLijn.values()[1].toString())){
                    footerlijn += "Prijs zonder korting:" + "\t\t" + getTotPrijs() + " €" + "\n";
                    footerlijn += "Prijs inclusief BTW:" + "\t\t" + getTotprijsMetBTW() + " €" + "\n";
                    break;
                } else {
                    footerlijn = instellingenController.getIngevuldeProperty("footerlijn");
                }
            }

        }

        //Kassabon kassabon1 = new HeaderDecorator(new FooterDecorator(new TekstKassabonLezer()));
        //System.out.println(kassabon1.toString());



        String res = "";
        res += "\nGEKOCHTE GOEDEREN: \n";
        res += "Omschrijving          Aantal  Prijs\n"; //5tabs, 1tab
        String sterretjes = "***********************************";
        res += sterretjes + "\n";
        for(Artikel artikel : this.kassaKlantList){
            res += artikel.kassabonPrint();
        }
        res += sterretjes + "\n";

        return headerlijn + res  + footerlijn;
    }

    public void nieuwVenster() {
        artikelList.clear();
        for (Artikel a: kassaKlantList){
            a.setAantal(0);
        }
        kassaKlantList.clear();

        notifyObserver();
    }

    public void werkStockBij() {
        ArrayList<Artikel> newStock = new ArrayList<>();
        ArrayList<Artikel> alleArtikelen = new ArrayList<>(artikelDBContext.getArtikels());

        for(Artikel artikel : this.artikelList){
            int nieuweStok = artikel.getStock();
            artikel.setStock(nieuweStok);
            newStock.add(artikel);
        }

        for (Artikel a: alleArtikelen){
            for (Artikel b: newStock){
                if (a.equals(b)){
                    a.setStock(b.getStock());
                }
            }
        }


        artikelDBContext.save(alleArtikelen);
        artikelDBContext.setData(alleArtikelen);

        notifyObserver();
    }

    public void resetOnHoldListAls3keerBetaald(){
        if (!this.onHoldList.isEmpty()){
            if (onHoldTeller == 2){
                onHoldList.clear();
                kassaKlantListOnHold.clear();
                onHoldTeller = 0;
                System.out.println("OnHold list wordt nu leeggemaakt");
            } else {
                this.onHoldTeller++;
            }
            notifyObserver();
        }
    }

    public void setVerkoopState(VerkoopState verkoopState) {
        this.verkoopState = verkoopState;
    }

    public double getDuursteArtikel(){
        Artikel res = this.artikelList.get(0);

        for (Artikel a: this.artikelList){
            if (res.getPrijs() <= a.getPrijs()){
                res = a;
            }
        }
        notifyObserver();
        return res.getPrijs();

    }

    public String getKortingStrategieString(KortingStrategie kortingStrategie) {
        return kortingStrategie.geefKorting();
    }

    public void setKortingStrategie(KortingStrategie kortingStrategie) {
        this.kortingStrategie = kortingStrategie;
    }


    public double getKortingBedrag(){
        InputStream in = null;
        try {
            in = new FileInputStream(new File("src" + File.separator + "bestanden" + File.separator + "KassaApp.properties"));
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.kortingBedrag =  Double.parseDouble(properties.getProperty("Kortingsbedrag"));
        return this.kortingBedrag;
    }

    public double getEindPrijs() {

        double totprijs = getTotPrijs();

        if(totprijs >= this.kortingBedrag){
            double percent = this.kortingpercent;
            double korting = (percent*totprijs)/100;
            return totprijs-korting;
        }else{
            return totprijs;
        }
    }

    public double getKorting(){
        InputStream in = null;
        try {
            in = new FileInputStream(new File("src" + File.separator + "bestanden" + File.separator + "KassaApp.properties"));
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.kortingpercent = Double.parseDouble(properties.getProperty("Kortingspercent"));
        return this.kortingpercent;
    }

    public double getTotprijsMetBTW(){
        return getTotPrijs()*1.06;
    }


}
