package controller;

import database.ArtikelDBContext;
import view.KlantViewMainPane;

public class KlantProductOverviewController {
    private ArtikelDBContext artikelDBContext; //Model
    private KlantViewMainPane klantView; //View

    public KlantProductOverviewController(ArtikelDBContext artikelDBContext, KlantViewMainPane klantView) {
        this.artikelDBContext = artikelDBContext;
        this.klantView = klantView;
    }
}
