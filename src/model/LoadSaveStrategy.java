package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Max Van De Velde, Brent Van Eyken
 */

public interface LoadSaveStrategy {

        ArrayList<Object> load(File bestand) throws IOException;
        void save(List<Object> list) throws IOException;

}
