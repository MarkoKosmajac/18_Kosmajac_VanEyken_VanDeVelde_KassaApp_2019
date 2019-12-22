package controller;

import database.ArtikelDBContext;
import model.Artikel;
import java.util.ArrayList;

public class ProductOverviewPaneController {

    private ArtikelDBContext artikelDBContext;

    public ProductOverviewPaneController(){
        artikelDBContext = ArtikelDBContext.getInstance();
    }

    public ArrayList<Artikel> getArtikels(){
        return artikelDBContext.getArtikels();
    }

}
