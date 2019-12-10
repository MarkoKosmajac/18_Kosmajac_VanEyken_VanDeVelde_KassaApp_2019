package view;

import controller.KlantProductOverviewController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class KlantView {
	private Stage stage = new Stage();		
		
	public KlantView(KlantProductOverviewController klantProductOverviewController) throws IOException {
		stage.setTitle("KLANT VIEW");
		stage.setResizable(false);		
		stage.setX(775);
		stage.setY(20);
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);
		BorderPane borderPane = new KlantViewMainPane(klantProductOverviewController);
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		root.getChildren().add(borderPane);
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();		
	}
}
