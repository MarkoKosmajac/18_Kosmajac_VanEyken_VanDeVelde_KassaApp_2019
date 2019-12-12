package model;

import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface LoadSaveStrategy {

        ArrayList<Object> load(File bestand) throws IOException;
        void save(List<Object> list) throws IOException;

}
