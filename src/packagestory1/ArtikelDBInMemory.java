package packagestory1;

import java.util.HashMap;
import java.util.Map;

public class ArtikelDBInMemory implements ArtikelDBStrategy {
    //Hierin zit hashmap
    //Enum van types van  databases
    //Methode: Load en Save
    //Dit is nu de context klasse voor load en save strategy
    private LoadSaveStrategy loadSaveStrategy;
    private Map hashMap = new HashMap();

}
