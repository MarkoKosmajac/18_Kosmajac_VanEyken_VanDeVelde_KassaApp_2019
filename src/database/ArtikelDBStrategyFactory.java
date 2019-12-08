package database;

import java.io.IOException;

public class ArtikelDBStrategyFactory {


    //TODO: NOG TE IMPLEMENTEREN IN ArtikelDBContext etc... Singleton, reflection,...
    public ArtikelDBStrategy makeArtikelDBStrategy(String artikelDBStrategy) throws IOException {
        if(artikelDBStrategy.equalsIgnoreCase("ArtikelDBInMemory")){
            return new ArtikelDBInMemory(); //TODO: FIX ZODAT HET NIET 2 PARAMETERS HEEFT.
        /*} else if(artikelDBStrategy.equalsIgnoreCase("ArtikelDBInSQL")){
            return new ArtikelDBInSQL();*/
        } else return null;
    }

}
