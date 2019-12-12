package controller;

import database.ArtikelLoadSaveExcel;
import database.ArtikelLoadSaveTekst;
import model.LoadSaveStrategy;
import model.SoortBestand;
import model.kortingstrategie.SoortKorting;

import java.io.*;
import java.util.Properties;

public class InstellingenController {

    Properties properties;

    public InstellingenController(){
        this.properties = new Properties();
        laadPropertiesIn(); //TODO: doet niks ? Hoe inlezen ?
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
        return properties.getProperty("loadSaveStrategy");
    }

    public void setPropertiesDB(String keuzeFile, String keuzeKorting){
        FileOutputStream os = null;
        try{
            SoortBestand bestandkeuze = SoortBestand.valueOf(keuzeFile);
            SoortKorting kortingskeuze = SoortKorting.valueOf(keuzeKorting);
            os = new FileOutputStream("src" + File.separator + "database" + File.separator + "KassaApp.properties");
            properties.clear();
            properties.setProperty("loadSaveStrategy", bestandkeuze.toString());
            properties.setProperty("Kortingskeuze", kortingskeuze.toString());
            properties.store(os,null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
