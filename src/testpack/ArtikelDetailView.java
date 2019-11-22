/*package testpack;

import model.Artikel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ArtikelDetailView extends GridPane {
    private Stage stage = new Stage();
    private ArtikelOverview artikelOverview;
    private Button btnOK, btnCancel;
    private TextField prijsVeld;

    public ArtikelDetailView(ArtikelOverview m, String artikelInfo, Artikel artikel) {
        this.artikelOverview = m;
        stage.setTitle("Werk prijs bij");
        this.setPrefHeight(150);
        this.setPrefWidth(500);

        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        this.add(new Label("Werk prijs bij voor: " + artikelInfo), 0, 0, 1, 1);
        prijsVeld = new TextField();
        this.add(prijsVeld, 1, 0, 1, 1);

        btnCancel = new Button("Cancel");
        btnCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                stage.close();
            }
        });
        this.add(btnCancel, 0, 3, 1, 1);

        btnOK = new Button("Save");
        btnOK.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                try{
                    artikel.setPrijs(Double.parseDouble(prijsVeld.getText()));
                }
                catch (NumberFormatException ex){
                    artikelOverview.displayErrorMessage("Prijs mag niet leeg zijn en moet een getal zijn");
                }
                catch (IllegalArgumentException ex){
                    artikelOverview.displayErrorMessage(ex.getMessage());
                }
                artikelOverview.refresh();
                stage.close();
            }
        });
        btnOK.isDefaultButton();
        this.add(btnOK, 1, 3, 1, 1);

        Scene scene = new Scene(this);
        stage.setScene(scene);
        stage.show();
    }
}*/