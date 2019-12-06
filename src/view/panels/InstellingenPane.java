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

import javax.swing.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstellingenPane extends GridPane {
    private ArtikelCompany artikelCompany;

    public InstellingenPane(ArtikelCompany artikelCompany) throws IOException {

        Properties properties = new Properties();

        this.artikelCompany = artikelCompany;


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

        ComboBox<SoortBestand> comboBoxx = new ComboBox<>();
        comboBoxx.getItems().setAll(SoortBestand.values());


        group.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
            FileOutputStream os = null;

            if (group.getSelectedToggle() == rb2) {
                try {
                    os = new FileOutputStream("src" + File.separator + "database" + File.separator + "KassaApp.properties");
                    properties.clear();
                    properties.setProperty("databaseInMemory", "databaseInMemory");

                    properties.store(os,null);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

            if (group.getSelectedToggle() == rb1) {

                try {
                    os = new FileOutputStream("src" + File.separator + "database" + File.separator + "KassaApp.properties");
                    properties.clear();
                    properties.setProperty("deandere", "deandere");

                    properties.store(os,null);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        });


        InputStream in = new FileInputStream(new File("src" + File.separator + "database" + File.separator + "KassaApp.properties"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
        }
        this.add(new Label(out.toString()), 0, 12);
        if (out.toString().contains("deandere=deandere")){
            rb1.setSelected(true);
        } else if (out.toString().contains("databaseInMemory=databaseInMemory")){
            rb2.setSelected(true);
        }


        //out.toString()); Prints the string content read from input stream
        reader.close();







        this.add(rb1,0,1);
        this.add(rb2,0,2);
        this.add(comboBoxx,0,4);


    }

}
