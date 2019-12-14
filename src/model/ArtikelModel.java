package model;

import model.observer.Observer;
import model.observer.Subject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Max Van De Velde, Marko Kosmajac
 */


public class ArtikelModel implements Subject {

    private Collection<Observer> kassaObserver;
    private ArrayList<Artikel> artikelList,onHoldList, kassaKlantList;

    public ArtikelModel() {
        kassaObserver = new ArrayList<>();
        artikelList = new ArrayList<>();
        onHoldList = new ArrayList<>();
        kassaKlantList = new ArrayList<>();
    }

    public void veranderAantalPositief(Artikel artikel){
        int index = kassaKlantList.indexOf(artikel);
        kassaKlantList.get(index).setAantal(artikel.getAantal()+1);
        notifyObserver();

    }
    public void veranderAantalNegatief(Artikel artikel){
        int index = kassaKlantList.indexOf(artikel);
        kassaKlantList.get(index).setAantal(artikel.getAantal()-1);
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
            this.artikelList.clear();
            notifyObserver();
        } else {
            System.out.println("Er mag maar 1 list tegelijk on hold gezet worden");
        }
    }

    public void returnToPreviousList(){
        if (!this.onHoldList.isEmpty()){
            System.out.println("Moet error message komen dat onHold afgerekent moet worden");
        } else {
            this.artikelList.addAll(this.onHoldList);
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

        notifyObserver();//TODO: MOET DIT HIER OOK ?
        return res;
    }

    public void nieuwVenster() {
        artikelList.clear();
        kassaKlantList.clear();
        notifyObserver();//TODO: MOET DIT HIER OOK ?
    }

    public void werkStockBij() {//todo: werkt, nu nog save() methode oproepen somehow? of via pane...
        for(Artikel artikel : this.artikelList){
            int nieuweStok = artikel.getStock()-1;
            artikel.setStock(nieuweStok);
        }
        notifyObserver();//TODO: MOET DIT HIER OOK ?
    }


}
