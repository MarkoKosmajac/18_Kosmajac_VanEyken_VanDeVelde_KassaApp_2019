package model;

import java.time.LocalDateTime;

/**
 * @author Marko Kosmajac
 */

/* VOOR LOGS - TAB 4: NOT FINISHED*/
public class Verkoop {
    private double totaalbedrag, korting, teBetalenBedrag;
    private LocalDateTime dateEnTime;

    public Verkoop(double totaalbedrag, double korting, double teBetalenBedrag) {
        this.totaalbedrag = totaalbedrag;
        this.korting = korting;
        this.teBetalenBedrag = teBetalenBedrag;
        this.dateEnTime = LocalDateTime.now();
    }

    public double getTotaalbedrag() {
        return totaalbedrag;
    }

    public double getKorting() {
        return korting;
    }

    public double getTeBetalenBedrag() {
        return teBetalenBedrag;
    }

    public LocalDateTime getDateEnTime() {
        return dateEnTime;
    }
}
