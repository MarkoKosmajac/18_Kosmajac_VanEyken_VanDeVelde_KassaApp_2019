package model.decorator;

public class FooterDecorator extends KassabonDecorator{

    public FooterDecorator(Kassabon kassabon){
        super(kassabon);
    }

    @Override
    public String printBon() {
        String res = super.printBon();
        //String letter = getKassabon().printBon();
        //letter = letter.toLowerCase();
        String footer = "Betaald (inclusief korting): " + getKassabon().printBon();
        return res + footer;
    }
}
