package database;

import model.LoadSaveStrategy;

import java.io.File;
import java.util.ArrayList;

/**
 * @author Phonkrit Van de Velde
 */

public class ArtikelLoadSaveExcel implements LoadSaveStrategy {
    private JarJavaClass jarJavaClass;


    @Override
    public ArrayList<ArrayList<String>> load(File bestand){
        return jarJavaClass.load(bestand);
    }

    @Override
    public void save(ArrayList<Object> artikelArrayList, File bestand){
        jarJavaClass.save(artikelArrayList,bestand);
    }

}
