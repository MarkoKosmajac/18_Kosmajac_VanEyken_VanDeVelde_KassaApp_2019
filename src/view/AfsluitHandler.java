package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import view.panels.KassaOverviewPane;

import javax.swing.text.View;
import java.awt.*;

public class AfsluitHandler implements EventHandler<ActionEvent> {
    private final javafx.scene.control.Label korting;
    private final javafx.scene.control.Label eindTotaal;
    private final javafx.scene.control.Label kortinglabel;
    private final Label eindTotaalLabel;

    public AfsluitHandler(javafx.scene.control.Label korting, javafx.scene.control.Label eindTotaal, javafx.scene.control.Label kortinglabel, javafx.scene.control.Label eindTotaalLabel) {
        this.korting = korting;
        this.eindTotaal = eindTotaal;
        this.kortinglabel = kortinglabel;
        this.eindTotaalLabel = eindTotaalLabel;
    }

    @Override
    public void handle(ActionEvent event) {
            eindTotaal.setVisible(true);
            korting.setVisible(true);
            kortinglabel.setVisible(true);
            eindTotaalLabel.setVisible(true);
        }
}
