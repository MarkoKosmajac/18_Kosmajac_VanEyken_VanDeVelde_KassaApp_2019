package model;

import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public interface LoadSaveStrategy {

        ArrayList<ArrayList<String>> load(File bestand) throws IOException;
        void save(ArrayList<ArrayList<String>> list, File bestand) throws IOException, WriteException;

}
