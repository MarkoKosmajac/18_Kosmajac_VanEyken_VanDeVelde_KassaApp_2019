package model;

import model.observer.Observer;
import model.observer.Subject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArtikelModel implements Subject {


    private Collection<Observer> kassaObserver;
    private ArrayList<Artikel> artikelList,onHoldList;

    public ArtikelModel() {
        kassaObserver = new ArrayList<>();
        artikelList = new ArrayList<>();
        onHoldList = new ArrayList<>();
    }

    public void addToWinkelMandje(Artikel artikel) {
        artikelList.add(artikel);
        notifyObserver();
        System.out.println("wordt uitgevoerd");
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

    @Override
    public void updateByAddArtikel(Artikel nieuwArtikel) {

    }

    @Override
    public void updateByRemoveArtikel(int index) {

    }
}