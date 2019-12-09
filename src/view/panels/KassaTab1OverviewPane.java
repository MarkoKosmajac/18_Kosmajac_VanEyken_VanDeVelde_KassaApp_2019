package view.panels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Artikel;
import database.ArtikelDBContext;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;


public class KassaTab1OverviewPane extends GridPane {
    private TableView<Artikel> table ;
    private ArtikelDBContext artikelDBContext;
    private double totaalBedrag;
    private ObservableList<Artikel> products;

    private Label label = new Label("Artikelcode:");
    private TextField text = new TextField();
    private Label labelTotaal = new Label(String.valueOf(totaalBedrag));
    private Label tot = new Label("TOTAALBEDRAG:");
    private TextField eme = new TextField();

    public KassaTab1OverviewPane(ArtikelDBContext artikelDBContext){
        this.artikelDBContext = artikelDBContext;
        products = FXCollections.observableArrayList(new ArrayList<Artikel>());

        totaalBedrag = 0;
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        this.add(label,3,1);
        this.add(text,4,1);
        this.add(tot,3,2);
        this.add(labelTotaal,4,2);
        this.add(eme,4,3);

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


        /*text.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String invoer = text.getText();
                String em = artikelDBContext.zoek(invoer);
                Artikel artikel = artikelDBContext.zoekArtikel(invoer);
                if(em.contains(",")){ //PRODUCT = FOUND
                    String omschr = artikel.getOmschrijving();
                    double prijs = artikel.getPrijs();
                    totaalBedrag += artikel.getPrijs();
                    //System.out.println("Omschrijving: " + omschr + " Prijs: " + prijs + " totaal: " + totaalBedrag);
                    products.add(artikel);
                    table.setItems(products);
                    text.clear();

                    //OBSERVER ANDERE KLASSE --- STORY 4

                }
                else{
                    System.out.println(em);
                    text.clear();
                    popUpCodeNietGevonden();
                }
            }
            labelTotaal.setText(String.valueOf(totaalBedrag)); //LABEL UPDATEN
        }
        );*/


        /*table.setRowFactory( tv -> {
            TableRow<Artikel> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Artikel artikel = row.getItem();
                    String artikelInfo = artikel.getOmschrijving();
                    String code = artikel.getArtikelCode();
                    try {
                        new VerwijderBevestiging(KassaTab1OverviewPane.this,artikelInfo, code);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //popUpDeleteConfirm(artikelInfo, code);
                }
            });
            return row;
        });*/

        table.getColumns().addAll(colOmschrijving, colPrijs);
        this.getChildren().addAll(table);



    }

    //TODO: VAN HIER

    public String getIngevuldeWaarde(){
        return text.getText();
    }

    public void setWaarde(String waarde){
        eme.setText(waarde);
    }

    //public void addVoegToeHandler(EventHandler<? super KeyEvent> listenForVoegToeEnter){
    public void addVoegToeHandler(EventHandler<KeyEvent> listenForVoegToeEnter){
        //text.setOnAction(listenForVoegToeEnter);
        text.setOnKeyPressed(listenForVoegToeEnter);
    }

    // Open a popup that contains the error message passed
    public void displayErrorMessage(String errorMessage){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Information Alert");
        alert.setContentText(errorMessage);
        alert.show();
    }

    //TODO: TOT HIER

    public static void popUpCodeNietGevonden(){
        Stage newStage = new Stage();
        VBox comp = new VBox();
        Label label = new Label("Artikelcode niet gevonden!");
        label.setFont(new Font("System", 18));
        label.setMaxWidth(Double.MAX_VALUE);
        label.setAlignment(Pos.CENTER);
        comp.getChildren().add(label);

        Scene stageScene = new Scene(comp,300,75);
        newStage.setScene(stageScene);
        newStage.show();
    }

    public void popUpDeleteConfirm(String artikelinfo, String code){
        Stage newStage = new Stage();
        VBox comp = new VBox();
        Label label = new Label("Verwijder " + artikelinfo + " ?");
        label.setFont(new Font("System", 18));
        label.setMaxWidth(Double.MAX_VALUE);
        label.setAlignment(Pos.CENTER);

        Button buttonJa = new Button("Ja");
        Button buttonNee = new Button("Nee");

        comp.getChildren().addAll(label);
        this.add(buttonJa,0,1);
        this.add(buttonNee,1,1);

        Scene stageScene = new Scene(comp,300,75);
        newStage.setScene(stageScene);
        newStage.show();
    }

    /*public void displayErrorMessage(String errorMessage){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Alert");
        alert.setContentText(errorMessage);
        alert.show();
    }*/

    public void refresh(){
        table.refresh();
    }





}
