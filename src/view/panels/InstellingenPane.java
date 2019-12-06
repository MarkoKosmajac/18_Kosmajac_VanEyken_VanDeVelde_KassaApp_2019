package view.panels;

/**
 * @author Marko Kosmajac
 */

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.Artikel;
import model.ArtikelCompany;
import model.SoortBestand;

import java.io.*;
import java.util.Properties;

public class InstellingenPane extends GridPane {
    private ArtikelCompany artikelCompany;

    public InstellingenPane(ArtikelCompany artikelCompany) throws IOException {

        Properties properties = new Properties();
        InputStream is = new FileInputStream("src\\database\\KassaApp.properties");
        FileOutputStream os = new FileOutputStream("src\\database\\KassaApp.properties");
        String em = properties.getProperty("databaseInMemory");

        this.artikelCompany = artikelCompany;

        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        this.add(new Label("Opties:"), 0, 0);

        final ToggleGroup group = new ToggleGroup();

        RadioButton rb1 = new RadioButton("Relationele Database");
        rb1.setToggleGroup(group);
        //rb1.setSelected(true);

        RadioButton rb2 = new RadioButton("In Memory Database");
        rb2.setToggleGroup(group);

        this.add(new Label("Indien gekozen voor 'In Memory Database' "),0,3);

        ComboBox<SoortBestand> comboBoxx = new ComboBox<>();
        comboBoxx.getItems().setAll(SoortBestand.values());


        this.add(rb1,0,1);
        this.add(rb2,0,2);
        this.add(comboBoxx,0,4);


    }

}
