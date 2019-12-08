package database;

/*DEZE KLASSE MAG UIT HET PROJECT LATER: IS PUUR EEN TESTKLASSE DIE SINGLETON UITLEGT EN DOCUMENTEERT*/

public class Singleton {
    private static Singleton carShop;
    private static Singleton firstInstance = null; //TODO: This is the one and only instance for the class Singleton.
    //TODO: Static because it needs to be available on a global basis.

    //TODO: private constructor, to make sure theres only 1 instance for the class Singleton.
    //TODO: So if they try to create a new instance, it's going to give an error.
    private Singleton(){

    }

    public static Singleton getInstance(){
        //TODO: They can only create a singleton Object if one DOES NOT already exist.
        //TODO: That one will be stored in the instancefield firstInstance.
        if(firstInstance == null){
            firstInstance = new Singleton(); //TODO: This line here is known as lazy instantiation = If the instance isn't needed, it's never going to be created.
        }

        return firstInstance;

    }

    //TODO: DONE!
    //TODO: THIS IS THE SINGLETON PATTERN!


}
