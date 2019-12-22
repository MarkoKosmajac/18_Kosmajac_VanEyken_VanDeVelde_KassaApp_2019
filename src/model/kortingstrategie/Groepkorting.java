package model.kortingstrategie;

import controller.InstellingenController;

/**
 * @author Marko Kosmajac, Phonkrit Van de Velde
 */

public class Groepkorting implements KortingStrategie {

    private int percent;
    private double bedrag;
    private InstellingenController instellingenController;


    public Groepkorting(int percent, double bedrag) {
        setProcent(percent);
        setBedrag(bedrag);

        instellingenController = new InstellingenController();
        System.out.println("Groepkorting toepassen");
        this.setPropertiesKorting();
    }

    @Override
    public int getProcent() {
        return percent;
    }

    @Override
    public void setProcent(int procent) {
            this.percent = procent;
    }

    @Override
    public void setPropertiesKorting() {
        instellingenController.setPropertiesKeuzeKorting("GROEPKORTING", getProcent(), getBedrag());
    }

    public void setBedrag(double bedrag) {
        this.bedrag = bedrag;
    }

    @Override
    public double getBedrag() {
        return bedrag;
    }

    @Override
    public String geefKorting() {
        return getProcent() + "% korting op alle artikelen van een bepaalde groep.";
    }
}
