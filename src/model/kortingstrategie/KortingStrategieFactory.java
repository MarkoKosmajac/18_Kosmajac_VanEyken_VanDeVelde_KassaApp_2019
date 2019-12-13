package model.kortingstrategie;

/**
 * @author Marko Kosmajac
 */

public class KortingStrategieFactory {

    public KortingStrategie makeKortingStrategie(String kortingstrategie){
        if(kortingstrategie.equalsIgnoreCase("DREMPELKORTING")){
            return new DrempelKorting();
        } else if(kortingstrategie.equalsIgnoreCase("DUURSTEKORTING")){
            return new DuursteKorting();
        } else if(kortingstrategie.equalsIgnoreCase("GROEPKORTING")) {
            return new Groepkorting();
        } else return null;
    }

}
