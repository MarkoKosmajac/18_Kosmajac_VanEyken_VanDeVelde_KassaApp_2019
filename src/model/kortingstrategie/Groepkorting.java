package model.kortingstrategie;

/**
 * @author Marko Kosmajac
 */

public class Groepkorting implements KortingStrategie {

    private int procent;

    public Groepkorting() {
        this.procent = 0;
    }

    public int getProcent() {
        return procent;
    }

    public void setProcent(int procent) {
        this.procent = procent;
    }

    @Override
    public String geefKorting() {
        return getProcent() + "% korting op alle artikelen van een bepaalde groep.";
    }
}
