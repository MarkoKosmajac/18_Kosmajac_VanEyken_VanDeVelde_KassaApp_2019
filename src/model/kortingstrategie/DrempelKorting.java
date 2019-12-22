package model.kortingstrategie;

import controller.InstellingenController;

/**
 * @author Marko Kosmajac, Phonkrit Van de Velde
 */

public class DrempelKorting implements KortingStrategie {

    private int procent;
    private double bedrag;
    private InstellingenController instellingenController;

    public DrempelKorting(int procent, double bedrag) {
        setBedrag(bedrag);
        setProcent(procent);

        instellingenController = new InstellingenController();
        System.out.println("DrempelKorting toepassen");
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

    public double getBedrag() {
        return bedrag;
    }

    public void setBedrag(double bedrag) {
        this.bedrag = bedrag;
    }

    @Override
    public String geefKorting() {
        return getProcent() + "% korting op een aankoopbedrag hoger dan " + getBedrag() + " euro.";
    }

    @Override
    public void setPropertiesKorting(){
        instellingenController.setPropertiesKeuzeKorting("DREMPELKORTING", getProcent(),getBedrag());
    }



}
