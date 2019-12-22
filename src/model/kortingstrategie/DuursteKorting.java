package model.kortingstrategie;

import controller.InstellingenController;
import model.ArtikelModel;

/**
 * @author Marko Kosmajac
 */

public class DuursteKorting implements KortingStrategie {

    private ArtikelModel artikelModel;
    private int procent;
    private double bedrag;
    private InstellingenController instellingenController;

    public DuursteKorting(int procent, double bedrag) {
        artikelModel = new ArtikelModel();
        setProcent(0);
        setBedrag(bedrag);

        instellingenController = new InstellingenController();
        System.out.println("Duurstekorting toepassen");
        this.setPropertiesKorting();
    }

    @Override
    public int getProcent() {
        return procent;
    }

    @Override
    public void setProcent(int procent) {
        this.procent = procent;
    }

    @Override
    public void setPropertiesKorting() {
        instellingenController.setPropertiesKeuzeKorting("DuursteKorting",getProcent(),artikelModel.getDuursteArtikel());
    }

    @Override
    public double getBedrag() {
        return 0;
    }

    public void setBedrag(double bedrag) {
        this.bedrag = bedrag;
    }

    @Override
    public String geefKorting() {
        return artikelModel.getDuursteArtikel() + " euro korting op duurste artikel uit winkelkar.";
    }
}
