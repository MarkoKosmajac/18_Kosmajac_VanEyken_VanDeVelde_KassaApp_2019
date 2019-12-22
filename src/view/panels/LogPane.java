package view.panels;

import controller.KassaController;
import controller.LogPaneController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import model.Artikel;
import model.Verkoop;

import java.util.ArrayList;

public class LogPane extends GridPane {
    private TableView<Verkoop> table ;
    private KassaController kassaController;

    public LogPane(){

        table = new TableView<Verkoop>();

        TableColumn<Verkoop, String> colDatEnTijdstipBet = new TableColumn<Verkoop, String>("Datum en Tijdstip betaling");
        colDatEnTijdstipBet.setMinWidth(270);
        colDatEnTijdstipBet.setCellValueFactory(new PropertyValueFactory<Verkoop, String>("datumEnTijdBetaling"));

        TableColumn<Verkoop, Double> colTotaalBedrag = new TableColumn<Verkoop, Double>("Totaalbedrag");
        colTotaalBedrag.setMinWidth(150);
        colTotaalBedrag.setCellValueFactory(new PropertyValueFactory<Verkoop, Double>("totaalbedrag"));

        TableColumn<Verkoop, Double> colKorting = new TableColumn<Verkoop, Double>("Korting");
        colKorting.setMinWidth(50);
        colKorting.setCellValueFactory(new PropertyValueFactory<Verkoop, Double>("korting"));

        TableColumn<Verkoop, Double> colTeBetalen = new TableColumn<Verkoop, Double>("Te betalen");
        colTeBetalen.setMinWidth(100);
        colTeBetalen.setCellValueFactory(new PropertyValueFactory<Verkoop, Double>("teBetalenBedrag"));

        table.getColumns().addAll(colDatEnTijdstipBet, colTotaalBedrag, colKorting,colTeBetalen);
        this.getChildren().addAll(table);

    }

    public void setVerkoopLijst(ArrayList<Verkoop> verkoopLijst) {
        table.setItems(FXCollections.observableArrayList(verkoopLijst));
        table.refresh();
    }

    /*
    //eigen controller, zo fixen dat die de log oproept...
    private LogPaneController logpanecontroller;
    private Label logsLabel = new Label("LOGS: ");
    private Label log = new Label();

    public LogPane(LogPaneController logPaneController){
        this.logpanecontroller = logPaneController;

        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);


        this.add(logsLabel,0,0);

        setLog();
    }

    private void setLog(){
        this.add(new Label(logpanecontroller.log("e","ee","pp")),0,2);
    }
    */
}
