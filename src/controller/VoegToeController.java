package controller;

import database.ArtikelDBContext;
import database.LoadSaveStrategy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import model.Artikel;
import view.panels.KassaTab1OverviewPane;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;

public class VoegToeController {

    ArtikelDBContext db;

    /*private KassaTab1OverviewPane theView;
    private ArtikelDBContext theModel;*/

    /*public VoegToeController(*//*KassaTab1OverviewPane theView, ArtikelDBContext theModel*//*) {*/
        /*this.theView = theView;
        this.theModel = theModel;

        this.theView.addVoegToeHandler(new addVoegToeHandler());*/
    /*}*/

    public VoegToeController(InstellingenController instellingenController) throws IOException {
        LoadSaveStrategy loadSaveStrategy = new LoadSaveStrategy();
        instellingenController.geefLoadSaveStrategy();
        db = new ArtikelDBContext(loadSaveStrategy);
        //TODO FIX ? => db = ArtikelDBContext.getInstance(loadSaveStrategy);
    }

    public ObservableList<Artikel> loadData(){
        return FXCollections.observableArrayList(this.getArtikels());
    }

    public ArrayList<Artikel> getArtikels(){
        return db.getArtikelen();
    }

    public Artikel geefArtikel(String artikelcode){
        if(artikelcode.trim().isEmpty() || artikelcode == null){
            throw new ControllerException("Artikelcode is leeg.");
        }
        return db.zoekArtikel(artikelcode);
    }

    /*//class addVoegToeHandler implements EventHandler<ActionEvent> {
    class addVoegToeHandler implements javafx.event.EventHandler<javafx.scene.input.KeyEvent>{*/

        /*@Override
        public void handle(KeyEvent e) {
            String code = "";
            // Surround interactions with the view with
            // a try block in case numbers weren't
            // properly entered
            try{
                if (e.getKeyCode() == KeyCode.ENTER.getCode()){
                code = theView.getIngevuldeWaarde();
                theModel.zoekCodeOp(code);
                theView.setWaarde(theModel.getOpgezochteCode());*/
                //TODO: OOK ERGENS HIER, er mag in de view niet gerekent worden!!!!
                /*String invoer = text.getText();
                String em = artikelDBContext.zoek(invoer);
                Artikel artikel = artikelDBContext.zoekArtikel(invoer);
                if(em.contains(",")){ //PRODUCT = FOUND
                    String omschr = artikel.getOmschrijving();
                    double prijs = artikel.getPrijs();
                    totaalBedrag += artikel.getPrijs();
                    //System.out.println("Omschrijving: " + omschr + " Prijs: " + prijs + " totaal: " + totaalBedrag);
                    products.add(artikel);
                    table.setItems(products);
                    text.clear();*/
                /*}
            }
            catch(NumberFormatException ex){
                theView.displayErrorMessage("Niet gevonden.");
            }
        }*/

        /*//ZIE HOE YANNICK DOET, IN FX, HIER ENKEL OBSERVER UPDATEN.
        @Override
        public void handle(javafx.scene.input.KeyEvent event) {
            try{
                System.out.println("HANDLING");
                String code = "";
                if (event.getCode() == KeyCode.ENTER){
                    System.out.println("ENTER PRESSED");
                    code = theView.getIngevuldeWaarde();
                    theModel.zoekCodeOp(code);
                    theView.setWaarde(theModel.getOpgezochteCode());
                    theView.refresh();
                }
            }
            catch(NumberFormatException ex){
            theView.displayErrorMessage("Niet gevonden.");
            }
        }
    }*/



}