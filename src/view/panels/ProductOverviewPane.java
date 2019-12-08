package view.panels;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import model.Artikel;
import database.ArtikelDBContext;

import java.io.IOException;


public class ProductOverviewPane extends GridPane {
	private TableView<Artikel> table ;
	//private ArtikelCompany artikelCompany ; //TODO: FIXED WITH SINGLETON


	public ProductOverviewPane(ArtikelDBContext artikelDBContext) throws IOException { //TODO: PARAMETER FIXEN WITH SINGLETON OF NIET?
		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        
		this.add(new Label("Products:"), 0, 0, 1, 1);

		//this.artikelCompany = artikelCompany; //TODO: FIXED WITH SINGLETON ??? MAG DIT ZOMAAR WEG ???

		//this.setSpacing(10);
		this.setPadding(new Insets(10, 10, 10, 10));
		Label lblHeading = new Label("Artikel Overview");
		lblHeading.setFont(new Font("Arial", 20));
		table = new TableView<Artikel>();
        //table.setItems(artikelCompany.loadData());//TODO: SINGLETON HIERONDER FIX && AANPASSEN ZODAT OOK EXCEL KAN WORDEN INGELEZEN
		table.setItems(ArtikelDBContext.getInstance().loadData()); //TODO ZO FIXED OF ZOALS HIERBOVEN LATEN ??


		TableColumn<Artikel, String> colID = new TableColumn<Artikel, String>("Artikel ID");
		colID.setMinWidth(100);
		colID.setCellValueFactory(new PropertyValueFactory<Artikel, String>("artikelCode"));

		TableColumn<Artikel, String> colOmschrijving = new TableColumn<Artikel, String>("Omschrijving");
		colOmschrijving.setMinWidth(300);
		colOmschrijving.setCellValueFactory(new PropertyValueFactory<Artikel, String>("omschrijving"));

		TableColumn<Artikel, String> colGroep = new TableColumn<Artikel, String>("Groep");
		colGroep.setMinWidth(100);
		colGroep.setCellValueFactory(new PropertyValueFactory<Artikel, String>("artikelGroep"));

		TableColumn<Artikel, Double> colPrijs = new TableColumn<Artikel, Double>("Prijs");
		colPrijs.setMinWidth(100);
		colPrijs.setCellValueFactory(new PropertyValueFactory<Artikel, Double>("prijs"));

		TableColumn<Artikel, Integer> colStock = new TableColumn<Artikel, Integer>("Stock");
		colStock.setMinWidth(100);
		colStock.setCellValueFactory(new PropertyValueFactory<Artikel, Integer>("stock"));

		table.getColumns().addAll(colID, colOmschrijving, colGroep, colPrijs, colStock);
		Button button = new Button("...");
		Button button2 = new Button("...");
		this.add(button,0, 5, 1, 6);
		this.add(button2, 1,5,1,6);
		this.getChildren().addAll(lblHeading, table); //button, button2

	}

}
