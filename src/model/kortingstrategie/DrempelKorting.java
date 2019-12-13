package model.kortingstrategie;

/**
 * @author Marko Kosmajac
 */

public class DrempelKorting implements KortingStrategie {

    private int procent;
    private double bedrag;

    public DrempelKorting() {
        this.procent = 0;
        this.bedrag = 0;
    }

    public int getProcent() {
        return procent;
    }

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

}
