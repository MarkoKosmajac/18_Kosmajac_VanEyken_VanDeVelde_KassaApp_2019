package database;

import jxl.write.WriteException;
import model.Artikel;

import java.io.IOException;
import java.util.*;

public class ArtikelDBInMemory implements ArtikelDBStrategy {
    //Hierin zit hashmap -lees uit, uit artikel.txt
    //Enum van types van  databases
    //Methode: Load en Save
    //Dit is nu de context klasse voor load en save strategy
    private LoadSaveStrategy loadSaveStrategy;
    private HashMap artikelen = new HashMap<String, Artikel>();
    private TreeMap treeMap;



    public ArtikelDBInMemory(LoadSaveStrategy loadSaveStrategy, String bestand) throws IOException {
        this.loadSaveStrategy = loadSaveStrategy;
        ArrayList<Object> a = load(bestand);

        for (Object o : a) {
            if (o instanceof Artikel) {
                artikelen.put(((Artikel) o).getArtikelCode(), (Artikel) o);

            }
        }
        convertToTreeMap(artikelen);


    }

   /* public  <K, V> Map<K, V> convertToTreeMap(Map<K, V> hashMap)
    {
        // Create a new TreeMap
        Map<K, V> treeMap = new TreeMap<>(new ComparatorOpOmschrijving());

        // Pass the hashMap to putAll() method
        treeMap.putAll(artikelen);

        // Return the TreeMap
        return treeMap;
    } */

    public  <K, V> void convertToTreeMap(Map<K, V> hashMap) {
        SortedSet<Map.Entry<String, Artikel>> sortedset = new TreeSet<Map.Entry<String, Artikel>>(
                new Comparator<Map.Entry<String, Artikel>>() {
                    @Override
                    public int compare(Map.Entry<String, Artikel> o1, Map.Entry<String, Artikel> o2) {
                        String omschrijving1 = o1.getValue().getOmschrijving().toLowerCase();
                        String omschrijving2 = o2.getValue().getOmschrijving().toLowerCase();

                        return omschrijving2.compareTo(omschrijving1);
                    }

                });

        sortedset.addAll(artikelen.entrySet());


    }



    public ArrayList<Object> load(String bestand) throws IOException {
        return loadSaveStrategy.load(bestand);
    }


    public void save(ArrayList<Object> artikelArrayList, String bestand) throws IOException, WriteException {
        loadSaveStrategy.save(artikelArrayList, bestand);
    }


}
