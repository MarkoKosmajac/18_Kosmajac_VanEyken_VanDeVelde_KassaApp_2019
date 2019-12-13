package model;

import database.ArtikelLoadSaveExcel;
import database.ArtikelLoadSaveTekst;

/**
 * @author Marko Kosmajac
 */

public class LoadSaveStrategyFactory {

    public LoadSaveStrategy makeLoadSaveStrategy(String loadSaveStrategy){
        if(loadSaveStrategy.equalsIgnoreCase("TEKSTBESTAND")){
            return new ArtikelLoadSaveTekst();

        } else if(loadSaveStrategy.equalsIgnoreCase("EXCELBESTAND")){
            return new ArtikelLoadSaveExcel();

        } else return null;
    }
}
