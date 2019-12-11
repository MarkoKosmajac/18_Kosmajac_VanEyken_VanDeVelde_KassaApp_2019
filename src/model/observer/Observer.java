package model.observer;

import model.Artikel;

import java.util.ArrayList;

public interface Observer {

    void update(ArrayList<Artikel> artikellijst);

}
