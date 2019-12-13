package controller;

import database.ArtikelLoadSaveExcel;
import database.ArtikelLoadSaveTekst;
import model.LoadSaveStrategy;
import model.SoortBestand;
import model.SoortDatabase;
import model.kortingstrategie.SoortKorting;
import view.panels.InstellingenPane;

import java.io.*;
import java.util.Properties;

/**
 * @author Max Van De Velde, Marko Kosmajac
 */

public class InstellingenController {

    Properties properties;
    //private InstellingenPane view;

    public InstellingenController(){
        //view = new InstellingenPane();
        this.properties = new Properties();
        geefPathFile(); //TODO: doet niks ? Hoe inlezen ?
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

    public File geefPathFile(){
        File bestand = null;
        InputStream in = null;
        try {
            in = new FileInputStream(new File("src" + File.separator + "database" + File.separator + "KassaApp.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(properties.getProperty("loadSaveStrategy").equalsIgnoreCase("EXCELBESTAND")){
           bestand = new File("src" + File.separator + "bestanden" + File.separator + "artikel.xls");
        }else if(properties.getProperty("loadSaveStrategy").equalsIgnoreCase("TEKSTBESTAND")){
            bestand = new File("src" + File.separator + "bestanden" + File.separator + "artikel.txt");
        }
        return bestand;
    }

    /*public String getSelectedKorting(){
        return view.getSelectedKorting();
    }*/

}
