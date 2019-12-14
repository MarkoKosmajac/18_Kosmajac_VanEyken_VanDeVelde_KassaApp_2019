package view;

import controller.KassaController;
import controller.LogPaneController;
import controller.ProductOverviewPaneController;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import view.panels.InstellingenPane;
import view.panels.KassaOverviewPane;
import view.panels.LogPane;
import view.panels.ProductOverviewPane;

public class KassaMainPane extends BorderPane {

    private ProductOverviewPaneController controllerOverview;
    private LogPaneController logPaneController;

	public KassaMainPane(KassaController controller){
	    controllerOverview = new ProductOverviewPaneController();
	    logPaneController = new LogPaneController();

	    TabPane tabPane = new TabPane();
        KassaOverviewPane kassaOverviewPane = new KassaOverviewPane(controller);
        Tab kassaTab = new Tab("Kassa", kassaOverviewPane);
        ProductOverviewPane productOverviewPane = new ProductOverviewPane(controllerOverview);
        Tab artikelTab = new Tab("Artikelen",productOverviewPane);
        InstellingenPane instellingenPane = new InstellingenPane();
        Tab instellingTab = new Tab("Instellingen", instellingenPane);
        LogPane logpane = new LogPane(logPaneController);
        Tab logTab = new Tab("Log", logpane);
        tabPane.getTabs().add(kassaTab);
        tabPane.getTabs().add(artikelTab);
        tabPane.getTabs().add(instellingTab);
        tabPane.getTabs().add(logTab);
	    this.setCenter(tabPane);
	}
}
