package model.observer;

/**
 * @author Max Van De Velde, Marko Kosmajac
 */

public interface Subject {

    //will handle adding, updating and deleting all the observers
    void register(Observer obs);
    void unregister(Observer o);
    void notifyObserver();

}
