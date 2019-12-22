package model.decorator;

public class uitestdecorator {
    public static void main(String[] args) {


        Kassabon kassabon1 = new FooterDecorator(new HeaderDecorator(new TekstKassabonLezer()));
        System.out.println(kassabon1.toString());

    }
}
