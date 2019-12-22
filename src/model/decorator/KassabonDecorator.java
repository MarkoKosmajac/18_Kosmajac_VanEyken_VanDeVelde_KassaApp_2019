package model.decorator;

import model.Artikel;
import model.ArtikelModel;

public abstract class KassabonDecorator implements Kassabon{

    private Kassabon kassabon;
    private ArtikelModel artikelModel;

    public KassabonDecorator(Kassabon kassabon){
        artikelModel = new ArtikelModel();
        this.kassabon = kassabon;
    }

    public Kassabon getKassabon(){
        return this.kassabon;
    }

    public String printBon(){
        return artikelModel.kassaBonPrintModel(String.valueOf(artikelModel.getEindTotaal()));
    }

    @Override
    public String toString() {
        return kassabon.printBon();
    }
}
