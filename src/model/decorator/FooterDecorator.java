package model.decorator;

import controller.InstellingenController;

import java.util.Properties;

public class FooterDecorator extends KassabonDecorator{



    public FooterDecorator(Kassabon kassabon) {
        super(kassabon);
    }

    @Override
    public String toString() {
        String res = super.toString() + "\n";
        return res;
    }
}
