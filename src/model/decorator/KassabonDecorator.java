package model.decorator;

import model.Artikel;
import model.ArtikelModel;

public abstract class KassabonDecorator implements Kassabon{

    private Kassabon kassabon;
    private ArtikelModel artikelModel = new ArtikelModel();

    public KassabonDecorator(Kassabon kassabon){
        this.kassabon = kassabon;
    }

    public Kassabon getKassabon(){
        return this.kassabon;
    }

    public String printBon(){
        return "e"; //artikelModel.kassaBonPrintModel();
    }

}
