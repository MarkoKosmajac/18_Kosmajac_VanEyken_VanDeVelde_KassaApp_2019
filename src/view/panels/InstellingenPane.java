package view.panels;

/**
 * @author Marko Kosmajac
 */

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import database.ArtikelDBContext;
import model.SoortBestand;
import model.SoortKorting;

import java.io.*;
import java.util.Properties;

public class InstellingenPane extends GridPane {
    private ArtikelDBContext artikelDBContext; //TODO: MOET DIT HIER ? KAN DIT NIET WEG ?

    public InstellingenPane(ArtikelDBContext artikelDBContext) throws IOException {

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

        ComboBox<SoortBestand> comboBoxBestand = new ComboBox<>();
        comboBoxBestand.getItems().setAll(SoortBestand.values());

        this.add(new Label("Kortingkeuze:"), 0, 5);
        ComboBox<SoortKorting> comboBoxKorting = new ComboBox<>();
        comboBoxKorting.getItems().setAll(SoortKorting.values());


        this.add(new Label("Optionele kortinginfo:"), 0, 8);
        this.add(new Label("Korting percentage"), 0, 9);
        this.add(new TextField(),1,9);
        this.add(new Label("Korting eurobedrag"), 0, 10);
        this.add(new TextField(),1,10);




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
        this.add(comboBoxBestand,0,4);
        this.add(comboBoxKorting,0,7);


    }

}
