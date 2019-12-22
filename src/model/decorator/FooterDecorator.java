package model.decorator;

import controller.InstellingenController;
import model.SoortHeaderLijn;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class FooterDecorator extends KassabonDecorator{



    public FooterDecorator(Kassabon kassabon) {
        super(kassabon);
    }

    @Override
    public String toString() {
        return super.toString() +  "\n";

    }
}
