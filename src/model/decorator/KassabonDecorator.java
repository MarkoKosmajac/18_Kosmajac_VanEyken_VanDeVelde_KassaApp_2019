package model.decorator;

import controller.InstellingenController;
import model.Artikel;
import model.ArtikelModel;

import java.util.Properties;

public abstract class KassabonDecorator implements Kassabon{

    protected Kassabon kassabon;
    private ArtikelModel artikelModel;
    private Properties properties;
    private InstellingenController instellingenController;

    public KassabonDecorator(Kassabon kassabon){
        instellingenController = new InstellingenController();
        this.properties = new Properties();
        artikelModel = new ArtikelModel();
        this.kassabon = kassabon;
        this.instellingenController.geefPathFile();
    }

    public Kassabon getKassabon(){
        return this.kassabon;
    }



    @Override
    public String toString() {
        return kassabon.toString();
    }
}
