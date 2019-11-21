package model;

public class TestStory1 {

    public static void main(String[] args) {

        Artikel a = new Artikel("1","artikel1","gr1",12.5,10);
        Artikel b = new Artikel("2","artikel2","gr2",15,10);
        Artikel c = new Artikel("3","artikel3","gr3",1.5,10);

        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        
    }
}
