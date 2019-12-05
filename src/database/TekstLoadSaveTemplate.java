package database;

public abstract class TekstLoadSaveTemplate implements LoadSaveStrategy{
    //TODO: nog aan te vullen, hier komen abstracte methodes save en load om bijvoorbeeld een KLANT object in te lezen en te saven
    //TODO: STANDAARDCODE;

    //LOAD EN SAVE METHODE DIE MOETEN FINAL ZIJN

    final void load(){

        lijnNaarArtikel();


    }




    final void save(){

        objectOmzettenNaarLijn();
        closeWriter();


    }
    abstract void objectOmzettenNaarLijn();
    abstract void closeWriter();
    abstract void lijnNaarArtikel();




}
