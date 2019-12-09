package database;

import model.Artikel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
/**
 * @author Phonkrit Van de Velde
 */

public abstract class TekstLoadSaveTemplate implements LoadSaveStrategy {
    //TODO: nog aan te vullen, hier komen abstracte methodes save en load om bijvoorbeeld een KLANT object in te lezen en te saven
    //TODO: STANDAARDCODE;

    //LOAD EN SAVE METHODE DIE MOETEN FINAL ZIJN

    public final ArrayList<Object> load(String bestand) throws IOException {
        ArrayList<Object> objects = new ArrayList<>();
        try{
            Scanner scannerFile = getBestand();
            scannerFile.useDelimiter("\n");
            while(scannerFile.hasNextLine()){
                Scanner scannerLijn = new Scanner(scannerFile.nextLine());
                scannerLijn.useDelimiter(",");
                try {
                    Object object = getObject(scannerLijn);
                    objects.add(object);
                } catch (DBException e){
                    throw new DBException(e.getMessage());
                }

            }


        } catch (FileNotFoundException e) {
            throw new DBException("Fout bij het inlezen", e);
        }

        return objects;

    }

    public final void save(ArrayList<Object> artikelArrayList, String bestand){
        ArrayList<Artikel> artikelen = new ArrayList<>();

        for(Object o : artikelArrayList){
            if(o instanceof Artikel){
                artikelen.add((Artikel) o);
            }
        }

        File artikelFile = new File(bestand); //TODO: RENAME TO artikel.txt
        try{
            PrintWriter writer = new PrintWriter(artikelFile);
            for (Artikel a: artikelen){
                writer.println(a);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    abstract Scanner getBestand() throws FileNotFoundException;
    abstract Object getObject(Scanner scannerLine);






}
