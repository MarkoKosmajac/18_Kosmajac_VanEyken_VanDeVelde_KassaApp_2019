package model.kortingstrategie;

public class DuursteKorting implements KortingStrategie {

    @Override
    public String geefKorting() {
        return "25% korting op duurste artikel uit winkelkar.";
    }
}