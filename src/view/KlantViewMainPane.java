package view;
import controller.KlantProductOverviewController;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import view.panels.KlantOverviewPane;

public class KlantViewMainPane extends BorderPane {


    public KlantViewMainPane(KlantProductOverviewController controller) {
        TabPane tabPane = new TabPane();
        KlantOverviewPane klantOverviewPane = new KlantOverviewPane(controller);
        Tab logTab = new Tab("ARTIKELENLIJST", klantOverviewPane);
        tabPane.getTabs().add(logTab);
        this.setCenter(tabPane);
    }

}
