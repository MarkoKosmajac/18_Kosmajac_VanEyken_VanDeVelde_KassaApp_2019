package controller;

import database.ArtikelDBContext;
import model.ArtikelModel;
import view.panels.KassaOverviewPane;
import view.panels.LogPane;

import java.util.Properties;

public class LogPaneController {

    private ArtikelModel artikelModel; //Model
    private LogPane logPaneView; //View
    private ArtikelDBContext artikelDBContext;

    public LogPaneController(){
        artikelModel = new ArtikelModel();

        //artikelDBContext = ArtikelDBContext.getInstance();
    }

    public String log(String totaalBedrag, String kortingBedrag, String eindTotaal) {
        return artikelModel.log();
    }



}
