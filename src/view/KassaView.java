package view;

import controller.KassaController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Max Van De Velde, Marko Kosmajac, Brent Van Eyken
 */

public class KassaView {
	private Stage stage = new Stage();

	public KassaView(KassaController controller){
		stage.setTitle("KASSA VIEW");
		stage.setResizable(false);		
		stage.setX(20);
		stage.setY(20);
		Group root = new Group();
		Scene scene = new Scene(root, 800, 650);
		BorderPane borderPane = new KassaMainPane(controller);
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		root.getChildren().add(borderPane);
		scene.getStylesheets().add("application/application.css");
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();		
	}
}
