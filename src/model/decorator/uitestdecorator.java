package model.decorator;

public class uitestdecorator {
    public static void main(String[] args) {
        System.out.println("GEKOMEN");
        Kassabon kassabon1 = new FooterDecorator(new TekstKassabonLezer("eeee"));
        System.out.println(kassabon1.printBon());
        System.out.println("-------------");
        Kassabon kassabon2 = new HeaderDecorator(new TekstKassabonLezer("eeee"));
        System.out.println(kassabon2.printBon());
    }
}
