package view.panels;

import controller.KassaController;
import controller.LogPaneController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class LogPane extends GridPane {

    //eigen controller, zo fixen dat die de log oproept...
    private LogPaneController logpanecontroller;
    private Label logsLabel = new Label("LOGS: ");
    private Label log = new Label();

    public LogPane(LogPaneController logPaneController){
        this.logpanecontroller = logPaneController;

        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);


        this.add(logsLabel,0,0);

        setLog();
    }

    private void setLog(){
        this.add(new Label(logpanecontroller.log("e","ee","pp")),0,2);
    }
}
