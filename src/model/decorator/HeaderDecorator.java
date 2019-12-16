package model.decorator;

public class HeaderDecorator extends KassabonDecorator {

    public HeaderDecorator(Kassabon kassabon){
        super(kassabon);
    }


    @Override
    public String printBon() {
        String letter = getKassabon().printBon();
        letter = letter.toUpperCase();
        return /*super.printBon() +*/ letter;
    }
}
