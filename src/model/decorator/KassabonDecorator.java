package model.decorator;

import controller.InstellingenController;
import model.Artikel;
import model.ArtikelModel;

import java.util.Properties;

public abstract class KassabonDecorator implements Kassabon{

    protected Kassabon kassabon;


    public KassabonDecorator(Kassabon kassabon){

        this.kassabon = kassabon;

    }

    public Kassabon getKassabon(){
        return this.kassabon;
    }



    @Override
    public String toString() {
        return getKassabon().toString();
    }
}
