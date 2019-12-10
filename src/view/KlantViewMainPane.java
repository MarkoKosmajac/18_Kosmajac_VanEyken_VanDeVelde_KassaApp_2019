package view;
import controller.KlantProductOverviewController;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import database.ArtikelDBContext;
import model.Artikel;
import view.panels.KlantOverviewPane;

import java.io.IOException;
import java.util.ArrayList;

public class KlantViewMainPane extends BorderPane {


    public KlantViewMainPane(KlantProductOverviewController controller) {
        //ArtikelCompany artikelcompanyke = new ArtikelCompany(); //TODO: FIXED WITH SINGLETON:
        TabPane tabPane = new TabPane();
        KlantOverviewPane klantOverviewPane = new KlantOverviewPane(controller); //FIXED WITH SINGLETON
        Tab logTab = new Tab("ARTIKELENLIJST", klantOverviewPane);
        tabPane.getTabs().add(logTab);
        this.setCenter(tabPane);
    }

}
