package model.state;

import model.ArtikelModel;

public class Onbeschikbaar implements KassaState {
    private ArtikelModel artikelModel;

    public Onbeschikbaar(ArtikelModel artikelModel) {
        this.artikelModel = artikelModel;
    }

    @Override
    public void Betaald() {

    }

    @Override
    public void Annuleer() {

    }
}
