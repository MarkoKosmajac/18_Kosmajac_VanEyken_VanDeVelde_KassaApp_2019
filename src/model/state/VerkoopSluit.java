package model.state;

/**
 * @author Max Van De Velde
 */

public class VerkoopSluit implements VerkoopState {

    public VerkoopSluit() {
        System.out.println("VerkoopsluitState");
    }

    @Override
    public void Betaald() {

    }

    @Override
    public void Annuleer() {

    }
}
