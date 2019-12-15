package view.panels;

import controller.KassaController;
import controller.KlantController;
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
    private double totaalBedrag, eindTotaal;
    private int korting;
    private ObservableList<Artikel> products;
    private KlantController producten;
    private KassaOverviewPane kassaOverviewPane;

    private Label labelTotaal = new Label(String.valueOf(totaalBedrag));
    private Label tot = new Label("TOTAALBEDRAG:");
    private Label kortingLabel = new Label(String.valueOf(korting));
    private Label eindTotaalLabel = new Label(String.valueOf(eindTotaal));
    private Label eindTotaalLabelTekst = new Label("EINDTOTAAL:");
    private Label kortinglabelTekst = new Label("KORTING:");



    public KlantOverviewPane(KlantController klantController) {
        this.producten = klantController;
        products = FXCollections.observableArrayList(new ArrayList<Artikel>());

        klantController.setPane(this);

        totaalBedrag = 0;
        eindTotaal = 0;
        korting = 0;
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        this.add(tot, 3, 2);
        this.add(labelTotaal,4,2);
        this.add(kortingLabel, 4, 3);
        this.add(eindTotaalLabel, 4, 4);
        this.add(kortinglabelTekst,3,3);
        this.add(eindTotaalLabelTekst,3,4);
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

        kortingLabel.setVisible(false);
        kortinglabelTekst.setVisible(false);
        eindTotaalLabel.setVisible(false);
        eindTotaalLabelTekst.setVisible(false);



    }

    public void setArtikellijst(ArrayList<Artikel> artikelijst) {
        table.setItems(FXCollections.observableArrayList(artikelijst));
        table.refresh(); //DIT
    }



    public void setTotaalBedrag(double bedrag){
        labelTotaal.setText(String.valueOf(bedrag));
    }
    public void setKorting(double korting) {
        kortingLabel.setText(String.valueOf(korting));
    }


    public void setEindTotaal(double eindTotaal){


        eindTotaalLabel.setText(String.valueOf(eindTotaal));
    }

    public void setEindLayout() {
        kortingLabel.setVisible(true);
        kortinglabelTekst.setVisible(true);
        eindTotaalLabel.setVisible(true);
        eindTotaalLabelTekst.setVisible(true);
    }
}
