package model.decorator;

import model.Artikel;

public class PlainKassaBon implements Kassabon {
    private Artikel artikel;

    @Override
    public String toString() {
        return artikel.toString();
    }
}
