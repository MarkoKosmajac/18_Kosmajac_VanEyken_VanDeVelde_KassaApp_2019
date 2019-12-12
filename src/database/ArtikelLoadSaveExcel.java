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
        return null; //jarJavaClass.load(bestand); TODO: DIT FIXEN dmv nieuwe templateexcel klasse ?
    }

    @Override
    public void save(List<Object> list){

    }


    public void save(ArrayList<ArrayList<String>> list, File bestand){
        jarJavaClass.save(bestand,list);
    }

}
