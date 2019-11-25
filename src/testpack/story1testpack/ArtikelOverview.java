/*package testpack;

import model.Artikel;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.control.cell.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import model.ArtikelCompany;

public class ArtikelOverview extends VBox{
    private ArtikelCompany artikelCompany ;
    private TableView<Artikel> table ;

    public ArtikelOverview (ArtikelCompany artikelCompany){
        this.artikelCompany = artikelCompany;
        this.setSpacing(10);
        this.setPadding(new Insets(10, 10, 10, 10));
        Label lblHeading = new Label("Artikel Overview");
        lblHeading.setFont(new Font("Arial", 20));
        table = new TableView<Artikel>();
        table.setItems(artikelCompany.loadData());
*/
        //BIJ DUBBELKLIK AANPASSEN
        /*table.setRowFactory( tv -> {
            TableRow<Artikel> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Artikel artikel = row.getItem();
                    String artikelInfo= artikel.getOmschrijving()+" \nRecente prijs is "+ artikel.getPrijs()+" Euro: ";
                    new ArtikelDetailView(ArtikelOverview.this,artikelInfo,artikel);
                }
            });
            return row;
        });*/
/*
        TableColumn<Artikel, String> colID = new TableColumn<Artikel, String>("Artikel ID");
        colID.setMinWidth(100);
        colID.setCellValueFactory(new PropertyValueFactory<Artikel, String>("artikelCode"));

        TableColumn<Artikel, String> colOmschrijving = new TableColumn<Artikel, String>("Omschrijving");
        colOmschrijving.setMinWidth(300);
        colOmschrijving.setCellValueFactory(new PropertyValueFactory<Artikel, String>("omschrijving"));

        TableColumn<Artikel, String> colGroep = new TableColumn<Artikel, String>("Groep");
        colGroep.setMinWidth(100);
        colGroep.setCellValueFactory(new PropertyValueFactory<Artikel, String>("artikelGroep"));

        TableColumn<Artikel, Double> colPrijs = new TableColumn<Artikel, Double>("Prijs");
        colPrijs.setMinWidth(100);
        colPrijs.setCellValueFactory(new PropertyValueFactory<Artikel, Double>("prijs"));

        TableColumn<Artikel, Integer> colStock = new TableColumn<Artikel, Integer>("Stock");
        colStock.setMinWidth(100);
        colStock.setCellValueFactory(new PropertyValueFactory<Artikel, Integer>("stock"));

        table.getColumns().addAll(colID, colOmschrijving, colGroep, colPrijs, colStock);
        Button button = new Button("Voeg dummy artikel toe");*/
        /*button.setOnAction(new AddDummyArtikelHandler());*/
        /*Button button2 = new Button("Werk prijs bij van het geselecteerde artikel \nof dubbelklikken op de artikelrij");*/
        /*button2.setOnAction(new UpdatePriceHandler());*/
        /*this.getChildren().addAll(lblHeading, table,button,button2);
    }

    public void displayErrorMessage(String errorMessage){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText("Alert");
        alert.setContentText(errorMessage);
        alert.show();
    }

    public void refresh(){
        table.refresh();
    }
*/
    /*
    class AddDummyArtikelHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            artikelCompany.addDummyArtikel();
            TableViewSelectionModel <Artikel> tsm = table.getSelectionModel();
            tsm.select(artikelCompany.getAantalArtikels());
        }
    }

    class UpdatePriceHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            TableViewSelectionModel <Artikel> tsm = table.getSelectionModel();
            Artikel artikel = tsm.getSelectedItem();
            String artikelInfo= artikel.getOmschrijving()+" \nRecente prijs is" + artikel.getPrijs() + " Euro: ";
            new ArtikelDetailView(ArtikelOverview.this,artikelInfo,artikel);
        }
    }*/
//}
