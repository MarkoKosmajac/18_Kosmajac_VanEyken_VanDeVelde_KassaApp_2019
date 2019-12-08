package view;


import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import model.Artikel;
import model.ArtikelCompany;
import view.panels.InstellingenPane;
import view.panels.KassaTab1OverviewPane;
import view.panels.ProductOverviewPane;

import java.io.IOException;

public class KassaMainPane extends BorderPane {
	public KassaMainPane() throws IOException {

        //ArtikelCompany artikelcompanyke = new ArtikelCompany();//TODO: FIXED WITH SINGLETON
	    TabPane tabPane = new TabPane();
        KassaTab1OverviewPane kassaTab1OverviewPane = new KassaTab1OverviewPane(ArtikelCompany.getInstance()); //VROEGER: artikelcompanyke
        Tab kassaTab = new Tab("Kassa", kassaTab1OverviewPane);
        //TODO: TOEGEVOEGD = ALS PARAMETER EN INSTANCEVARIABLE: artikelcompanyke
        ProductOverviewPane productOverviewPane = new ProductOverviewPane(ArtikelCompany.getInstance());//VROEGER: artikelcompanyke
        Tab artikelTab = new Tab("Artikelen",productOverviewPane);
        InstellingenPane instellingenPane = new InstellingenPane(ArtikelCompany.getInstance());//VROEGER: artikelcompanyke
        Tab instellingTab = new Tab("Instellingen", instellingenPane);
        Tab logTab = new Tab("Log");
        tabPane.getTabs().add(kassaTab);
        tabPane.getTabs().add(artikelTab);
        tabPane.getTabs().add(instellingTab);
        tabPane.getTabs().add(logTab);
	    this.setCenter(tabPane);
	}
}
