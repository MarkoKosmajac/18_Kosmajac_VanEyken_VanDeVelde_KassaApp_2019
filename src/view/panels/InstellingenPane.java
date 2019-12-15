package view.panels;

import controller.InstellingenController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.SoortBestand;
import model.SoortDatabase;
import model.kortingstrategie.SoortKorting;

/**
 * @author Marko Kosmajac
 */

public class InstellingenPane extends GridPane {
    private InstellingenController instellingenController;
    private ComboBox<SoortBestand> comboBoxBestand;
    private ComboBox<SoortKorting> comboBoxKorting;
    private ComboBox<SoortDatabase> comboBoxDatabase;
    private Button verzendKnop = new Button("Verzenden");
    private TextField percentText = new TextField();
    private TextField bedragText = new TextField();
    private Label kortingLabel = new Label();

    public InstellingenPane(){
        instellingenController = new InstellingenController();
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        this.add(new Label("Opties:"), 0, 0);

        comboBoxBestand = new ComboBox<>();
        comboBoxBestand.getItems().setAll(SoortBestand.values());

        comboBoxDatabase = new ComboBox<>();
        comboBoxDatabase.getItems().setAll(SoortDatabase.values());

        this.add(new Label("Indien gekozen voor 'In Memory Database' "),0,3);

        comboBoxBestand = new ComboBox<>();
        comboBoxBestand.getItems().setAll(SoortBestand.values());

        this.add(new Label("Kortingkeuze:"), 0, 5);

        comboBoxKorting = new ComboBox<>();
        comboBoxKorting.getItems().setAll(SoortKorting.values());

        verzendKnop.setOnAction(new VerzendKeuzesHandler());

        this.add(new Label("Optionele kortinginfo:"), 0, 8);
        this.add(new Label("Korting percentage"), 0, 9);
        this.add(percentText,1,9);
        this.add(new Label("Korting eurobedrag"), 0, 10);
        this.add(bedragText,1,10);

        this.add(verzendKnop,0,11);
        this.add(comboBoxDatabase,0,1);
        this.add(comboBoxBestand,0,4);
        this.add(comboBoxKorting,0,7);
        this.add(kortingLabel,0,12);

    }

    public String getSelectedFile(){
        return comboBoxBestand.getValue().toString();
    }

    public String getSelectedKorting(){
        return comboBoxKorting.getValue().toString();
    }

    public String getSelectedDatabase(){
        return comboBoxDatabase.getValue().toString();
    }

    public String getSelectedPercent(){
        return percentText.getText();
    }

    public String getSelectedBedrag(){
        return bedragText.getText();
    }

    private class VerzendKeuzesHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            try {
                instellingenController.setPropertiesDB(getSelectedFile(), getSelectedDatabase());

                if(getSelectedKorting().equalsIgnoreCase("DREMPELKORTING")){
                    try{

                        instellingenController.setPropertiesKeuzeKorting(getSelectedKorting(),Integer.parseInt(getSelectedPercent()),Double.parseDouble(getSelectedBedrag()));
                        String string = "Geselecteerde korting: " + getSelectedKorting() + " met procent: " + getSelectedPercent() + "% en een bedrag van: " + getSelectedBedrag() + " euro.";
                        kortingLabel.setText(string);
                    }catch(Exception e){
                        displayErrorMessage("Niet genoeg parameters meegegeven voor gekozen korting.");
                    }
                }else{
                    try{
                        instellingenController.setPropertiesKeuzeKorting(getSelectedKorting(),Integer.parseInt(getSelectedPercent()),0);

                        String string = "Geselecteerde korting: " + getSelectedKorting() + " met procent: " + getSelectedPercent() + "%";
                        kortingLabel.setText(string);
                    }catch(Exception e){
                        displayErrorMessage("Niet genoeg parameters meegegeven voor gekozen korting.");
                    }
                }

            } catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }

    // Open a popup that contains the error message passed
    public void displayErrorMessage(String errorMessage){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Belangrijke melding!");
        alert.setHeaderText("Informatie Alert!");
        alert.setContentText(errorMessage);
        alert.show();
    }

}
