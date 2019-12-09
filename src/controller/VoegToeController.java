package controller;

import database.ArtikelDBContext;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import view.panels.KassaTab1OverviewPane;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class VoegToeController {
    private KassaTab1OverviewPane theView;
    private ArtikelDBContext theModel;

    public VoegToeController(KassaTab1OverviewPane theView, ArtikelDBContext theModel) {
        this.theView = theView;
        this.theModel = theModel;

        this.theView.addVoegToeHandler(new addVoegToeHandler());
    }

    //class addVoegToeHandler implements EventHandler<ActionEvent> {
    class addVoegToeHandler implements javafx.event.EventHandler<javafx.scene.input.KeyEvent>{

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

        //ZIE HOE YANNICK DOET, IN FX, HIER ENKEL OBSERVER UPDATEN.
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
    }

}
