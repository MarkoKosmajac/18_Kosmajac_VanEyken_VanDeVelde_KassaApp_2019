package view;

import controller.KlantController;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import view.panels.KlantOverviewPane;

/**
 * @author Max Van De Velde, Marko Kosmajac, Brent Van Eyken
 */

public class KlantViewMainPane extends BorderPane {


    public KlantViewMainPane(KlantController controller) {
        TabPane tabPane = new TabPane();
        KlantOverviewPane klantOverviewPane = new KlantOverviewPane(controller);
        Tab logTab = new Tab("ARTIKELENLIJST", klantOverviewPane);
        tabPane.getTabs().add(logTab);
        this.setCenter(tabPane);
    }

}
