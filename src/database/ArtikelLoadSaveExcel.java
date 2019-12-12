package database;

import model.LoadSaveStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Phonkrit Van de Velde
 */

public class ArtikelLoadSaveExcel implements LoadSaveStrategy {
    private JarJavaClass jarJavaClass;

    @Override
    public ArrayList<Object> load(File bestand){
        return null; //jarJavaClass.load(bestand);
    }

    @Override
    public void save(List<Object> list){

    }

}
