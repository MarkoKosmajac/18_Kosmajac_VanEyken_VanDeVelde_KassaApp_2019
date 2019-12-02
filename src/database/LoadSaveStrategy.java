package database;

import java.util.ArrayList;

public interface LoadSaveStrategy {

        ArrayList<Object> load(String bestand);
        void save(ArrayList<Object> artikelArrayList, String bestand);

}
