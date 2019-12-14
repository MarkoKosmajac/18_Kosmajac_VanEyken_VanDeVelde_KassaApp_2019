package application;

import controller.KassaController;
import controller.KlantController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.ArtikelModel;
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

		KassaController kassaController = new KassaController(artikelModel);
		KlantController klantController = new KlantController(artikelModel);

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
