package model;

/**
 * @author Max Van De Velde, Marko Kosmajac, Brent Van Eyken
 */

public class Artikel implements Comparable<Artikel>{

    private String artikelCode, omschrijving, artikelGroep;
    private double prijs;
    private int stock; //10 = stock
    private int aantal = 0;

    public Artikel(String artikelCode, String omschrijving, String artikelGroep, double prijs, int stock) {
        this.artikelCode = artikelCode;
        this.omschrijving = omschrijving;
        this.artikelGroep = artikelGroep;
        this.prijs = prijs;
        this.stock = stock;
    }
    public Artikel(String artikelCode) {
        this.artikelCode = artikelCode;
    }
    public String getArtikelCode() {
        return artikelCode;
    }
    public void setArtikelCode(String artikelCode) {
        this.artikelCode = artikelCode;
    }
    public String getOmschrijving() {
        return omschrijving;
    }
    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }
    public String getArtikelGroep() {
        return artikelGroep;
    }
    public void setArtikelGroep(String artikelGroep) {
        this.artikelGroep = artikelGroep;
    }
    public double getPrijs() {
        return prijs;
    }
    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public int getAantal() {
        return aantal;
    }
    public void setAantal(int aantal) {
        this.aantal = aantal;
    }

    @Override
    public String toString() {
        return this.artikelCode + "," + this.omschrijving + "," + this.artikelGroep + "," + this.prijs + "," + this.stock + "\n";
    }
    @Override
    public int compareTo(Artikel o) {
        return this.getOmschrijving().compareTo(o.getOmschrijving());
    }

    public String cleanOutput() {
        String res = "";
        res += "ArtikelID: " + this.getArtikelCode() + " | " + "Omschrijving: " + this.getOmschrijving() + " | " + "Groep: " + this.getArtikelGroep() + " | " + " Prijs: " + this.getPrijs() + "\n";// + " | " + "Stock: " + this.getStock() + "\n";
        return res;
    }

    public String kassabonPrint(){
        return this.omschrijving + "                " + this.getAantal() + "     " + this.prijs+"\n";
    }
}

