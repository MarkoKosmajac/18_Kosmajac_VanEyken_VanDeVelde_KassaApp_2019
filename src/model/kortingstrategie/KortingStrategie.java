package model.kortingstrategie;

/**
 * @author Marko Kosmajac
 */

public interface KortingStrategie {

    String geefKorting();
    int getProcent();
    void setProcent(int procent);

}
