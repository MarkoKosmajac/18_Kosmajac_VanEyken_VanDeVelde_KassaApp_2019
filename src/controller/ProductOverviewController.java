package controller;

import database.DBException;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.ArtikelDBContext;
import model.Artikel;
import view.KassaView;
import view.panels.KassaTab1OverviewPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductOverviewController {

    private List<Artikel> artikelList, winkelmand;
    private ArtikelDBContext dbModel = ArtikelDBContext.getInstance(); //Model
    private KassaTab1OverviewPane kassaTab1OverviewPaneView = new KassaTab1OverviewPane(); //View
    private String artikelcode;

    public ProductOverviewController(ArtikelDBContext artikelDBContext, KassaTab1OverviewPane kassaTab1OverviewPane) throws IOException {
        //db = ArtikelDBContext.getInstance();
        this.dbModel = artikelDBContext;
        this.kassaTab1OverviewPaneView = kassaTab1OverviewPane;

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
