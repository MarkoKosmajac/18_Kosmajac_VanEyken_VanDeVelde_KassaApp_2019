package view.panels;

import controller.KassaProductOverviewController;
import controller.VoegToeController;
import database.DBException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Artikel;
import database.ArtikelDBContext;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.w3c.dom.events.Event;
import view.KassaMainPane;
import view.KassaView;

import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;


public class KassaTab1OverviewPane extends GridPane {
    private TableView<Artikel> table ;
    private double totaalBedrag;
    private KassaProductOverviewController producten;
    private Artikel teVerwijderen;

    private Label label = new Label("Artikelcode:");
    private TextField artikelCodeTextField = new TextField();
    private Label labelTotaal = new Label(String.valueOf(totaalBedrag));
    private Label tot = new Label("TOTAALBEDRAG:");

    public KassaTab1OverviewPane(KassaProductOverviewController kassaProductOverviewController){
        producten = kassaProductOverviewController;
        kassaProductOverviewController.setPane(this);
        totaalBedrag = 0;
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        this.add(label,3,1);
        this.add(artikelCodeTextField,4,1);
        this.add(tot,3,2);
        this.add(labelTotaal,4,2);

        label.setFont(new Font("System", 18));
        tot.setFont(new Font("System", 18));
        labelTotaal.setFont(new Font("System", 18));

        table = new TableView<Artikel>();

        TableColumn<Artikel, String> colOmschrijving = new TableColumn<Artikel, String>("Omschrijving");
        colOmschrijving.setMinWidth(300);
        colOmschrijving.setCellValueFactory(new PropertyValueFactory<Artikel, String>("omschrijving"));

        TableColumn<Artikel, Double> colPrijs = new TableColumn<Artikel, Double>("Prijs");
        colPrijs.setMinWidth(100);
        colPrijs.setCellValueFactory(new PropertyValueFactory<Artikel, Double>("prijs"));

        artikelCodeTextField.setOnKeyPressed(new AddArtikelHandler());

        table.setRowFactory( tv -> {
            TableRow<Artikel> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                teVerwijderen = row.getItem();
                    new VerwijderHandler().handle(event); //TODO: Niet vergeten na de handler nog te doen .handle(event)
                });
            return row;
        });


        table.getColumns().addAll(colOmschrijving, colPrijs);
        this.getChildren().addAll(table);
    }

    public Artikel getArtikelTeVerwijderen(){
        return this.teVerwijderen;
    }

    public void setArtikellijst(ArrayList<Artikel> artikellijst) {
        table.setItems(FXCollections.observableArrayList(artikellijst));
    }

    public class AddArtikelHandler implements EventHandler<KeyEvent>{

        @Override
        public void handle(KeyEvent event) {
            try{
            if (event.getCode() == KeyCode.ENTER) {
                Artikel artikel = producten.getArtikel(getIngevuldeWaarde());
                producten.addToLijst(artikel);
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
        alert.setHeaderText("Informatie Alert!");
        alert.setContentText(errorMessage);
        alert.show();
    }

    public void refresh(){
        table.refresh();
    }


    public class VerwijderHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            try{
                if(event.getClickCount() == 2){
                    new VerwijderBevestiging();
                    producten.verwijderVanLijst(getArtikelTeVerwijderen());
                }
            }catch( DBException ex){
                displayErrorMessage(ex.getMessage());
            }
        }
    }
}
