package view.panels;

import controller.KassaController;
import controller.LogPaneController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import model.Artikel;
import model.Verkoop;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LogPane extends GridPane {
    private TableView<Verkoop> table = new TableView<Verkoop>();
    private ObservableList<Verkoop> verkopen;

    //TODO: MVC: Needs controller

    public LogPane(){

        verkopen = FXCollections.observableArrayList(FXCollections.observableArrayList(new ArrayList<>()));


        TableColumn colDatEnTijdstipBet = new TableColumn("Datum en Tijdstip betaling");
        colDatEnTijdstipBet.setMinWidth(270);
        colDatEnTijdstipBet.setCellValueFactory(new PropertyValueFactory<Verkoop, LocalDateTime>("dateEnTime"));

        TableColumn<Verkoop, Double> colTotaalBedrag = new TableColumn<Verkoop, Double>("Totaalbedrag");
        colTotaalBedrag.setMinWidth(150);
        colTotaalBedrag.setCellValueFactory(new PropertyValueFactory<Verkoop, Double>("totaalbedrag"));

        TableColumn<Verkoop, Double> colKorting = new TableColumn<Verkoop, Double>("Korting");
        colKorting.setMinWidth(50);
        colKorting.setCellValueFactory(new PropertyValueFactory<Verkoop, Double>("korting"));

        TableColumn<Verkoop, Double> colTeBetalen = new TableColumn<Verkoop, Double>("Te betalen");
        colTeBetalen.setMinWidth(100);
        colTeBetalen.setCellValueFactory(new PropertyValueFactory<Verkoop, Double>("teBetalenBedrag"));

        table.setItems(verkopen);
        table.getColumns().addAll(colDatEnTijdstipBet, colTotaalBedrag, colKorting,colTeBetalen);
        this.add(table,0,1,1,1);

    }

    public void setVerkoopLijst(List<Verkoop> verkoopLijst) {
        verkopen = FXCollections.observableArrayList(FXCollections.observableArrayList(verkoopLijst));
        table.setItems(verkopen);
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
