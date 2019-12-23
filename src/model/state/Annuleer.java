package model.state;

import model.ArtikelModel;

/**
 * @author Max Van De Velde
 */

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
