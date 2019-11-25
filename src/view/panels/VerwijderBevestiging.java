package view.panels;

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
import javafx.scene.layout.GridPane;

public class VerwijderBevestiging extends GridPane {
    private Stage stage = new Stage();
    private KassaTab1OverviewPane kassaTab1OverviewPane;
    private Button btnOK, btnCancel;

    public VerwijderBevestiging(KassaTab1OverviewPane m, String artikelInfo) {
        this.kassaTab1OverviewPane = m;
        stage.setTitle("Verwijderbevestiging");
        this.setPrefHeight(150);
        this.setPrefWidth(500);

        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        this.add(new Label("Verwijder artikel: " + artikelInfo), 0, 0, 1, 1);


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
                    //artikel.setPrijs(Double.parseDouble(prijsVeld.getText()));
                }
                catch (NumberFormatException ex){
                    kassaTab1OverviewPane.displayErrorMessage("Prijs mag niet leeg zijn en moet een getal zijn");
                }
                catch (IllegalArgumentException ex){
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
