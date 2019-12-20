package model.state;

import model.ArtikelModel;

public class Pauze implements KassaState{
    private ArtikelModel artikelModel;


    public Pauze(ArtikelModel artikelModel) {
        this.artikelModel = artikelModel;
    }

    @Override
    public void Betaald() {

    }

    @Override
    public void Annuleer() {

    }
}
