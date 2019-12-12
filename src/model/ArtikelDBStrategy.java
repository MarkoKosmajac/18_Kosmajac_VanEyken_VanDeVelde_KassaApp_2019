package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Max Van De Velde, Marko Kosmajac, Brent Van Eyken
 */

public interface ArtikelDBStrategy {

    List<Artikel> load(File bestand);
    void save(ArrayList<Artikel> artikelArrayList);

}

