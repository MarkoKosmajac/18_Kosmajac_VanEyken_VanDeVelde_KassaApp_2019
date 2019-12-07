package database;

public class LoadSaveStrategyFactory {

    //TODO: Is het zo juist met equalsIgnoreCase ?...
    //TODO: NOG TE IMPLEMENTERE IN ArtikelDBContext etc... Singleton, reflection,...
    public LoadSaveStrategy makeLoadSaveStrategy(String loadSaveStrategy){
        LoadSaveStrategy loadSaveStrategyf = null;
        if(loadSaveStrategy.equalsIgnoreCase("ArtikelLoadSaveTekst")){
            return new ArtikelLoadSaveTekst();
        } else if(loadSaveStrategy.equalsIgnoreCase("ArtikelLoadSaveExcel")){
            return new ArtikelLoadSaveExcel();
        } else return null;
    }

}
