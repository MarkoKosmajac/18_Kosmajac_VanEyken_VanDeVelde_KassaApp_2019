package view;

import controller.KlantController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class KlantView {
	private Stage stage = new Stage();		
		
	public KlantView(KlantController klantController){
		stage.setTitle("KLANT VIEW");
		stage.setResizable(false);		
		stage.setX(850);
		stage.setY(20);
		Group root = new Group();
		Scene scene = new Scene(root, 600, 500);
		BorderPane borderPane = new KlantViewMainPane(klantController);
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		root.getChildren().add(borderPane);
		scene.getStylesheets().add("application/application.css");
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();		
	}
}
