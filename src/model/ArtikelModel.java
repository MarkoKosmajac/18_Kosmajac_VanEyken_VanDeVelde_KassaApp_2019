package model;

import model.observer.Observer;
import model.observer.Subject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

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
        this.artikelList.addAll(this.onHoldList);
        this.onHoldList.clear();
        notifyObserver();
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
}
