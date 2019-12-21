package controller;

import database.ArtikelDBContext;
import model.Artikel;
import model.ArtikelModel;

import java.util.ArrayList;
import java.util.Properties;

public class ProductOverviewPaneController {

    private ArtikelDBContext artikelDBContext;

    public ProductOverviewPaneController(){
        artikelDBContext = ArtikelDBContext.getInstance();
    }

    public ArrayList<Artikel> getArtikels(){
        return artikelDBContext.getArtikels();
    }

}
