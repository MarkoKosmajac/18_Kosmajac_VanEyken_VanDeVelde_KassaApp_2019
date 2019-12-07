package model;

public class DrempelKorting implements KortingStrategie {

    @Override
    public String geefKorting() {
        return "5% korting op een aankoopbedrag hoger dan 100 euro.";
    }

}
