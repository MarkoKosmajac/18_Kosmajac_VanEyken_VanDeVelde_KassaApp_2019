package model.observer;

import model.Artikel;

public interface Subject {

    //will handle adding, updating and deleting all the observers
    void register(Observer obs);
    void unregister(Observer o);
    void notifyObserver();

    void updateByAddArtikel(Artikel nieuwArtikel); //TODO: add een artikel aan een list, daarna notifyObservers() in DIE METHODE! callen
    void updateByRemoveArtikel(int index); //TODO: index mee, anders verwijdert die altijd t laatste

}
