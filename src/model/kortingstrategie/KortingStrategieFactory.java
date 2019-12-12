package model.kortingstrategie;

/**
 * @author Marko Kosmajac
 */

public class KortingStrategieFactory {

    public KortingStrategie makeKortingStrategie(String kortingstrategie){
        if(kortingstrategie.equalsIgnoreCase("Drempelkorting")){
            return new DrempelKorting();
        } else if(kortingstrategie.equalsIgnoreCase("Duurstekorting")){
            return new DuursteKorting();
        } else if(kortingstrategie.equalsIgnoreCase("Groepkorting")) {
            return new Groepkorting();
        } else return null;
    }

}
