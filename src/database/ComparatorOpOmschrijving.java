package database;

import model.Artikel;

import java.util.Comparator;

/**
 * @author Phonkrit Van de Velde
 */

public class ComparatorOpOmschrijving implements Comparator<Artikel> {
    @Override
    public int compare(Artikel o1, Artikel o2) {

        String omschrijving1 = o1.getOmschrijving();
        String omschrijving2 = o2.getOmschrijving();

        return omschrijving2.compareTo(omschrijving1);

    }




}
