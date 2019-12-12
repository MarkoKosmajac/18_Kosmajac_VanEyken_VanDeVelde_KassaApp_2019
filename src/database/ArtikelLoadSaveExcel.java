package database;

import jxl.write.WriteException;
import model.LoadSaveStrategy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Phonkrit Van de Velde
 */

public class ArtikelLoadSaveExcel implements LoadSaveStrategy {
    private JarJavaClass jarJavaClass;


    @Override
    public ArrayList<Object> load(File bestand){
        return null;
    }

    @Override
    public void save(List<Object> list) throws IOException, WriteException {

    }


    public void save(ArrayList<ArrayList<String>> list, File bestand){
        jarJavaClass.save(bestand,list);
    }

}
