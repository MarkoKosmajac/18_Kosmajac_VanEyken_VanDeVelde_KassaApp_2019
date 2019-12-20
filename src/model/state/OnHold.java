package model.state;

import model.ArtikelModel;

public class OnHold implements KassaState {
    private ArtikelModel artikelModel;

    public OnHold(ArtikelModel artikelModel) {
        this.artikelModel = artikelModel;
    }

    public OnHold() {
        System.out.println("OnHold state");
    }

    @Override
    public void Betaald() {

    }

    @Override
    public void Annuleer() {

    }
}
