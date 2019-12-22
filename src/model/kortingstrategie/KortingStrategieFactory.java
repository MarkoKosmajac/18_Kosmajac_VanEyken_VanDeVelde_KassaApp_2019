package model.kortingstrategie;

import database.ArtikelDBContext;
import model.ArtikelDBStrategyFactory;

/**
 * @author Marko Kosmajac, Phonkrit Van de Velde
 */

public class KortingStrategieFactory {
    KortingStrategie kortingStrategie;

    private static KortingStrategieFactory uniqueInstance;

    private KortingStrategieFactory(){

    }

    public KortingStrategie makeKortingStrategie(String kortingstrategie){
        if(kortingstrategie.equalsIgnoreCase("DREMPELKORTING")){
            return new DrempelKorting(this.kortingStrategie.getProcent(), this.kortingStrategie.getBedrag());
        } else if(kortingstrategie.equalsIgnoreCase("DUURSTEKORTING")){
            return new DuursteKorting(this.kortingStrategie.getProcent(), this.kortingStrategie.getBedrag());
        } else if(kortingstrategie.equalsIgnoreCase("GROEPKORTING")) {
            return new Groepkorting(this.kortingStrategie.getProcent(), this.kortingStrategie.getBedrag());
        } else return null;
    }

    public static synchronized KortingStrategieFactory getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new KortingStrategieFactory();
        }
        return uniqueInstance;
    }

}
