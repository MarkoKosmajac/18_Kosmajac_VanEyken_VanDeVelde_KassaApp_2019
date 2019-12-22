package model.decorator;

import model.Artikel;
import model.ArtikelModel;

public class FooterDecorator extends KassabonDecorator{

    private TekstKassabonLezer tekstKassabonLezer;

    public FooterDecorator(ArtikelModel artikelModel,Kassabon kassabon) {
        super(kassabon);
        tekstKassabonLezer = new TekstKassabonLezer(artikelModel);


    }

    @Override
    public String toString() {

        String footerlijn = "";

        if (instellingenController.getIngevuldeProperty("footerlijn") != null){
            for (SoortFooterLijn e: SoortFooterLijn.values()){
                if (instellingenController.getIngevuldeProperty("footerlijn").equalsIgnoreCase(SoortFooterLijn.values()[0].toString())){
                    footerlijn += "Prijs zonder korting:" + "\t\t" + getTotPrijs() + " €" + "\n";
                    footerlijn += "Betaald (inclusief korting): " + getEindPrijs() + " €" + "\n";
                    //Kassabon kassabon1 = new FooterDecorator(new TekstKassabonLezer());
                    //footerlijn += kassabon1.toString();


                    break;

                } else if (instellingenController.getIngevuldeProperty("footerlijn").equalsIgnoreCase(SoortFooterLijn.values()[1].toString())){
                    footerlijn += "Prijs zonder korting:" + "\t\t" + getTotPrijs() + " €" + "\n";

                    footerlijn += "Prijs inclusief BTW:" + "\t\t" + getBTW() + " €" + "\n";
                    break;
                } else {
                    footerlijn = instellingenController.getIngevuldeProperty("footerlijn");
                }
            }

        }

        return super.toString() +  "\n" + footerlijn;
    }

    public double getBTW() {
        double res = 0;

        for (Artikel a: tekstKassabonLezer.getArtikelArrayList()){
            res += a.getPrijs();
        }
        return Math.floor(res/100*6*100)/100;
    }

    public double getEindPrijs() {
        double res = 0;

        for (Artikel a: tekstKassabonLezer.getArtikelArrayList()){
            res += a.getPrijs();
        }
        return res;
    }

    public double getTotPrijs(){
        double res = 0;

        for (Artikel a: tekstKassabonLezer.getArtikelArrayList()){
            res += a.getPrijs();
        }
        return res;
    }
}
