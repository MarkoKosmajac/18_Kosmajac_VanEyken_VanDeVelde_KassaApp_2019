package model;

import jxl.write.WriteException;

import java.io.IOException;
import java.util.ArrayList;

public interface LoadSaveStrategy {

        ArrayList<Object> load(String bestand) throws IOException;
        void save(ArrayList<Object> artikelArrayList, String bestand) throws IOException, WriteException;

}
