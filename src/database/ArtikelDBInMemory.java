package database;

import model.ArtikelDBStrategy;
import model.LoadSaveStrategy;
import model.LoadSaveStrategyFactory;

public class ArtikelDBInMemory implements ArtikelDBStrategy {
    //private LoadSaveStrategy loadSaveStrategy;
    //private HashMap artikelen = new HashMap<String, Artikel>();
    //private TreeMap treeMap;
    //private LoadSaveStrategyFactory loadSaveStrategyFactory;

    public ArtikelDBInMemory(){

        //TODO: CLEANED - NO EFFECT WHEN IN COMMENTS
        LoadSaveStrategy loadSaveStrategy = new LoadSaveStrategyFactory().makeLoadSaveStrategy(/*getStrategy()*/""); //TODO: replace uit properties ingelezen.
        /*
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
