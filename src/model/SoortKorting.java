package model;

/**
 * @author Marko Kosmajac
 */

public enum SoortKorting {

    GROEPKORTING("Groepkorting"),
    DREMPELKORTING("Drempelkorting"),
    DUURSTEKORTING("Duurstekorting");

    private String label;

    SoortKorting(String label){
        this.label = label;
    }

    public String toString(){
        return label;
    }

}
