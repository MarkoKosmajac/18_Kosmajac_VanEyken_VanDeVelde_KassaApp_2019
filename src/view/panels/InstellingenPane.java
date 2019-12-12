package view.panels;

/**
 * @author Marko Kosmajac
 */

import controller.InstellingenController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import database.ArtikelDBContext;
import model.SoortBestand;
import model.kortingstrategie.SoortKorting;

import java.io.*;
import java.util.Properties;

public class InstellingenPane extends GridPane {
    private ArtikelDBContext artikelDBContext; //TODO: MOET DIT HIER ? KAN DIT NIET WEG
    private InstellingenController instellingenController;
    private ComboBox<SoortBestand> comboBoxBestand;
    private Button verzendKnop;

    public InstellingenPane(){

        Properties properties = new Properties();

        this.artikelDBContext = artikelDBContext; //TODO: MOET DIT HIER ? KAN DIT NIET WEG ? ZO JA, FIX MET SINGLETON METHOD getinstance!

        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        this.add(new Label("Opties:"), 0, 0);

        final ToggleGroup group = new ToggleGroup();

        RadioButton rb1 = new RadioButton(" Relationele Database");
        rb1.setToggleGroup(group);
        //rb1.setSelected(true);

        RadioButton rb2 = new RadioButton("In Memory Database");
        rb2.setToggleGroup(group);

        this.add(new Label("Indien gekozen voor 'In Memory Database' "),0,3);

        comboBoxBestand = new ComboBox<>();
        comboBoxBestand.getItems().setAll(SoortBestand.values());

        this.add(new Label("Kortingkeuze:"), 0, 5);
        ComboBox<SoortKorting> comboBoxKorting = new ComboBox<>();
        comboBoxKorting.getItems().setAll(SoortKorting.values());

        verzendKnop.setOnAction(new VerzendKeuzesHandler());

        this.add(new Label("Optionele kortinginfo:"), 0, 8);
        this.add(new Label("Korting percentage"), 0, 9);
        this.add(new TextField(),1,9);
        this.add(new Label("Korting eurobedrag"), 0, 10);
        this.add(new TextField(),1,10);

        this.add(verzendKnop,0,9);
        this.add(rb1,0,1);
        this.add(rb2,0,2);
        this.add(comboBoxBestand,0,4);
        this.add(comboBoxKorting,0,7);

    }

    public String getSelectedRadiobutton(){
        return comboBoxBestand.getValue().toString();

    }


    private class VerzendKeuzesHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            instellingenController.setPropertiesDB(getSelectedRadiobutton());
        }
    }
}
