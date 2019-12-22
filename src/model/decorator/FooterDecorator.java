package model.decorator;

import model.ArtikelModel;
import model.SoortFooterLijn;

public class FooterDecorator extends KassabonDecorator{

    private ArtikelModel artikelModel = new ArtikelModel();



    public FooterDecorator(Kassabon kassabon) {
        super(kassabon);
    }

    @Override
    public String toString() {

        String footerlijn = "";

        if (instellingenController.getIngevuldeProperty("footerlijn") != null){
            for (SoortFooterLijn e: SoortFooterLijn.values()){
                if (instellingenController.getIngevuldeProperty("footerlijn").equalsIgnoreCase(SoortFooterLijn.values()[0].toString())){
                    footerlijn += "Prijs zonder korting:" + "\t\t" + artikelModel.getTotPrijs() + " €" + "\n";
                    footerlijn += "Betaald (inclusief korting): " + artikelModel.getEindPrijs() + " €" + "\n";
                    //Kassabon kassabon1 = new FooterDecorator(new TekstKassabonLezer());
                    //footerlijn += kassabon1.toString();


                    break;

                } else if (instellingenController.getIngevuldeProperty("footerlijn").equalsIgnoreCase(SoortFooterLijn.values()[1].toString())){
                    footerlijn += "Prijs zonder korting:" + "\t\t" + artikelModel.getTotPrijs() + " €" + "\n";
                    footerlijn += "Prijs inclusief BTW:" + "\t\t" + artikelModel.getTotprijsMetBTW() + " €" + "\n";
                    break;
                } else {
                    footerlijn = instellingenController.getIngevuldeProperty("footerlijn");
                }
            }

        }

        return super.toString() +  "\n" + footerlijn;

    }
}
