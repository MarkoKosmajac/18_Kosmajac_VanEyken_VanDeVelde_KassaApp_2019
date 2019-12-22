package model.decorator;

public class TekstKassabonLezer implements Kassabon{
    private String tekst;

    public TekstKassabonLezer(String tekst){
        this.tekst = tekst;
    }

    public String printBon() {
        return "eee";
    }


}
