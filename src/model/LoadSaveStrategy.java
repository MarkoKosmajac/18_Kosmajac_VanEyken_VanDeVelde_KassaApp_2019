package model;

import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public interface LoadSaveStrategy {

        ArrayList<Object> load(File bestand) throws IOException;
        void save(ArrayList<Object> artikelArrayList, File bestand) throws IOException, WriteException;

}
