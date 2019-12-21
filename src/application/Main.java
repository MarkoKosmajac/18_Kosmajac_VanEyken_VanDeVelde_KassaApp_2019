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


	}

	public static void main(String[] args) {
		launch(args);
	}

}
