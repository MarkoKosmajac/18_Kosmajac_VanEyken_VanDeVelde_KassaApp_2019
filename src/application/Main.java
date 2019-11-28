package application;
	
import database.InMemoryArtikelDatabase;
import javafx.application.Application;
import javafx.stage.Stage;
import view.KassaView;
import view.KlantView;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		KassaView kassaView = new KassaView();
		KlantView klantView = new KlantView();
		//TODO: gebruik MVC om dit te veranderen en toe te voegen,...

	}

	public static void main(String[] args) {
		launch(args);
	}
}
