package view;


import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import model.ArtikelCompany;
import view.panels.ProductOverviewPane;

public class KassaMainPane extends BorderPane {
	public KassaMainPane(){
		
	    TabPane tabPane = new TabPane(); 	    
        Tab kassaTab = new Tab("Kassa"/*, naamPane en dan dat als klasse maken in panels*/);
        ArtikelCompany artikelcompanyke = new ArtikelCompany();
        //TODO: TOEGEVOEGD = ALS PARAMETER EN INSTANCEVARIABLE: artikelcompanyke
        ProductOverviewPane productOverviewPane = new ProductOverviewPane(artikelcompanyke);
        Tab artikelTab = new Tab("Artikelen",productOverviewPane); //TODO: Binded pane to a tab! Voor deze al gedaan (story 1 & 2)
        Tab instellingTab = new Tab("Instellingen");
        Tab logTab = new Tab("Log");
        tabPane.getTabs().add(kassaTab);
        tabPane.getTabs().add(artikelTab);
        tabPane.getTabs().add(instellingTab);
        tabPane.getTabs().add(logTab);
	    this.setCenter(tabPane);
	}
}
