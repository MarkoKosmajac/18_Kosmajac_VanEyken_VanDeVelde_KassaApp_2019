package model.kortingstrategie;

/**
 * @author Marko Kosmajac
 */

public class KortingKeuze {
    KortingStrategie kortingStrategie;

    public KortingKeuze(KortingStrategie strategy) {
        this.kortingStrategie = strategy;
    }

    public KortingStrategie getKortingStrategie() {
        return kortingStrategie;
    }

    public void setKortingStrategie(KortingStrategie kortingStrategie) {
        this.kortingStrategie = kortingStrategie;
    }

    public String geefKorting(){
        return kortingStrategie.geefKorting();
    }
}

