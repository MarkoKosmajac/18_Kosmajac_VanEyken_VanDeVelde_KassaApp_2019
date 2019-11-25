package view.panels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.Artikel;
import model.ArtikelCompany;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;
public class KassaTab1OverviewPane extends GridPane {
    private TableView<Artikel> table ;
    private ArtikelCompany artikelCompany;
    private double totaalBedrag;
    private ObservableList<Artikel> products;

    public KassaTab1OverviewPane(ArtikelCompany artikelCompany){
        products = FXCollections.observableArrayList(new ArrayList<Artikel>());

        totaalBedrag = 0;
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        Label label = new Label("Artikelcode:");
        TextField text = new TextField();
        Label labelTotaal = new Label(String.valueOf(totaalBedrag));

        this.add(label,0,2,1,1);
        this.add(text,1,2,1,1);
        this.add(labelTotaal,2,2,1,1);

        this.artikelCompany = artikelCompany;

        table = new TableView<Artikel>();

        TableColumn<Artikel, String> colOmschrijving = new TableColumn<Artikel, String>("Omschrijving");
        colOmschrijving.setMinWidth(300);
        colOmschrijving.setCellValueFactory(new PropertyValueFactory<Artikel, String>("omschrijving"));

        TableColumn<Artikel, Double> colPrijs = new TableColumn<Artikel, Double>("Prijs");
        colPrijs.setMinWidth(100);
        colPrijs.setCellValueFactory(new PropertyValueFactory<Artikel, Double>("prijs"));

        text.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String invoer = text.getText();
                String em = artikelCompany.zoek(invoer);
                Artikel artikel = artikelCompany.zoekArtikel(invoer);
                if(em.contains(",")){ //PRODUCT = FOUND
                    String omschr = artikel.getOmschrijving();
                    double prijs = artikel.getPrijs();
                    totaalBedrag += artikel.getPrijs();
                    System.out.println("Omschrijving: " + omschr + " Prijs: " + prijs + " totaal: " + totaalBedrag);
                    products.add(artikel);
                    table.setItems(products);
                    text.clear();
                }
                else{
                    System.out.println(em);
                    text.clear();
                    popUpCodeNietGevonden();
                }
            }
            labelTotaal.setText(String.valueOf(totaalBedrag)); //LABEL UPDATEN
        }
        );

        table.getColumns().addAll(colOmschrijving, colPrijs);
        this.getChildren().addAll(table);


    }

    public static void popUpCodeNietGevonden(){
        Stage newStage = new Stage();
        VBox comp = new VBox();
        Label label = new Label("Artikelcode niet gevonden!");
        label.setFont(new Font("Arial", 18));
        comp.getChildren().add(label);

        Scene stageScene = new Scene(comp,300,75);
        newStage.setScene(stageScene);
        newStage.show();
    }





}
