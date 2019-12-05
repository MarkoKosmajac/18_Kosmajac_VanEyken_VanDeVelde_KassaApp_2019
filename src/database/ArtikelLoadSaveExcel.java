package database;

import jxl.write.WriteException;

import java.io.IOException;
import java.util.ArrayList;

public class ArtikelLoadSaveExcel implements LoadSaveStrategy {
    private JarJavaClass jarJavaClass;



    @Override
    public ArrayList<Object> load(String bestand) throws IOException {
        return jarJavaClass.read(bestand);
    }

    @Override
    public void save(ArrayList<Object> artikelArrayList, String bestand) throws IOException, WriteException {
        jarJavaClass.write(artikelArrayList,bestand);
    }

    //Methodie die juiste pad terug geeft waar bestand zich bevindt
}
