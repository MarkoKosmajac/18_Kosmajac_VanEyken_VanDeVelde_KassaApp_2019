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
import model.SoortBestand;
import model.SoortDatabase;
import model.kortingstrategie.*;

/**
 * @author Marko Kosmajac
 */

public class InstellingenPane extends GridPane {
    private InstellingenController instellingenController;
    private ComboBox<SoortBestand> comboBoxBestand;
    private ComboBox<SoortKorting> comboBoxKorting;
    private ComboBox<SoortDatabase> comboBoxDatabase;
    private Button verzendKnop = new Button("Verzenden");
    private TextField percentText = new TextField("0");
    private TextField bedragText = new TextField("0");
    private Label kortingLabel = new Label();
   /*private CheckBox cb1 = new CheckBox("Headerlijn(en) toevoegen ?");
    private CheckBox cb2 = new CheckBox("Footerlijn(en) toevoegen ?");
    private TextField textHeaderlijnen = new TextField("VUL JE HEADERLIJN HIER IN.");
    private TextField textFooterlijnen = new TextField("VUL JE FOOTERLIJN HIER IN.");*/

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

        /*cb1.setOnAction((event) -> {
            // Button was clicked, do something...
            this.add(textHeaderlijnen,0,14);
        });

        cb2.setOnAction((event) -> {
            // Button was clicked, do something...
            this.add(textFooterlijnen,0,16);
        });*/

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
        /*this.add(cb1,0,13);
        this.add(cb2,0,15);*/

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

    /*public String getTextHeaderlijnen() {
        return textHeaderlijnen.getText();
    }

    public String getTextFooterlijnen() {
        return textFooterlijnen.getText();
    }*/

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
                displayErrorMessage("Niet genoeg parameters meegegeven voor gekozen korting." + e.getCause());
            }
            //Platform.exit();
        }
    }


}
