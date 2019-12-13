package view;

import controller.KassaProductOverviewController;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import view.panels.InstellingenPane;
import view.panels.KassaTab1OverviewPane;
import view.panels.ProductOverviewPane;

public class KassaMainPane extends BorderPane {
	public KassaMainPane(KassaProductOverviewController controller){

	    TabPane tabPane = new TabPane();
        KassaTab1OverviewPane kassaTab1OverviewPane = new KassaTab1OverviewPane(controller);
        Tab kassaTab = new Tab("Kassa", kassaTab1OverviewPane);
        ProductOverviewPane productOverviewPane = new ProductOverviewPane(controller);
        Tab artikelTab = new Tab("Artikelen",productOverviewPane);
        InstellingenPane instellingenPane = new InstellingenPane(); //TODO: Hierin een andere controller meegeven (instantievar.)
        Tab instellingTab = new Tab("Instellingen", instellingenPane);
        Tab logTab = new Tab("Log");
        tabPane.getTabs().add(kassaTab);
        tabPane.getTabs().add(artikelTab);
        tabPane.getTabs().add(instellingTab);
        tabPane.getTabs().add(logTab);
	    this.setCenter(tabPane);
	}
}
