package view;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.ArtikelCompany;
import view.panels.KassaTab1OverviewPane;
import view.panels.KlantOverviewPane;
import view.panels.ProductOverviewPane;

import java.io.IOException;

public class KlantViewMainPane extends BorderPane {


    public KlantViewMainPane() throws IOException {
        ArtikelCompany artikelcompanyke = new ArtikelCompany();
        TabPane tabPane = new TabPane();
        KlantOverviewPane klantOverviewPane = new KlantOverviewPane(artikelcompanyke);
        Tab logTab = new Tab("ARTIKELENLIJST", klantOverviewPane);
        tabPane.getTabs().add(logTab);
        this.setCenter(tabPane);
    }

}
