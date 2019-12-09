package model;

public class Groepkorting implements KortingStrategie {

    @Override
    public String geefKorting() {
        return "5% korting op alle artikelen van een bepaalde groep.";
    }
}
