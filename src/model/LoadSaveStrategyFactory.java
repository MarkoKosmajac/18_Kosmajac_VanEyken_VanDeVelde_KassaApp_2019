package model;

import database.ArtikelLoadSaveExcel;
import database.ArtikelLoadSaveTekst;

public class LoadSaveStrategyFactory {

    public LoadSaveStrategy makeLoadSaveStrategy(String loadSaveStrategy){
        if(loadSaveStrategy.equalsIgnoreCase("ArtikelLoadSaveTekst")){
            return new ArtikelLoadSaveTekst();

        } else if(loadSaveStrategy.equalsIgnoreCase("ArtikelLoadSaveExcel")){
            return new ArtikelLoadSaveExcel();

        } else return null;
    }
}
