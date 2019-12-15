package view.panels;

import controller.KassaController;
import database.DBException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import model.Artikel;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import view.AfsluitHandler;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Marko Kosmajac, Max Van De Velde
 */

public class KassaOverviewPane extends GridPane {
    private TableView<Artikel> table ;
    private double totaalBedrag;
    private KassaController producten;
    private Artikel teVerwijderen;
    private TextField artikelCodeTextField = new TextField();

    private Label label = new Label("Artikelcode:");
    private Label labelTotaal = new Label(String.valueOf(totaalBedrag));
    private Label totaal = new Label("TOTAALBEDRAG:");
    private Label eindTotaalLabel = new Label("EINDTOTAAL:");
    private Label kortinglabel = new Label("KORTING:");
    private Label korting = new Label();
    private Label eindTotaal = new Label();


    private Button onHoldButton = new Button("On Hold WEG");
    private Button onHoldButton2 = new Button("On Hold TERUG");
    private Button afsluitKnop = new Button("Afsluiting");
    private Button betaald = new Button("BETAALD");
    private Button annuleer = new Button("ANNULEER");

    public KassaOverviewPane(KassaController kassaController){
        producten = kassaController;
        kassaController.setPane(this);
        totaalBedrag = 0;
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        this.add(label,3,1);
        this.add(artikelCodeTextField,4,1);

        //Textfields
        this.add(totaal,3,2);
        this.add(labelTotaal,4,2);
        this.add(kortinglabel, 3, 3);
        kortinglabel.setVisible(false);
        this.add(eindTotaalLabel, 3,4);
        eindTotaalLabel.setVisible(false);


        //Bedragen
        this.add(korting, 4, 3);
        korting.setVisible(false);
        this.add(eindTotaal, 4, 4);
        eindTotaal.setVisible(false);


        //Buttons
        this.add(onHoldButton,0,2);
        this.add(onHoldButton2,0,3);
        this.add(afsluitKnop, 0, 4);
        this.add(betaald,0,5);
        this.add(annuleer,1,5);

        label.setFont(new Font("System", 18));
        totaal.setFont(new Font("System", 16));
        labelTotaal.setFont(new Font("System", 16));

        table = new TableView<Artikel>();

        TableColumn<Artikel, String> colOmschrijving = new TableColumn<Artikel, String>("Omschrijving");
        colOmschrijving.setMinWidth(300);
        colOmschrijving.setCellValueFactory(new PropertyValueFactory<Artikel, String>("omschrijving"));

        TableColumn<Artikel, Double> colPrijs = new TableColumn<Artikel, Double>("Prijs");
        colPrijs.setMinWidth(100);
        colPrijs.setCellValueFactory(new PropertyValueFactory<Artikel, Double>("prijs"));


        //InnerClasses of AnonymousClass implementatie
        artikelCodeTextField.setOnKeyPressed(new AddArtikelHandler());
        onHoldButton.setOnAction(new OnHoldHandler());
        onHoldButton2.setOnAction(new OnHoldReturnHandler());

        //afsluitKnop.setOnAction(new view.AfsluitHandler(korting, eindTotaal, kortinglabel, eindTotaalLabel));
        afsluitKnop.setOnAction(new AfsluitHandler());
        betaald.setOnAction(new BetaaldHandler());
        annuleer.setOnAction(new AnnuleerHandler());

        table.setRowFactory( tv -> {
            TableRow<Artikel> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                teVerwijderen = row.getItem();
                    new VerwijderHandler().handle(event);
                });
            return row;
        });

        table.getColumns().addAll(colOmschrijving, colPrijs);
        this.getChildren().addAll(table);
    }

    public void setTotaalBedrag(double bedrag){
        labelTotaal.setText(String.valueOf(bedrag));
    }

    public Artikel getArtikelTeVerwijderen(){
        return this.teVerwijderen;
    }

    public void setArtikellijst(ArrayList<Artikel> artikellijst) {
        table.setItems(FXCollections.observableArrayList(artikellijst));
        table.refresh();
    }

    public void setEindTotaal(double eindPrijs) {
        eindTotaal.setText(String.valueOf(eindPrijs));
    }

    public void setKorting(double korting) {
        this.korting.setText(String.valueOf(korting));
    }


    public class AddArtikelHandler implements EventHandler<KeyEvent>{

        @Override
        public void handle(KeyEvent event) {
            try{
            if (event.getCode() == KeyCode.ENTER) {
                Artikel artikel = producten.getArtikel(getIngevuldeWaarde());
                producten.addToLijst(artikel);
                artikelCodeTextField.clear();
            }
        }catch( DBException ex){
                displayErrorMessage(ex.getMessage());
            }
        }
    }

    public String getIngevuldeWaarde(){
        return artikelCodeTextField.getText();
    }

    // Open a popup that contains the error message passed
    public void displayErrorMessage(String errorMessage){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Belangrijke melding!");
        alert.setHeaderText("Informatie Alert!");
        alert.setContentText(errorMessage);
        alert.show();
    }
    public class VerwijderHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            try{
                if(event.getClickCount() == 2){
                    displayVerwijderBevestiging();
                }
            }catch( DBException ex){
                displayErrorMessage(ex.getMessage());
            }
        }
    }
    public void displayVerwijderBevestiging(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Verwijderbevestiging");
        alert.setHeaderText("Informatie Alert!");
        alert.setResizable(false);
        alert.setContentText("Wilt u dit artikel verwijderen ?");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK){
            producten.verwijderVanLijst(getArtikelTeVerwijderen());
        }else{
            System.out.println("Exiting alert");
        }
    }
    public class OnHoldHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            try{
                producten.setOnHoldList();
            }catch( DBException ex){
                displayErrorMessage(ex.getMessage());
            }
        }
    }
    public class OnHoldReturnHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            producten.returnToPreviousList();
        }
    }

    public class AfsluitHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            eindTotaal.setVisible(true);
            korting.setVisible(true);
            kortinglabel.setVisible(true);
            eindTotaalLabel.setVisible(true);
        }
    }

    private class BetaaldHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

            if (!eindTotaal.isVisible()){
                System.out.println("Druk eerst op alfsuiting");
            } else {
                System.out.println(producten.log(labelTotaal.getText(), korting.getText(), eindTotaal.getText()));
                producten.werkStockBij();
                producten.resetOnHoldListAls3keerBetaald();

                //WERK STOCK BIJ IN TAB2 OVERVIEW
                //TODO: Hoe?

                producten.nieuwVenster();
                eindTotaal.setVisible(false);
                korting.setVisible(false);
                kortinglabel.setVisible(false);
                eindTotaalLabel.setVisible(false);
            }





            //Maak voor de Verkoop klasse (de klasse voor een actuele verkoop van een klant ) een UML toestandsdiagram (state diagram) met alle mogelijke toestanden van een verkoop en alle mogelijke events (van story 3 tot en met story 9).
            //Pas het State design pattern toe om dit diagram te implementeren.
        }
    }

    public class AnnuleerHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            //ANNULEER IS PRESSED, VERKOOP WORDT NIET GELOGD!
            producten.nieuwVenster();
        }
    }
}
