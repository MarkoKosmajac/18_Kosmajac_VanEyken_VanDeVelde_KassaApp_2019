package database;

public class LoadSaveStrategyFactory {
    /*//TODO: DEEL VAN VERSIE 2
    private final LoadSaveStrategy artikelLoadSaveTekstStrategy = new ArtikelLoadSaveTekst();
    private final LoadSaveStrategy artikelLoadSaveExcelStrategy = new ArtikelLoadSaveExcel();*/

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

    /*
    //TODO: DEEL VAN VERSIE 2
    public LoadSaveStrategy makeLoadSaveStrategy(LoadSaveStrategy loadSaveStrategy){
        LoadSaveStrategy loadSaveStrategyf = null;
        if(loadSaveStrategy == artikelLoadSaveTekstStrategy){
            return new ArtikelLoadSaveTekst();
        } else if(loadSaveStrategy == artikelLoadSaveExcelStrategy){
            return new ArtikelLoadSaveExcel();
        } else return null;
    }*/

}
