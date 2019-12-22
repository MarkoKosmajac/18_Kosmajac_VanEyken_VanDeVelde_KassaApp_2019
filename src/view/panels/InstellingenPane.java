package view.panels;

import application.Main;
import controller.ControllerException;
import controller.InstellingenController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import model.SoortBestand;
import model.SoortDatabase;
import model.SoortFooterLijn;
import model.SoortHeaderLijn;
import model.kortingstrategie.*;

import javax.swing.*;

/**
 * @author Marko Kosmajac, Phonkrit Van de Velde
 */

public class InstellingenPane extends GridPane {
    private InstellingenController instellingenController;
    private ComboBox<SoortBestand> comboBoxBestand;
    private ComboBox<SoortKorting> comboBoxKorting;
    private ComboBox<SoortDatabase> comboBoxDatabase;
    private ComboBox<SoortHeaderLijn> comboBoxHeader;
    private ComboBox<SoortFooterLijn> comboBoxFooter;
    private Button verzendKnop = new Button("Verzenden");
    private TextField percentText = new TextField("0");
    private TextField bedragText = new TextField("0");
    private Label kortingLabel = new Label();
    private CheckBox cb1 = new CheckBox("Headerlijn(en) toevoegen ?");
    private CheckBox cb2 = new CheckBox("Footerlijn(en) toevoegen ?");
    private TextField textHeaderlijnen = new TextField("VUL JE HEADERLIJN HIER IN.");
    private TextField textFooterlijnen = new TextField("VUL JE FOOTERLIJN HIER IN.");

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

        cb1.setOnAction((event) -> {
            TextField headerText = new TextField();
            headerText.setPromptText("Vul hier je eigen extra headerlijn in.");
            this.add(headerText,0,14);

            comboBoxHeader = new ComboBox<>();
            comboBoxHeader.getItems().setAll(SoortHeaderLijn.values());
            this.add(comboBoxHeader,0,15);

        });

        cb2.setOnAction((event) -> {
            TextField footerText = new TextField();
            footerText.setPromptText("Vul hier je eigen extra algemene footerlijn in.");
            this.add(footerText,0,17);

            comboBoxFooter = new ComboBox<>();
            comboBoxFooter.getItems().setAll(SoortFooterLijn.values());
            this.add(comboBoxFooter,0,18);
        });

        this.add(new Label("Optionele kortinginfo:"), 0, 8);
        this.add(new Label("Korting percentage"), 0, 9);
        this.add(percentText,1,9);
        this.add(new Label("Korting eurobedrag"), 0, 10);
        this.add(bedragText,1,10);

        this.add(verzendKnop,0,19);
        this.add(comboBoxDatabase,0,1);
        this.add(comboBoxBestand,0,4);
        this.add(comboBoxKorting,0,7);
        this.add(kortingLabel,0,12);
        this.add(cb1,0,13);
        this.add(cb2,0,16);
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
        if (getSelectedKorting().equalsIgnoreCase("DUURSTEKORTING")){
            return String.valueOf(instellingenController.getDuursteArtikel());
        }
        return bedragText.getText();
    }

    public boolean cb1Aangevinkt(){
        if (cb1.isSelected()){
            return true;
        }
        return false;
    }

    public boolean cb2Aangevinkt(){
        if (cb2.isSelected()){
            System.out.println("true");
            return true;

        }
        return false;
    }



    public String getTextHeaderlijnen() {
        return textHeaderlijnen.getText();
    }

    public String getTextFooterlijnen() {
        return textFooterlijnen.getText();
    }

    public void displayErrorMessage(String errorMessage){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Belangrijke melding!");
        alert.setHeaderText("Informatie Alert!");
        alert.setContentText(errorMessage);
        alert.show();
    }

    private class VerzendKeuzesHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

            try {
                instellingenController.setPropertiesDB(getSelectedFile(), getSelectedDatabase());

                if (cb1Aangevinkt()){
                    instellingenController.setPropertiesDecoratorHeader(getTextHeaderlijnen());
                }

                if (cb2Aangevinkt()){
                    instellingenController.setPropertiesDecoratorFooter(getTextFooterlijnen());
                }

                if (getSelectedKorting().equalsIgnoreCase("DREMPELKORTING")) {
                    instellingenController.getKortingStrategieString(new DrempelKorting(Integer.parseInt(getSelectedPercent()), Double.parseDouble(getSelectedBedrag())));
                }

                if (getSelectedKorting().equalsIgnoreCase("GROEPKORTING")){
                    instellingenController.getKortingStrategieString(new Groepkorting(Integer.parseInt(getSelectedPercent()), Double.parseDouble(getSelectedBedrag())));

                }

                if (getSelectedKorting().equalsIgnoreCase("DUURSTEKORTING")){
                    instellingenController.getKortingStrategieString(new DuursteKorting(Integer.parseInt(getSelectedPercent()), Double.parseDouble(getSelectedBedrag())));

                }



            }catch (Exception e) {
                displayErrorMessage("Niet genoeg parameters meegegeven voor gekozen korting. (Error: " + e.getCause() + ")");
            }
        }
    }


    private class VerzendHeaderInfo implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            try {

                   instellingenController.setPropertiesDecoratorHeader(getTextHeaderlijnen());
                   instellingenController.setPropertiesDecoratorFooter(getTextFooterlijnen());

            } catch (Exception e){
                displayErrorMessage(e.getMessage());
            }
        }
    }

    private class VerzendFooterInfo implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

        }
    }
}
