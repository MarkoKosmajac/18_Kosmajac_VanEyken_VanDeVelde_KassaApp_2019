package model;

import model.Artikel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public interface ArtikelDBStrategy {

    List<Artikel> load(File bestand);
    void save(ArrayList<Artikel> artikelArrayList);

}

