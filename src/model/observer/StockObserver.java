package model.observer;

import model.Artikel;

import java.util.ArrayList;

public class StockObserver implements Observer {

    //private Artikel artikel;
    private ArrayList<Artikel> winkelmandje;

    //A counter, special nr to each one of the observers
    private static int observerIDTracker = 0;

    private int observerID;

    private Subject StockGrabber;

    public StockObserver(Subject stockGrabber){
        this.StockGrabber = stockGrabber;
        this.observerID = observerIDTracker++;
        System.out.println("New observer: " + observerID);

        //TODO: DEZE KLASSE IS EEN OBSERVER, je voegt m toe ad lijst dmv register!
        stockGrabber.register(this);
    }

    @Override
    public void update(ArrayList<Artikel> winkelmandje) {
        this.winkelmandje = winkelmandje;

        System.out.println(printWinkelmandje());
    }

    public String printWinkelmandje(){
        String res = "Observer ID: " + observerID + "\n";
        for(Artikel artikel : this.winkelmandje){
            res += artikel.toString();
        }
        return res;
    }

}
