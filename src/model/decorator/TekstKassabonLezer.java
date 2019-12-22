package model.decorator;

import model.ArtikelModel;

public class TekstKassabonLezer implements Kassabon{
    private ArtikelModel artikelModel;

    public TekstKassabonLezer(){
        artikelModel = new ArtikelModel();

    }

    public String toString() {
        return artikelModel.kassaBonPrintModel();
    }


}
