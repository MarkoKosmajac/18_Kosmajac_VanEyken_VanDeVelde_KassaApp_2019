package model.decorator;

import controller.InstellingenController;
import controller.KassaController;
import model.Artikel;
import model.ArtikelModel;

import java.util.Properties;

/**
 * @author Max Van De Velde, Marko Kosmajac
 */

public abstract class KassabonDecorator implements Kassabon{

    private Kassabon kassabon;
    protected InstellingenController instellingenController;



    public KassabonDecorator(Kassabon kassabon){

        this.kassabon = kassabon;
        instellingenController = new InstellingenController();



    }

    public Kassabon getKassabon(){
        return this.kassabon;
    }



    @Override
    public String toString() {
        return kassabon.toString();
    }
}
