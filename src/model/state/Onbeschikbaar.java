package model.state;

import model.ArtikelModel;

/**
 * @author Max Van De Velde
 */

public class Onbeschikbaar implements VerkoopState {
    private ArtikelModel artikelModel;


    public Onbeschikbaar() {
    }

    @Override
    public void Betaald() {

    }

    @Override
    public void Annuleer() {

    }
}
