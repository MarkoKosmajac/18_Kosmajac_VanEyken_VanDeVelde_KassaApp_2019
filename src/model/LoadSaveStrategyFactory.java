package model;

import database.ArtikelLoadSaveExcel;
import database.ArtikelLoadSaveTekst;
import model.kortingstrategie.KortingStrategieFactory;

/**
 * @author Marko Kosmajac
 */

public class LoadSaveStrategyFactory {

    private static LoadSaveStrategyFactory uniqueInstance;

    private LoadSaveStrategyFactory(){

    }

    public LoadSaveStrategy makeLoadSaveStrategy(String loadSaveStrategy){
        if(loadSaveStrategy.equalsIgnoreCase("TEKSTBESTAND")){
            return new ArtikelLoadSaveTekst();

        } else if(loadSaveStrategy.equalsIgnoreCase("EXCELBESTAND")){
            return new ArtikelLoadSaveExcel();

        } else return null;
    }

    public static synchronized LoadSaveStrategyFactory getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new LoadSaveStrategyFactory();
        }
        return uniqueInstance;
    }

}
