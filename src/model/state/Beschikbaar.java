package model.state;

import model.ArtikelModel;

public class Beschikbaar implements KassaState {
    private ArtikelModel artikelModel;

    public Beschikbaar(ArtikelModel artikelModel) {
        this.artikelModel = artikelModel;
    }

    @Override
    public void Betaald() {

    }

    @Override
    public void Annuleer() {

    }
}
