package view.panels;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import model.Artikel;
import model.ArtikelCompany;

public class InstellingenPane extends GridPane { //TODO: Simplify code by letting panes extend a Pane (Here gridpane)!
    //private TableView<Artikel> table ;//TODO: alle veldjes, rijen, uit de tekstfile....
    private ArtikelCompany artikelCompany ;

    public InstellingenPane(ArtikelCompany artikelCompany){
        this.artikelCompany = artikelCompany;

        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        this.add(new Label("Opties:"), 0, 0, 1, 1);

        final ToggleGroup group = new ToggleGroup();

        RadioButton rb1 = new RadioButton("Relationele Database");
        rb1.setToggleGroup(group);
        rb1.setSelected(true);

        RadioButton rb2 = new RadioButton("In Memory Database");
        rb2.setToggleGroup(group);


        this.add(rb1,0,1);
        this.add(rb2,0,2);

        //this.getChildren().addAll(lblHeading, table); //button, button2

    }
}
