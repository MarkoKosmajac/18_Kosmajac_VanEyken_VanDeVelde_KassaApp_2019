package application;

import controller.KassaProductOverviewController;
import controller.KlantProductOverviewController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.ArtikelModel;
import view.KassaView;
import view.KlantView;

import java.io.IOException;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		ArtikelModel artikelModel = new ArtikelModel();

		KassaProductOverviewController kassaController = new KassaProductOverviewController(artikelModel);
		KlantProductOverviewController klantController = new KlantProductOverviewController(artikelModel);

		KassaView kassaView = new KassaView(kassaController);
		KlantView klantView = new KlantView(klantController);


		//TODO: gebruik MVC om dit te veranderen en toe te voegen,...
		//TODO: MVC: Meerdere views, controllers, models toevoegen!!!

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
