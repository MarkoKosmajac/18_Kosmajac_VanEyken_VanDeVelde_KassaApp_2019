package model.decorator;

public class FooterDecorator extends KassabonDecorator{

    public FooterDecorator(Kassabon kassabon){
        super(kassabon);
    }

    @Override
    public String printBon() {
        String letter = getKassabon().printBon();
        letter = letter.toLowerCase();
        return /*super.printBon() +*/ letter;
    }
}
