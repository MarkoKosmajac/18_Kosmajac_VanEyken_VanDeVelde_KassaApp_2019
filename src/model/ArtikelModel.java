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
    private ArrayList<Artikel> artikelList,onHoldList;
    private HashSet hs = new HashSet();

    public ArtikelModel() {
        kassaObserver = new ArrayList<>();
        artikelList = new ArrayList<>();
        onHoldList = new ArrayList<>();
    }

    public void veranderAantalPositief(Artikel artikel){
        int index = artikelList.indexOf(artikel);
        artikelList.get(index).setAantal(artikel.getAantal()+1);
        notifyObserver();
    }

    public void veranderAantalNegatief(Artikel artikel){
        int index = artikelList.indexOf(artikel);
        artikelList.get(index).setAantal(artikel.getAantal()-1);
        notifyObserver();
    }


    public void addToLijst(Artikel artikel) {
        artikelList.add(artikel);
        veranderAantalPositief(artikel);
        System.out.println(artikel.getOmschrijving() + " toegevoegd aan lijst.");
        notifyObserver();
    }

    public void verwijderVanLijst(Artikel artikel){
        artikelList.remove(artikel);
        veranderAantalNegatief(artikel);
        System.out.println(artikel.getOmschrijving() + " verwijderd uit lijst.");
        notifyObserver();
    }

    public double getTotPrijs(){
        double tot = 0.0;
        for(Artikel a : artikelList){
            if(a != null){
                tot += a.getPrijs();
            }
        }
        System.out.println("Totaalbedrag geupdate!");
        //notifyObserver();//TODO: vergeten!!!
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
