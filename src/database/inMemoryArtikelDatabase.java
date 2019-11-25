package database;

import model.*;
import java.io.*;
import java.util.*;

public class InMemoryArtikelDatabase {

    private HashMap artikelen = new HashMap<>();



    //TODO     De load methode geeft een ArrayList van Artikel objecten terug en de save methode schrijft een ArrayList van Artikel objecten weg.

    //TODO: 1. alle artikel uit het artikel.txt tekstbestand inleest in een hashmap
    //TODO: 2. Deze artikelen worden getoond in tab2 (artikelen) in een tableview met als kolommen de artikelcode, de omschrijving, de artikelgroep, de prijs en de actuele voorraad.
    //TODO: 3. De artikelen toon je in alfabetische volgorde van omschrijving. Er moeten geen artikelen kunnen worden toegevoegd, verwijderd of worden aangepast via je app . De actuele voorraad van de artikelen uit een kassaverkoop moet na afsluiten van elke kassaverkoop van een klant wel worden aangepast (automatisch).

    //TODO: 5. Geen excel dingen doen nu, enkel txt. Gebruik de txt op toledo.

    //TODO: Uitbreiding strategypattern: Voorzie in je architectuur tevens dat de in memory database later kan vervangen worden door voorbeeld een relationele database (de code om artikelen uit een relationele database te gebruiken hoef je niet te implementeren, wel de architectuur (met strategy pattern daartoe voorzien)


    public void load(String bestand){
        if (bestand == null || bestand.trim().isEmpty()) throw new IllegalArgumentException("Artikel mag niet leeg zijn");
        File artikelenFile = new File(bestand);
        try {
            Scanner scannerFile = new Scanner(artikelenFile);
            while (scannerFile.hasNextLine()) {
                Scanner scannerLijn = new Scanner(scannerFile.nextLine());
                scannerLijn.useDelimiter(",");
                String id = scannerLijn.next();
                String omschrijving = scannerLijn.next();
                String groep = scannerLijn.next();
                String pris = scannerLijn.next();
                double prijs = Double.parseDouble(pris);
                String stok = scannerLijn.next();
                int stock = Integer.parseInt(stok);
                //vb: 1,artikel1,gr1,12.5,10
                Artikel artikel = new Artikel(id, omschrijving, groep, prijs, stock);
                artikelen.put(artikel.getArtikelCode(), artikel);
            }

            artikelen = sortByValues(artikelen);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Fout bij het inlezen", e);
        }
    }

    public InMemoryArtikelDatabase(String bestand) {
        load(bestand);
    }

    public HashMap<String, Artikel> getArtikelen(){
        return this.artikelen;
    }

    public void writeToFile() throws IOException{
        FileWriter write = new FileWriter("src\\bestanden\\artikel.txt", false); //false = overschrijven, true = append
        PrintWriter print_line = new PrintWriter(write);

        //forloop
        print_line.printf("jajaja");
        print_line.close();

    }

    private HashMap sortByValues(HashMap map) { 
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here


        //Collections.sort(list, Comparator.comparing(Artikel::getOmschrijving));


        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
               return ((Comparable) ((Map.Entry) (o1)).getOmschrijving())
                  .compareTo(((Map.Entry) (o2)).getOmschrijving());
            }
        });
 
        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
               Map.Entry entry = (Map.Entry) it.next();
               sortedHashMap.put(entry.getKey(), entry.getValue());
        } 
        return sortedHashMap;
   }


}
