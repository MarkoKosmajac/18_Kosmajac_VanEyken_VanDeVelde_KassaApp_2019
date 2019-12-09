package model.observer;

import model.Artikel;

public interface Subject {

    //will handle adding, updating and deleting all the observers
    public void register(Observer obs);
    public void unregister(Observer o);
    public void notifyObserver();

    public void updateByAddArtikel(Artikel nieuwArtikel); //TODO: add een artikel aan een list, daarna notifyObservers() in DIE METHODE! callen
    public void updateByRemoveArtikel(int index); //TODO: index mee, anders verwijdert die altijd t laatste

}
