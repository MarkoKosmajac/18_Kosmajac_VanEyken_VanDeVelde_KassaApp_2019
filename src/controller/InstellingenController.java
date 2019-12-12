package controller;

import database.ArtikelLoadSaveExcel;
import database.ArtikelLoadSaveTekst;
import model.LoadSaveStrategy;
import model.SoortBestand;
import model.SoortDatabase;
import model.kortingstrategie.SoortKorting;
import java.io.*;
import java.util.Properties;

/**
 * @author Max Van De Velde, Marko Kosmajac
 */

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

    public void setPropertiesDB(String keuzeFile, String keuzeKorting, String keuzeDatabase){
        FileOutputStream os = null;
        try{
            SoortBestand bestandkeuze = SoortBestand.valueOf(keuzeFile);
            SoortKorting kortingskeuze = SoortKorting.valueOf(keuzeKorting);
            SoortDatabase databasekeuze = SoortDatabase.valueOf(keuzeDatabase);
            os = new FileOutputStream("src" + File.separator + "database" + File.separator + "KassaApp.properties");
            properties.clear();
            properties.setProperty("loadSaveStrategy", bestandkeuze.toString());
            properties.setProperty("Kortingskeuze", kortingskeuze.toString());
            properties.setProperty("databasekeuze", databasekeuze.toString());
            properties.store(os,null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
