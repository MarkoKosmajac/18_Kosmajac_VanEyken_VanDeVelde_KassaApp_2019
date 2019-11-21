package database;

import model.Artikel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArtikelTekstLoadSave extends TekstLoadSaveTemplate{

    private String filename;
    private List<Artikel> artikelen;

    //12 lijnen code om iets in te lezen is altijd zelfde: Template pattern
    //12 lijnen code om iets te schrijven is altijd zelfde behalve 2 lijntjes: Template pattern

    //in loadenSave methode, some read code, some abstract code, dan override je die 2 abstract methodes

    //TODO: Je ArtikelTekstLoadSave klasse erft hiervan over en implementeert alleen nog de abstracte methodes uit de template klasse.
    //TODO: Later kunnen andere klassen (voorbeeld een tekstbestand met klantgegevens van deze template klasse gebruik maken)

}
