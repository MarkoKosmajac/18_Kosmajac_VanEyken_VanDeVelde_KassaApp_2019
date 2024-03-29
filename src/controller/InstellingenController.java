package controller;

import model.ArtikelModel;
import database.SoortBestand;
import database.SoortDatabase;
import model.kortingstrategie.KortingStrategie;
import model.kortingstrategie.SoortKorting;
import view.panels.InstellingenPane;

import java.io.*;
import java.util.Properties;

/**
 * @author Max Van De Velde, Marko Kosmajac
 */

public class InstellingenController {


    protected ArtikelModel artikelModel;
    private Properties properties;
    private InstellingenPane instellingenPane;

    public InstellingenController(){
        this.properties = new Properties();
        geefPathFile();
    }

    public String getProperties(){
        return properties.getProperty("loadSaveStrategy");
    }

    public void setPropertiesDB(String keuzeFile, String keuzeDatabase){
        FileOutputStream os;
        try{
            SoortBestand bestandkeuze = SoortBestand.valueOf(keuzeFile);
            SoortDatabase databasekeuze = SoortDatabase.valueOf(keuzeDatabase);
            os = new FileOutputStream("src" + File.separator + "bestanden" + File.separator + "KassaApp.properties");
            properties.clear();
            properties.setProperty("loadSaveStrategy", bestandkeuze.toString());
            properties.setProperty("databasekeuze", databasekeuze.toString());
            properties.store(os,null);

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void setPropertiesKeuzeKorting(String keuzeKorting, int percent, double bedrag){
        FileOutputStream os = null;
        try{
            SoortKorting kortingskeuze = SoortKorting.valueOf(keuzeKorting);

            os = new FileOutputStream("src" + File.separator + "bestanden" + File.separator + "KassaApp.properties");
            properties.setProperty("Kortingskeuze", kortingskeuze.toString());
            properties.setProperty("Kortingspercent", String.valueOf(percent));
            properties.setProperty("Kortingsbedrag", String.valueOf(bedrag));
            properties.store(os,null);
            System.out.println("Restart Applicatie om updates toe te passen in de properties file");
            //Platform.exit();


        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void setPropertiesDecoratorHeader(String headerlijn){
        FileOutputStream os = null;
        try{
            os = new FileOutputStream("src" + File.separator + "bestanden" + File.separator + "KassaApp.properties");
            properties.setProperty("headerlijn", headerlijn);

            properties.store(os,null);
            //Platform.exit();


        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void setPropertiesDecoratorFooter(String footerlijn){
        FileOutputStream os = null;
        try{
            os = new FileOutputStream("src" + File.separator + "bestanden" + File.separator + "KassaApp.properties");
            properties.setProperty("footerlijn", footerlijn);
            properties.store(os,null);
            //Platform.exit();


        } catch (Exception e) {
            e.getMessage();
        }
    }


    public File geefPathFile(){
        File bestand = null;
        InputStream in = null;
        try {
            in = new FileInputStream(new File("src" + File.separator + "bestanden" + File.separator + "KassaApp.properties"));
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

    public String geefStrategie() {
        InputStream in = null;
        try {
            in = new FileInputStream(new File("src" + File.separator + "bestanden" + File.separator + "KassaApp.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("Kortingskeuze") + " " + properties.getProperty("Kortingspercent") ;
    }

    public String getSelectedPercent(){
        System.out.println(instellingenPane.getSelectedPercent());
        return instellingenPane.getSelectedPercent();
    }

    /*public double getDuursteArtikel(){
        return artikelModel.getDuursteArtikel();
    }*/

    public String getKortingStrategieString(KortingStrategie kortingStrategie) {
        return artikelModel.getKortingStrategieString(kortingStrategie);
    }

    public String getIngevuldeProperty(String propery){
        return properties.getProperty(propery);
    }

}
