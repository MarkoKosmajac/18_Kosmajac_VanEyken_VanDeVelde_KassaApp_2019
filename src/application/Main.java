package application;

import controller.KassaProductOverviewController;
import controller.KlantProductOverviewController;
import javafx.application.Application;
import javafx.stage.Stage;
import view.KassaView;
import view.KlantView;

import java.io.IOException;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		KassaProductOverviewController KassaController = new KassaProductOverviewController()
		KlantProductOverviewController KlantController = new KlantProductOverviewController();

		KassaView kassaView = new KassaView(KassaController);
		KlantView klantView = new KlantView(KlantController);


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



		/*//TESTEN VAN DE FACTORY PATTERN
		// VERSIE DEEL 1
		LoadSaveStrategyFactory loadSaveStrategyFactory = new LoadSaveStrategyFactory();
		LoadSaveStrategy theEnemy = null;
		String typeOfShip = "ArtikelLoadSaveExcel";
		theEnemy = loadSaveStrategyFactory.makeLoadSaveStrategy(typeOfShip);
		if(theEnemy != null){
			System.out.println(theEnemy.toString() + "NIET LEEG");
		}
		else System.out.println("LEEG");*/

		/*//TESTEN VAN DE FACTORY PATTERN
		// VERSIE DEEL 2
		bereken();*/

		/*
		//TESTEN SINGLETON PATTERN
		Singleton newInstance = Singleton.getInstance();
		System.out.println("Instance ID: " + System.identityHashCode(newInstance)); //TODO: With this line we can track if we're dealing with the same object.
		System.out.println();
		Singleton instanceTwo = Singleton.getInstance();
		System.out.println("Instance ID: " + System.identityHashCode(instanceTwo));
		//TODO:OUTPUT: Instance ID: 1547864254 & Instance ID: 1547864254 ==> HETZELFDE! WHY ? Even though 2 seperate objects were tried to be created, you can that it's the same object.
		*/

		/*//TODO: TEST REFLECTION
		Class reflectClass = ArtikelCompany.class;
		Method[] classMethods = reflectClass.getMethods();
		for(Method method : classMethods){
			System.out.println((method.getName()));
		}*/


		/*//TODO: TEST MVC CALCULATOR!
		CalculatorView theView = new CalculatorView();
		CalculatorModel theModel = new CalculatorModel();
		CalculatorController theController = new CalculatorController(theView, theModel);
		theView.setVisible(true);*/


		/*KassaTab1OverviewPane theView = new KassaTab1OverviewPane();
		ArtikelDBContext theModel = ArtikelDBContext.getInstance();
		VoegToeController theController = new VoegToeController(theView,theModel);*/







	}

	public static void main(String[] args) {
		launch(args);
	}

	/*//FACTORY VERSIE DEEL 2
	public static LoadSaveStrategy bereken(LoadSaveStrategy loadSaveStrategy){
		LoadSaveStrategyFactory loadSaveStrategyFactory = new LoadSaveStrategyFactory(); //dit moet als instantievar vanboven normaal

		LoadSaveStrategy strat = null;

		strat = loadSaveStrategyFactory.makeLoadSaveStrategy(loadSaveStrategy);
		if(strat != null){
			return strat;
		}
		else return null;
	}*/
}
