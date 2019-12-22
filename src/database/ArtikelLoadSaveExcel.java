package database;

import model.Artikel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Phonkrit Van de Velde
 */

public class ArtikelLoadSaveExcel implements LoadSaveStrategy {
    private JarJavaClass jarJavaClass = new JarJavaClass();



    @Override
    public ArrayList<Object> load(File bestand){
        ArrayList<Object> objectList = new ArrayList<>();
        ArrayList<ArrayList<String>> adaptee = jarJavaClass.load(bestand);

        for (ArrayList<String> rij: adaptee){
            String artikelcode = rij.get(0);
            String omschrijving = rij.get(1);
            String artikelGroep = rij.get(2);
            double prijs = Double.parseDouble(rij.get(3));
            int stock = Integer.parseInt(rij.get(4));
            Artikel artikel = new Artikel(artikelcode, omschrijving, artikelGroep, prijs, stock);
            objectList.add(artikel);
        }
        return objectList;
    }

    @Override
    public void save(List<Object> list){
        ArrayList<ArrayList<String>> excelArray = new ArrayList<>();
        File file = new File("src" + File.separator + "bestanden" + File.separator + "artikel.xls");

        for (Object objects: list){
            ArrayList<String> lijn = new ArrayList<>();
            Artikel artikel = (Artikel) objects;
            lijn.add(artikel.getArtikelCode());
            lijn.add(artikel.getOmschrijving());
            lijn.add(artikel.getArtikelGroep());
            lijn.add(String.valueOf(artikel.getPrijs()));
            lijn.add(String.valueOf(artikel.getStock()));
            excelArray.add(lijn);
        }
        jarJavaClass.save(file,excelArray);
    }
}
