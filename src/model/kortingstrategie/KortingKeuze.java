package model.kortingstrategie;

/**
 * @author Marko Kosmajac
 */

//RANDOM JAVA KLASSE, waar je dus een strategie en factory meegeeft
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

