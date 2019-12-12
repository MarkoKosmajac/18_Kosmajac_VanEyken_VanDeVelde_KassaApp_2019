package model;

import model.observer.Observer;
import model.observer.Subject;

import java.util.ArrayList;
import java.util.Collection;

public class ArtikelModel implements Subject {


    private Collection<Observer> kassaObserver;
    private ArrayList<Artikel> artikelList,onHoldList;

    public ArtikelModel() {
        kassaObserver = new ArrayList<>();
        artikelList = new ArrayList<>();
        onHoldList = new ArrayList<>();
    }

    public void addToLijst(Artikel artikel) {
        artikelList.add(artikel);
        int index = artikelList.indexOf(artikel);
        artikelList.get(index).setAantal(artikel.getAantal()+1);
        notifyObserver();
        System.out.println(artikel.getOmschrijving() + " toegevoegd aan lijst.");
    }

    public void verwijderVanLijst(Artikel artikel){
        artikelList.remove(artikel);
        int index = artikelList.indexOf(artikel);
        artikelList.get(index).setAantal(artikel.getAantal()-1);
        notifyObserver();
        System.out.println(artikel.getOmschrijving() + " verwijderd uit lijst.");
    }

    public double getTotPrijs(){
        double tot = 0.0;
        for(Artikel a : artikelList){
            if(a != null){
                tot += a.getPrijs();
            }
        }
        System.out.println("Totaalbedrag geupdate!");
        notifyObserver();//TODO: vergeten!!!
        return tot;
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
}
