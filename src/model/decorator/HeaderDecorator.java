package model.decorator;

import controller.InstellingenController;
import model.SoortHeaderLijn;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class HeaderDecorator extends KassabonDecorator {


    public HeaderDecorator(Kassabon kassabon) {
        super(kassabon);
    }


    @Override
    public String toString() {

        String headerlijn = "";

        if (instellingenController.getIngevuldeProperty("headerlijn") != null){
            for (SoortHeaderLijn e: SoortHeaderLijn.values()){
                if (instellingenController.getIngevuldeProperty("headerlijn").equalsIgnoreCase(e.toString())){
                    headerlijn +="-----------------------------------------------------------------------------------------------------";
                    headerlijn += "\nDATUM BETALING: ";
                    //GET DATE + TIME
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    headerlijn+= dtf.format(now) + "\n";
                    break;
                } else {
                    headerlijn = instellingenController.getIngevuldeProperty("headerlijn");
                }
            }
        }

        return headerlijn + super.toString() + "\n" /* + new FooterDecorator(new TekstKassabonLezer())*/; //rare sout: model... = super.toString();
    }
}
