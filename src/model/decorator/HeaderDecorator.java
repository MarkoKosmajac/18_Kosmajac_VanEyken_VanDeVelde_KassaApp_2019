package model.decorator;

public class HeaderDecorator extends KassabonDecorator {

    public HeaderDecorator(Kassabon kassabon){
        super(kassabon);
    }


    @Override
    public String printBon() {
        String res = super.printBon().toUpperCase();
        //String letter = getKassabon().printBon();
        //letter = letter.toUpperCase();
        String header = "Omschrijving" + "\t"  + "Aantal  Prijs" + "\n";
        return header + res;
    }
}
