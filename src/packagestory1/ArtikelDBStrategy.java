package packagestory1;

import model.Artikel;

import java.util.ArrayList;

public interface ArtikelDBStrategy {
    ArrayList<Artikel> load(String bestand);
    void save(ArrayList<Artikel> artikelArrayList);
}

