package model.kortingstrategie;

/**
 * @author Marko Kosmajac, Phonkrit Van de Velde
 */

public class KortingStrategieFactory {
    KortingStrategie kortingStrategie;

    public KortingStrategie makeKortingStrategie(String kortingstrategie){
        if(kortingstrategie.equalsIgnoreCase("DREMPELKORTING")){
            return new DrempelKorting(this.kortingStrategie.getProcent(), this.kortingStrategie.getBedrag());
        } else if(kortingstrategie.equalsIgnoreCase("DUURSTEKORTING")){
            return new DuursteKorting(this.kortingStrategie.getProcent(), this.kortingStrategie.getBedrag());
        } else if(kortingstrategie.equalsIgnoreCase("GROEPKORTING")) {
            return new Groepkorting(this.kortingStrategie.getProcent(), this.kortingStrategie.getBedrag());
        } else return null;
    }

}
