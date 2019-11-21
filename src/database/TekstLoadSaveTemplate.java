package database;

public abstract class TekstLoadSaveTemplate {

    //TODO: stappenplan algoritme

    final void load(){
        openFile();
        closeFile();
    }

    final void save(){
        openFile();
        closeFile();
    }

    //Geen abstracte want is zelfde voor load en save
    void openFile(){

    }

    //Geen abstracte want is zelfde voor load en save
    void closeFile(){

    }

}
