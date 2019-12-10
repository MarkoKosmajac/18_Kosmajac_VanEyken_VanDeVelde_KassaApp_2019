package controller;

import database.DBException;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import database.ArtikelDBContext;
import model.Artikel;
import view.panels.KassaTab1OverviewPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KassaProductOverviewController {

    private List<Artikel> artikelList, winkelmand;
    private ArtikelDBContext dbModel; //Model
    private KassaTab1OverviewPane kassaTab1OverviewPaneView; //View
    private String artikelcode;

    public KassaProductOverviewController(ArtikelDBContext artikelDBContext){
        this.dbModel = artikelDBContext;


        artikelList = new ArrayList<>();
        winkelmand = new ArrayList<>();
        artikelList.addAll(dbModel.loadData());

        this.kassaTab1OverviewPaneView.geefArtikelCodeDoorAanController(new ProductEventHandler());

    }

    public void addToWinkelMandje(Artikel artikel) {
        winkelmand.add(artikel);
        System.out.println(artikel);
        //theview.setWaarde("eeee");

        //TODO: IETS
    }

    public Artikel getArtikel(String ingevuldeWaarde) {
        Artikel res = null;
        for (Artikel a: artikelList){
            if (a.getArtikelCode().equalsIgnoreCase(ingevuldeWaarde)){
                res = a;
            }
        }
        return res;
    }


    public class ProductEventHandler implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent event) {
            try{
                if (event.getCode() == KeyCode.ENTER) {
                    artikelcode = kassaTab1OverviewPaneView.getIngevuldeWaarde();
                    dbModel.getArtikel(artikelcode);
                    winkelmand.add(dbModel.getArtikel(artikelcode));
                }


                kassaTab1OverviewPaneView.setGezochteArtikel(dbModel.zoekArtikelEnKrijgOmschrijvingEnPrijs(artikelcode));

            } catch (DBException e){
                throw new DBException(e.getMessage());
            }


        }
    }

   /* public void addToWinkelMandje(Artikel artikel){
        model.updateByAddArtikel(artikel);
    } *Van Nick*
    */
}
