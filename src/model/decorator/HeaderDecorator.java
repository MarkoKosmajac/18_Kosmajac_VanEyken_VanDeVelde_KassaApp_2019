package model.decorator;

import controller.InstellingenController;

import java.util.Properties;

public class HeaderDecorator extends KassabonDecorator {

    private Properties properties;
    private InstellingenController instellingenController;

    public HeaderDecorator(Kassabon kassabon){
        super(kassabon);
        this.properties = new Properties();
        instellingenController = new InstellingenController();
        instellingenController.geefPathFile();
    }


    @Override
    public String toString() {

        String res2 = super.toString();

        return instellingenController.getIngevuldeProperty("headerlijn") + "\n" + res2;
    }
}
