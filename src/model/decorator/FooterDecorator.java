package model.decorator;

import controller.InstellingenController;

import java.util.Properties;

public class FooterDecorator extends KassabonDecorator{
    private Properties properties;
    private InstellingenController instellingenController;

    public FooterDecorator(Kassabon kassabon) {
        super(kassabon);
        this.properties = new Properties();
        instellingenController = new InstellingenController();
        instellingenController.geefPathFile();
    }

    @Override
    public String toString() {
        String res = super.printBon() + "\n";
        return res + instellingenController.getIngevuldeProperty("footerlijn");
    }
}
