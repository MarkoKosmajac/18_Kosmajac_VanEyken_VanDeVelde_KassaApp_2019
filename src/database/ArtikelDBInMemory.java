package database;

import model.ArtikelDBStrategy;

import java.io.IOException;

public class ArtikelDBInMemory implements ArtikelDBStrategy {
    //Hierin zit hashmap -lees uit, uit artikel.txt
    //Enum van types van  databases
    //Methode: Load en Save
    //Dit is nu de context klasse voor load en save strategy

    //private LoadSaveStrategy loadSaveStrategy;
    //private HashMap artikelen = new HashMap<String, Artikel>();
    //private TreeMap treeMap;
    //private LoadSaveStrategyFactory loadSaveStrategyFactory;

    public ArtikelDBInMemory(){

        //TODO: CLEANED - NO EFFECT WHEN IN COMMENTS
        /*//this.loadSaveStrategy = loadSaveStrategy;
        loadSaveStrategyFactory = new LoadSaveStrategyFactory();
        //ArrayList<Object> a = load(bestand);
        String bestand = "src\\bestanden\\artikel.txt";
        ArrayList<Object> a = loadSaveStrategyFactory.makeLoadSaveStrategy("ArtikelDBInMemory").load(bestand);

        //TODO: VERANDERINGEN ZIE KLADBLOKDOCUMENT MARKO

        for (Object o : a) {
            if (o instanceof Artikel) {
                artikelen.put(((Artikel) o).getArtikelCode(), (Artikel) o);

            }
        }
        convertToTreeMap(artikelen);

        */
    }


    /*public ArrayList<Object> load(String bestand) throws IOException {
        return loadSaveStrategy.load(bestand);
    }


    public void save(ArrayList<Object> artikelArrayList, String bestand) throws IOException, WriteException {
        loadSaveStrategy.save(artikelArrayList, bestand);
    }*/


}
