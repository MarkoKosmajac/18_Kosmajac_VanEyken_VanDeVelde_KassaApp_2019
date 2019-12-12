package controller;

import database.ArtikelLoadSaveExcel;
import database.ArtikelLoadSaveTekst;
import model.LoadSaveStrategy;
import model.SoortBestand;

import java.io.*;
import java.util.Properties;

public class InstellingenController {

    Properties properties;

    public InstellingenController(){
        this.properties = new Properties();
        laadPropertiesIn();
    }

    private void laadPropertiesIn() {
        try {
            InputStream in = new FileInputStream(new File("src" + File.separator + "database" + File.separator + "KassaApp.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public LoadSaveStrategy geefLoadSaveStrategy() throws IOException {
        if(getProperties().equalsIgnoreCase("Excel")){
            return new ArtikelLoadSaveExcel();
        }
        else{
            return new ArtikelLoadSaveTekst();
        }
    }

    public String getProperties(){
        String value = properties.getProperty("artikelDBStrategy");
        return value;
    }

    public void setPropertiesDB(String keuze){
        FileOutputStream os = null;
        try{
            SoortBestand bestandkeuze = SoortBestand.valueOf(keuze);
            os = new FileOutputStream("src" + File.separator + "database" + File.separator + "KassaApp.properties");
            properties.clear();
            properties.setProperty("artikelDBStrategy", bestandkeuze.toString());
            properties.store(os,null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
