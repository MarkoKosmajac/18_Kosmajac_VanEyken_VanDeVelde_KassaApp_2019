package database;

import java.util.ArrayList;

public interface LoadSaveStrategy {

        void load(String bestand);
        void save(ArrayList<Object> artikelArrayList, String bestand);

}
