package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class AfsluitHandler implements EventHandler<ActionEvent> {
    private final Label korting;
    private final Label eindTotaal;
    private final Label kortinglabel;
    private final Label eindTotaalLabel;

    public AfsluitHandler(Label korting, Label eindTotaal, Label kortinglabel, Label eindTotaalLabel) {
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
