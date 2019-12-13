package application;

import controller.KassaProductOverviewController;
import controller.KlantProductOverviewController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.ArtikelModel;
import model.kortingstrategie.DrempelKorting;
import model.kortingstrategie.Groepkorting;
import model.kortingstrategie.KortingStrategie;
import model.kortingstrategie.KortingStrategieFactory;
import view.KassaView;
import view.KlantView;
import java.io.IOException;

/**
 * @author Max Van De Velde, Marko Kosmajac, Brent Van Eyken
 */

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		ArtikelModel artikelModel = new ArtikelModel();

		KassaProductOverviewController kassaController = new KassaProductOverviewController(artikelModel);
		KlantProductOverviewController klantController = new KlantProductOverviewController(artikelModel);

		KassaView kassaView = new KassaView(kassaController);
		KlantView klantView = new KlantView(klantController);


		//TODO: gebruik MVC om dit te veranderen en toe te voegen. MVC: Meerdere views, controllers, models toevoegen!!!

		//System.out.println(System.getProperty("os.name"));

		/*//TESTEN VAN DE KORTINGSTRATEGIE
		KortingStrategieFactory factory = new KortingStrategieFactory();
		KortingStrategie strategie = factory.makeKortingStrategie("GROEPKORTING");
		strategie.setProcent(99);
		System.out.println(strategie.geefKorting());
		KortingStrategie strategie1 = factory.makeKortingStrategie("DREMPELKORTING");
		strategie.setBedrag() werkt niet...*/


	}

	public static void main(String[] args) {
		launch(args);
	}

}
