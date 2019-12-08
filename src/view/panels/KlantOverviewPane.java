package view.panels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import model.Artikel;
import database.ArtikelDBContext;

import java.util.ArrayList;

public class KlantOverviewPane extends GridPane {

    private TableView<Artikel> table ;
    private ArtikelDBContext artikelDBContext;
    private double totaalBedrag;
    private ObservableList<Artikel> products;


    public KlantOverviewPane(ArtikelDBContext artikelDBContext){
        products = FXCollections.observableArrayList(new ArrayList<Artikel>());

        totaalBedrag = 0;
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        Label labelTotaal = new Label(String.valueOf(totaalBedrag));
        Label tot = new Label("TOTAALBEDRAG:");

        this.add(tot,3,2);
        this.add(labelTotaal,4,2);
        tot.setFont(new Font("System", 12));
        labelTotaal.setFont(new Font("System", 12));

        this.artikelDBContext = artikelDBContext;

        table = new TableView<Artikel>();

        TableColumn<Artikel, String> colOmschrijving = new TableColumn<Artikel, String>("Omschrijving");
        colOmschrijving.setMinWidth(150);
        colOmschrijving.setCellValueFactory(new PropertyValueFactory<Artikel, String>("omschrijving"));

        TableColumn<Artikel, String> colAantal = new TableColumn<Artikel, String>("Aantal");
        colAantal.setMinWidth(20);
        colAantal.setCellValueFactory(new PropertyValueFactory<Artikel, String>("Aantal"));

        TableColumn<Artikel, Double> colPrijs = new TableColumn<Artikel, Double>("Prijs");
        colPrijs.setMinWidth(130);
        colPrijs.setCellValueFactory(new PropertyValueFactory<Artikel, Double>("prijs"));


        table.getColumns().addAll(colOmschrijving, colAantal, colPrijs);
        this.getChildren().addAll(table);


    }

}
