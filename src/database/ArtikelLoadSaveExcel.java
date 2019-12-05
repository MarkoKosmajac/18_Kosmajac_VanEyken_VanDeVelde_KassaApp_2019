package database;

import java.util.ArrayList;

public class ArtikelLoadSaveExcel implements LoadSaveStrategy {
    private JarJavaClass jarJavaClass;

    public ArtikelLoadSaveExcel(JarJavaClass jarJavaClass) {
        this.jarJavaClass = jarJavaClass;
    }

    @Override
    public void load(String bestand) {
        jarJavaClass.read();
    }

    @Override
    public void save(ArrayList<Object> artikelArrayList, String bestand) {
        jarJavaClass.write();
    }

    //Methodie die juiste pad terug geeft waar bestand zich bevindt
}
