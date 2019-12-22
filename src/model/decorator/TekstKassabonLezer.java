package model.decorator;

import model.ArtikelModel;

public class TekstKassabonLezer implements Kassabon{
    protected ArtikelModel artikelModel;

    public TekstKassabonLezer(){
        //artikelModel = new ArtikelModel();

    }

   public String toString() {
        String res = artikelModel.kassaBonPrintModel();
        return res;
    }


}
