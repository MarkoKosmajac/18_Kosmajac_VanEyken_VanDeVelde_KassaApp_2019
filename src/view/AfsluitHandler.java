package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.panels.KassaOverviewPane;

import javax.swing.text.View;
import java.awt.*;

public class AfsluitHandler implements EventHandler<ActionEvent> {
    private final KassaOverviewPane kassaOverviewPane;

    public AfsluitHandler(KassaOverviewPane kassaOverviewPane) {
        this.kassaOverviewPane = kassaOverviewPane;
    }

    public void handle(ActionEvent event, Label korting, Label kortinglabel, Label eindTotaalLabel, Label eindTotaal) {
            eindTotaal.setVisible(true);
            korting.setVisible(true);
            kortinglabel.setVisible(true);
            eindTotaalLabel.setVisible(true);
        }

    @Override
    public void handle(ActionEvent event) {

    }
}
