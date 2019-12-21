package model.state;

import model.ArtikelModel;

public class Annuleer implements VerkoopState {
    private ArtikelModel artikelModel;


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
