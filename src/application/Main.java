package application;
	
import database.ArtikelDBInMemory;
import javafx.application.Application;
import javafx.beans.property.Property;
import javafx.stage.Stage;
import view.KassaView;
import view.KlantView;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		KassaView kassaView = new KassaView();
		KlantView klantView = new KlantView();
		//TODO: gebruik MVC om dit te veranderen en toe te voegen,...

		System.out.println(System.getProperty("os.name"));

	}

	public static void main(String[] args) {
		launch(args);
	}
}
