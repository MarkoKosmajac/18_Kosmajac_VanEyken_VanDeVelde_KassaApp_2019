package model;

public class Artikel {

    //TODO: vb: 1,artikel1,gr1,12.5,10
    private String artikelCode, omschrijving, artikelGroep;
    private double prijs;
    private int stock; //10 = stock


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

    @Override
    public String toString() {
        return this.artikelCode + "," + this.omschrijving + "," + this.artikelGroep + "," + this.prijs + "," + this.stock + "\n";
    }
}
