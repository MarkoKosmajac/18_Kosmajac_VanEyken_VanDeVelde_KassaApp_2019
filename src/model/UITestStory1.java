package model;

import java.io.*;
import java.util.*;

public class UITestStory1 {


    public ArrayList load(String bestand){
        List<Artikel> artikelen;
        artikelen = new ArrayList<>();
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
                artikelen.add(artikel);
            }
            Collections.sort(artikelen, Comparator.comparing(Artikel::getOmschrijving));
            return (ArrayList) artikelen;
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Fout bij het inlezen", e);
        }
    }

    public void writeToFile() throws IOException{
        FileWriter write = new FileWriter("src\\bestanden\\artikel.txt", false); //false = overschrijven, true = append
        PrintWriter print_line = new PrintWriter(write);

        //forloop
        print_line.printf("jajaja");
        print_line.close();

    }





}
