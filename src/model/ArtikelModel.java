package model;

import model.observer.Observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArtikelModel {


    private Collection<Observer> kassaObserver;
    private List<Artikel> artikelList,onHoldList;

    public ArtikelModel() {
        kassaObserver = new ArrayList<>();
        artikelList = new ArrayList<>();
        onHoldList = new ArrayList<>();
    }


}
