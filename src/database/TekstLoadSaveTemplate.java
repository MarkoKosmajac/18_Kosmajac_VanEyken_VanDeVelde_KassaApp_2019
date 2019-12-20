package database;

import model.Artikel;
import model.LoadSaveStrategy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Phonkrit Van de Velde
 */

public abstract class TekstLoadSaveTemplate implements LoadSaveStrategy {

    public final ArrayList<Object> load(File bestand){
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

    public final void save(List<Object> list){
        File file = new File("src" + File.separator + "bestanden" + File.separator + "artikel.txt");
        ArrayList<Artikel> artikelen = new ArrayList<>();

        for(Object o : list){
            if(o instanceof Artikel){
                artikelen.add((Artikel) o);
            }
        }

        try{
            PrintWriter writer = new PrintWriter(file);
            for (Artikel a: artikelen){
                //writer.println(a);
                writer.print(a.getArtikelCode() + ",");
                writer.print(a.getOmschrijving() + ",");
                writer.print(a.getArtikelGroep() + ",");
                writer.print(a.getPrijs() + ",");
                writer.println(a.getStock());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    abstract Scanner getBestand() throws FileNotFoundException;
    abstract Object getObject(Scanner scannerLine);






}
