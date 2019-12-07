package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.*;
import view.KassaView;
import view.KlantView;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLOutput;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		KassaView kassaView = new KassaView();
		KlantView klantView = new KlantView();
		//TODO: gebruik MVC om dit te veranderen en toe te voegen,...

		System.out.println(System.getProperty("os.name"));

		/*//TESTEN VAN DE KORTINGSTRATEGIE
		KortingStrategie groepskorting = new Groepkorting();
		KortingKeuze keuze = new KortingKeuze(groepskorting);
		System.out.println("KEUZE:");
		System.out.println(keuze.geefKorting());

		KortingKeuze keuze1 = new KortingKeuze(new DrempelKorting());
		System.out.println("KEUZE 1:");
		System.out.println(keuze1.geefKorting());
		System.out.println("KEUZE CHANGED TO:");
		keuze.setKortingStrategie(new DuursteKorting());
		System.out.println(keuze.geefKorting());*/


	}

	public static void main(String[] args) {
		launch(args);
	}
}
