package logic.view.standalone;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import logic.controller.guicontroller.ControllerGuiHomePageTourist;
import logic.engineeringclasses.others.Session;

public class View extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		
		Session session = new Session(false);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/HomePageTouristView.fxml"));
		loader.setControllerFactory(c -> new ControllerGuiHomePageTourist(session));
		Parent rootParent = loader.load();
		Scene scene = new Scene(rootParent);
		arg0.setTitle(" EaTypical- Eat,Drink and Sleep");
		arg0.getIcons().add(new Image("/logic/view/standalone/utente.jpg"));
		arg0.setScene(scene);
		arg0.show();		
	}

}
