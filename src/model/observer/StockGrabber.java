package model.observer;

import model.Artikel;

import java.util.ArrayList;
import java.util.List;

public class StockGrabber implements Subject {

    private ArrayList<Observer> observers;
    private Artikel artikel;
    private ArrayList<Artikel> winkelmandje;

    public StockGrabber(){
        this.winkelmandje = new ArrayList<>();
        observers = new ArrayList<Observer>();

    }

    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);
        System.out.println("Added a new observer!");
    }

    @Override
    public void unregister(Observer deleteObserver) {
        int observerIndex = observers.indexOf(deleteObserver);

        System.out.println("Observer: " + observerIndex + 1 + " deleted.");

        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {
        //cycles through all observers and notifies them of any Artikel changes
        for(Observer observer : observers){
            observer.update(winkelmandje);
        }
    }

    @Override
    public void updateByAddArtikel(Artikel nieuwArtikel) {
        this.winkelmandje.add(nieuwArtikel);
        notifyObserver();
    }

    @Override
    public void updateByRemoveArtikel(int index) {
        this.winkelmandje.remove(index);
        notifyObserver();
    }

}
