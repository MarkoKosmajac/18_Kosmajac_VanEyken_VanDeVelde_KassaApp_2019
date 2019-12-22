package model.decorator;

import controller.InstellingenController;
import model.Artikel;
import model.ArtikelModel;

import java.util.Properties;

public abstract class KassabonDecorator implements Kassabon{

    protected Kassabon kassabon;
    protected InstellingenController instellingenController;


    public KassabonDecorator(Kassabon kassabon){
        instellingenController = new InstellingenController();

        this.kassabon = kassabon;

    }

    /*public Kassabon getKassabon(){
        return this.kassabon;
    }*/



    @Override
    public String toString() {
        //return getKassabon().toString();
        return super.toString();
    }
}
