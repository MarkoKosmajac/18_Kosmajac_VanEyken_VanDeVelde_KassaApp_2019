package model.state;

import model.ArtikelModel;

/**
 * @author Max Van De Velde
 */

public class OnHold implements VerkoopState {
    private ArtikelModel artikelModel;

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
