package view.panels;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;


public class ProductOverviewPane extends GridPane { //TODO: Simplify code by letting panes extend a Pane (Here gridpane)!
	//private TableView<Product> table; //TODO: alle veldjes, rijen, uit de tekstfile....


	public ProductOverviewPane() {
		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        
		this.add(new Label("Products:"), 0, 0, 1, 1); //TODO: laatste 2 = spans (= optioneel, want default is altijd 1:1), iets anders: hoeveel cellen bedekt je label
		
		
	}
	
	

}
