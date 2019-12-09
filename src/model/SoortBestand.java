package model;

/**
 * @author Marko Kosmajac
 */

public enum SoortBestand {

    EXCELBESTAND("Excel bestand"),
    TEKSTBESTAND("Tekst bestand");

    private String label;

    SoortBestand(String label){
        this.label = label;
    }

    public String toString(){
        return label;
    }

}
