package controller;

import database.ArtikelLoadSaveExcel;
import database.ArtikelLoadSaveTekst;
import database.LoadSaveStrategy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class InstellingenController {

    Properties properties;

    public InstellingenController(){
        this.properties = new Properties();
    }

    public LoadSaveStrategy geefLoadSaveStrategy(){
        if(getProperties().equalsIgnoreCase("Excel")){
            return new ArtikelLoadSaveExcel();
        }
        else{
            return new ArtikelLoadSaveTekst();
        }
    }

    public String getProperties(){

    }

    public void setProperties() throws FileNotFoundException {
        //TODO: set 3 lijnen, inoutstream, set en store
        FileOutputStream os = null;
        try{
            os = new FileOutputStream("src" + File.separator + "database" + File.separator + "KassaApp.properties");
            properties.clear();
            properties.setProperty("databaseInMemory", "databaseInMemory");
            properties.store(os,null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
