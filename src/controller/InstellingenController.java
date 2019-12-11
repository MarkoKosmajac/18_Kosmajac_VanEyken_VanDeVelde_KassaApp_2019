package controller;

import database.ArtikelLoadSaveExcel;
import database.ArtikelLoadSaveTekst;
import model.LoadSaveStrategy;

import java.io.*;
import java.util.Properties;

public class InstellingenController {

    Properties properties;

    public InstellingenController(){
        this.properties = new Properties();
    }

    public LoadSaveStrategy geefLoadSaveStrategy() throws IOException {
        if(getProperties().equalsIgnoreCase("Excel")){
            return new ArtikelLoadSaveExcel();
        }
        else{
            return new ArtikelLoadSaveTekst();
        }
    }

    public String getProperties() throws IOException {
        String res = "";
        InputStream in = new FileInputStream(new File("src" + File.separator + "database" + File.separator + "KassaApp.properties"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
        }

        if (out.toString().contains("deandere=deandere")){
            //rb1.setSelected(true);
            res = "deandere";
        } else if (out.toString().contains("databaseInMemory=databaseInMemory")){
            //rb2.setSelected(true);
            res = "databaseInMemory";

        }


        //out.toString()); Prints the string content read from input stream
        reader.close();
        return res;
    }

    public void setPropertiesDB() throws FileNotFoundException {
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

    public void setPropertiesSQL(){
        FileOutputStream os = null;
        try {
            os = new FileOutputStream("src" + File.separator + "database" + File.separator + "KassaApp.properties");
            properties.clear();
            properties.setProperty("deandere", "deandere");

            properties.store(os,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
