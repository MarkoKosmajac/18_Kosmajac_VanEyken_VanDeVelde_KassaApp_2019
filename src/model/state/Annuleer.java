package model.state;

import model.ArtikelModel;

public class Annuleer implements KassaState{
    private ArtikelModel artikelModel;


    public Annuleer(ArtikelModel artikelModel) {
        this.artikelModel = artikelModel;
    }

    public Annuleer() {
        System.out.println("Annuleer state");
    }

    @Override
    public void Betaald() {

    }

    @Override
    public void Annuleer() {

    }
}
