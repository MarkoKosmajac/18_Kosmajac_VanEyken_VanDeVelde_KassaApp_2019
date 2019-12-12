package model.observer;

import model.Artikel;
import java.util.ArrayList;

/**
 * @author Max Van De Velde, Marko Kosmajac
 */

public interface Observer {

    void update(ArrayList<Artikel> artikellijst);

}
