package view.panels;

import controller.KlantProductOverviewController;
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
import java.util.ArrayList;

/**
 * @author Marko Kosmajac, Max Van De Velde
 */

public class KlantOverviewPane extends GridPane {

    private TableView<Artikel> table;
    private double totaalBedrag;
    private ObservableList<Artikel> products;
    private KlantProductOverviewController producten;

    private Label labelTotaal = new Label(String.valueOf(totaalBedrag));
    private Label tot = new Label("TOTAALBEDRAG:");


    public KlantOverviewPane(KlantProductOverviewController klantProductOverviewController) {
        producten = klantProductOverviewController;
        products = FXCollections.observableArrayList(new ArrayList<Artikel>());

        klantProductOverviewController.setPane(this);

        totaalBedrag = 0;
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        this.add(tot, 3, 2);
        this.add(labelTotaal,4,2);
        tot.setFont(new Font("System", 16));
        labelTotaal.setFont(new Font("System", 16));

        table = new TableView<Artikel>();

        TableColumn<Artikel, String> colOmschrijving = new TableColumn<Artikel, String>("Omschrijving");
        colOmschrijving.setMinWidth(150);
        colOmschrijving.setCellValueFactory(new PropertyValueFactory<Artikel, String>("omschrijving"));

        TableColumn<Artikel, Integer> colAantal = new TableColumn<Artikel, Integer>("Aantal");
        colAantal.setMinWidth(20);
        colAantal.setCellValueFactory(new PropertyValueFactory<Artikel, Integer>("aantal"));

        TableColumn<Artikel, Double> colPrijs = new TableColumn<Artikel, Double>("Prijs");
        colPrijs.setMinWidth(130);
        colPrijs.setCellValueFactory(new PropertyValueFactory<Artikel, Double>("prijs"));

        table.getColumns().addAll(colOmschrijving, colAantal, colPrijs);
        this.getChildren().addAll(table);


    }

    public void setArtikellijst(ArrayList<Artikel> artikelijst) {
        table.setItems(FXCollections.observableArrayList(artikelijst));
    }

    /*private void totaalBedragUpdate() {
        labelTotaal.setText(String.valueOf(producten.getTotPrijs()));
        //https://stackoverflow.com/questions/51905888/updating-labels-from-other-classes-in-java-fx
    }*/

    public void setTotaalBedrag(double bedrag){
        labelTotaal.setText(String.valueOf(bedrag));
    }



}
