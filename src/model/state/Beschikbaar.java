package model.state;

import model.ArtikelModel;

public class Beschikbaar implements VerkoopState {
    private ArtikelModel artikelModel;


    public Beschikbaar() {
        System.out.println("Beschikbaar state");
    }

    @Override
    public void Betaald() {

    }

    @Override
    public void Annuleer() {

    }
}
