package model;

import database.ArtikelDBContext;

/**
 * @author Marko Kosmajac
 */

public class ArtikelDBStrategyFactory {

    private static ArtikelDBStrategyFactory uniqueInstance;

    private ArtikelDBStrategyFactory(){

    }

    //WORKS, But we don't have to implement this as said in the task.

    /*public ArtikelDBStrategy makeArtikelDBStrategy(String artikelDBStrategy){
        if(artikelDBStrategy.equalsIgnoreCase("ArtikelDBInMemory")){
            return new ArtikelDBInMemory();*/
        /*} else if(artikelDBStrategy.equalsIgnoreCase("ArtikelDBInSQL")){
            return new ArtikelDBInSQL();*/
        /*} else return null;
    }

    public static synchronized ArtikelDBStrategyFactory getInstance(){
    if(uniqueInstance == null){
        uniqueInstance = new ArtikelDBStrategyFactory();
    }
    return uniqueInstance;
    }
    */


}
