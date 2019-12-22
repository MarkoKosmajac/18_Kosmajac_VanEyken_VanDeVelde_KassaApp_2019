package model.decorator;

import model.Artikel;
import model.ArtikelModel;

import java.util.ArrayList;

public class TekstKassabonLezer implements Kassabon{
    protected ArtikelModel artikelModel;

    public TekstKassabonLezer(ArtikelModel artikelModel){
        this.artikelModel = artikelModel;
    }


    public String toString() {
        return artikelModel.kassaBonPrintModelString(artikelModel.getArtikelList());
    }

    public ArrayList<Artikel> getArtikelArrayList(){
        return artikelModel.getArtikelList();
    }

    public double getTotprijsMetBTW() {
        double res = 0;

        for (Artikel a: getArtikelArrayList()){
            res += a.getPrijs();
        }
        return res*1.06;
    }

    public double getEindPrijs() {
        double res = 0;

        for (Artikel a: getArtikelArrayList()){
            res += a.getPrijs();
        }
        return res;
    }

    public double getTotPrijs(){
        double res = 0;

        for (Artikel a: getArtikelArrayList()){
            res += a.getPrijs();
        }
        return res;
    }


}
