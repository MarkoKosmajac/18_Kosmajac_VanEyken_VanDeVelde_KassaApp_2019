package model.kortingstrategie;

/**
 * @author Marko Kosmajac
 */

public class DuursteKorting implements KortingStrategie {

    private int procent;

    public DuursteKorting() {
        this.procent = 0;
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
    public String geefKorting() {
        return getProcent() + "% korting op duurste artikel uit winkelkar.";
    }
}
