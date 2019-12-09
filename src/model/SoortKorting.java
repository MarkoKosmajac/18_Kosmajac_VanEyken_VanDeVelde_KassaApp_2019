package model;

import java.util.ArrayList;

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

    public String toString(){ /*Modify toString to return number also (shows in javafx popup box)*/
        return label;
    }


}
