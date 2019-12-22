package model;

import database.ArtikelDBContext;
import database.DBException;
import model.kortingstrategie.KortingStrategie;
import model.observer.Observer;
import model.observer.Subject;
import model.state.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Max Van De Velde, Marko Kosmajac
 */


public class ArtikelModel implements Subject {

    private Collection<Observer> kassaObserver;
    private ArrayList<Artikel> artikelList,onHoldList, kassaKlantList, kassaKlantListOnHold;
    private int onHoldTeller;
    private ArtikelDBContext artikelDBContext;
    private VerkoopState verkoopState;
    private KortingStrategie kortingStrategie;





    public ArtikelModel() {
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
        return tot;
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

    /*public String kassaBonPrintModel(String eindtotaal){
        String res = "Omschrijving          Aantal  Prijs\n"; //5tabs, 1tab
        String sterretjes = "***********************************";
        res += sterretjes + "\n";
        for(Artikel artikel : this.kassaKlantList){
            res += artikel.kassabonPrint();
        }
        res += sterretjes + "\n";
        res += "Betaald (inclusief korting): " + eindtotaal + " €";
        return res;
    }*/

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

        System.out.println("-----NIEUWE STOCK--------");
        System.out.println(artikelDBContext.loadData());
        notifyObserver();
    }

    public void resetOnHoldListAls3keerBetaald(){
        if (!this.onHoldList.isEmpty()){
            if (onHoldTeller == 2){
                onHoldList.clear();
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
}
