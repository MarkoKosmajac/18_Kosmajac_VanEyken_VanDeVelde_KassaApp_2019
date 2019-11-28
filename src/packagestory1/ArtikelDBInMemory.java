package packagestory1;

import java.util.HashMap;
import java.util.Map;

public class ArtikelDBInMemory implements ArtikelDBStrategy {
    //Hierin zit hashmap
    private LoadSaveStrategy loadSaveStrategy;
    private Map hashMap = new HashMap();

}
