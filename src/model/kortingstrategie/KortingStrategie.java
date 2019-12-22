package model.kortingstrategie;

/**
 * @author Marko Kosmajac, Phonkrit Van de Velde
 */

public interface KortingStrategie {

    String geefKorting();
    int getProcent();
    void setProcent(int procent);
    void setPropertiesKorting();
    double getBedrag();


}
