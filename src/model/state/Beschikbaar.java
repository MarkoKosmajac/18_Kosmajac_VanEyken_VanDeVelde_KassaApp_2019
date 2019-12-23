package model.state;

import model.ArtikelModel;

/**
 * @author Max Van De Velde
 */

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
