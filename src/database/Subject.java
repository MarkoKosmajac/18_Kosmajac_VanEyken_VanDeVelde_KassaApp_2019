package database;

import java.util.Observer;

public interface Subject {

    void register(Observer o);
    void unregister(Observer o);
    void notifyObserver();

}
