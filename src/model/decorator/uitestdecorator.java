package model.decorator;

public class uitestdecorator {
    public static void main(String[] args) {


        Kassabon kassabon1 = new HeaderDecorator(new FooterDecorator(new TekstKassabonLezer()));
        System.out.println(kassabon1.toString());

        Kassabon kassabon2 = new HeaderDecorator((new TekstKassabonLezer()));
        System.out.println(kassabon2.toString());

    }
}
