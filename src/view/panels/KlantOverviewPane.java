package view.panels;

import database.Observer;
import database.Subject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import model.Artikel;
import database.ArtikelDBContext;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class KlantOverviewPane extends GridPane implements Subject {

    private TableView<Artikel> table;
    private ArtikelDBContext artikelDBContext;
    private double totaalBedrag;
    private ObservableList<Artikel> products;
    private List<Observer> observers = new ArrayList<>();


    public KlantOverviewPane(ArtikelDBContext artikelDBContext) {
        products = FXCollections.observableArrayList(new ArrayList<Artikel>());


        totaalBedrag = 0;
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        Label labelTotaal = new Label(String.valueOf(totaalBedrag));
        Label tot = new Label("TOTAALBEDRAG:");

        this.add(tot, 3, 2);
        this.add(labelTotaal, 4, 2);
        tot.setFont(new Font("System", 12));
        labelTotaal.setFont(new Font("System", 12));

        this.artikelDBContext = artikelDBContext;

        table = new TableView<Artikel>();

        TableColumn<Artikel, String> colOmschrijving = new TableColumn<Artikel, String>("Omschrijving");
        colOmschrijving.setMinWidth(150);
        colOmschrijving.setCellValueFactory(new PropertyValueFactory<Artikel, String>("omschrijving"));

        TableColumn<Artikel, String> colAantal = new TableColumn<Artikel, String>("Aantal");
        colAantal.setMinWidth(20);
        colAantal.setCellValueFactory(new PropertyValueFactory<Artikel, String>("Aantal"));

        TableColumn<Artikel, Double> colPrijs = new TableColumn<Artikel, Double>("Prijs");
        colPrijs.setMinWidth(130);
        colPrijs.setCellValueFactory(new PropertyValueFactory<Artikel, Double>("prijs"));


        table.getColumns().addAll(colOmschrijving, colAantal, colPrijs);
        this.getChildren().addAll(table);


    }

    @Override
    public void register(java.util.Observer newObserver) {
        observers.add((Observer) newObserver);
        System.out.println("Observer toegevoegd");
    }

    @Override
    public void unregister(java.util.Observer deleteObserver) {

        observers.remove(deleteObserver);
        System.out.println("Observer verwijderd");

    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(1);
            System.out.println("Aantal is met 1 verhoogd");

        }
    }


}
