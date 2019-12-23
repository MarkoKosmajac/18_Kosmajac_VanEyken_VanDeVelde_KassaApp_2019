package controller;

import model.ArtikelModel;
import view.panels.LogPane;

/**
 * @author Marko Kosmajac
 */

public class LogPaneController {

    private ArtikelModel artikelModel; //Model
    private LogPane logPaneView; //View

    public LogPaneController(){
        artikelModel = new ArtikelModel();
    }

    public String log(String totaalBedrag, String kortingBedrag, String eindTotaal) {
        return artikelModel.log();
    }



}
