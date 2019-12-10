package model;

import database.ArtikelLoadSaveExcel;
import database.ArtikelLoadSaveTekst;

public class LoadSaveStrategyFactory {

    //TODO: ENKEL DEZE METHODE IS DEEL VAN VERSIE 1!
    //TODO: Is het zo juist met equalsIgnoreCase ?...
    //TODO: NOG TE IMPLEMENTEREN IN ArtikelDBContext etc... Singleton, reflection,...
    public LoadSaveStrategy makeLoadSaveStrategy(String loadSaveStrategy){
        if(loadSaveStrategy.equalsIgnoreCase("ArtikelLoadSaveTekst")){ //TODO: Moet het misschien TekstLoadSaveTemplate zijn ?
            return new ArtikelLoadSaveTekst();
        } else if(loadSaveStrategy.equalsIgnoreCase("ArtikelLoadSaveExcel")){
            return new ArtikelLoadSaveExcel();
        } else return null;
    }

}
