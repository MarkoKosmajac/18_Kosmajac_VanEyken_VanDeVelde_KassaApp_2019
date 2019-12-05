package view;


import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import model.ArtikelCompany;
import view.panels.InstellingenPane;
import view.panels.KassaTab1OverviewPane;
import view.panels.ProductOverviewPane;

public class KassaMainPane extends BorderPane {
	public KassaMainPane(){

        ArtikelCompany artikelcompanyke = new ArtikelCompany();
	    TabPane tabPane = new TabPane();
        KassaTab1OverviewPane kassaTab1OverviewPane = new KassaTab1OverviewPane(artikelcompanyke);
        Tab kassaTab = new Tab("Kassa", kassaTab1OverviewPane);
        //TODO: TOEGEVOEGD = ALS PARAMETER EN INSTANCEVARIABLE: artikelcompanyke
        ProductOverviewPane productOverviewPane = new ProductOverviewPane(artikelcompanyke);
        Tab artikelTab = new Tab("Artikelen",productOverviewPane); //TODO: Binded pane to a tab! Voor deze al gedaan (story 1 & 2)
        InstellingenPane instellingenPane = new InstellingenPane(artikelcompanyke);
        Tab instellingTab = new Tab("Instellingen", instellingenPane);
        Tab logTab = new Tab("Log");
        tabPane.getTabs().add(kassaTab);
        tabPane.getTabs().add(artikelTab);
        tabPane.getTabs().add(instellingTab);
        tabPane.getTabs().add(logTab);
	    this.setCenter(tabPane);
	}
}
