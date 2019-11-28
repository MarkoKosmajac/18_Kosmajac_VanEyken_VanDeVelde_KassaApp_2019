package packagestory1;

import model.Artikel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ArtikelDBInMemory implements ArtikelDBStrategy {
    //Hierin zit hashmap -lees uit, uit artikel.txt
    //Enum van types van  databases
    //Methode: Load en Save
    //Dit is nu de context klasse voor load en save strategy
    private LoadSaveStrategy loadSaveStrategy;
    private Map hashMap = new HashMap();

    public ArtikelDBInMemory() {
    }

    public ArrayList<Artikel> load(){

        return
    }


    public void save(ArrayList<Artikel> artikelArrayList){

    }


}
