package view.panels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Artikel;
import model.ArtikelCompany;


public class VerwijderBevestiging extends GridPane {
    private Stage stage = new Stage();
    private KassaTab1OverviewPane kassaTab1OverviewPane;
    private ArtikelCompany artikelCompany;

    public VerwijderBevestiging(KassaTab1OverviewPane m, String artikelInfo, String code) {
        artikelCompany = new ArtikelCompany();
        this.kassaTab1OverviewPane = m;
        stage.setTitle("Verwijderbevestiging");
        this.setPrefHeight(150);
        this.setPrefWidth(300);

        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        this.add(new Label("Verwijder artikel: " + artikelInfo), 0, 0, 1, 1);


        Button btnCancel = new Button("Cancel");
        btnCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                stage.close();
            }
        });
        this.add(btnCancel, 0, 3, 1, 1);

        Button btnOK = new Button("Verwijder");
        btnOK.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                try{
                    //artikel.setPrijs(Double.parseDouble(prijsVeld.getText()));
                    artikelCompany.verwijderArtikel(code);

                }
                catch (IllegalArgumentException ex){
                    System.out.println("ATCHEEEE");
                    kassaTab1OverviewPane.displayErrorMessage(ex.getMessage());
                }
                kassaTab1OverviewPane.refresh();
                stage.close();
            }
        });
        btnOK.isDefaultButton();
        this.add(btnOK, 1, 3, 1, 1);

        Scene scene = new Scene(this);
        stage.setScene(scene);
        stage.show();
    }


}
