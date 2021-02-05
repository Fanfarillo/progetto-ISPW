package logic.controller.guicontroller;

import java.io.IOException;

import logic.engineeringclasses.others.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import logic.controller.guicontroller.chooserestaurant.ControllerGuiItalianViewCityCR;
import logic.controller.guicontroller.scheduleatrip.*;

//The second layer of Graphic Controllers: every normal user has the ChooseResytaurant Button and the Schedule Trip Page button
public  class UserBaseGuiController extends BaseGuiController {
	
	protected String mustLoginMessage = "You must login to use this function.";
	protected String chooseRestPage = "/logic/view/standalone/chooserestaurant/ItalianViewCity.fxml";
	protected String scheduleTripPage = "/logic/view/standalone/scheduleatrip/ItalianViewCity.fxml";
	
	protected UserBaseGuiController(Session bs) {
		super(bs);
	}
	
    @FXML
    protected Button chooseRestaurantButton;

    @FXML
    protected Button scheduleTripButton;
    
    @FXML
    protected Label mustLoginLabel;

	@FXML
	void goToChooseRestaurantPage(ActionEvent event) throws IOException {	//The Choose Restaurant Page button onAction method
	
    	FXMLLoader loader=new FXMLLoader(getClass().getResource(this.chooseRestPage));
    	loader.setControllerFactory(c -> new ControllerGuiItalianViewCityCR(bs));
    	Parent root=loader.load();
    	myAnchorPane.getChildren().setAll(root);
    }
	
    @FXML
    void goToScheduleTripPage(ActionEvent event) throws IOException {		//The Schedule Trip Page button onAction method	
    	if(bs.getUser()!=null) {
    		FXMLLoader loader=new FXMLLoader(getClass().getResource(this.scheduleTripPage));
    		loader.setControllerFactory(c -> new ControllerGuiItalianViewCity(bs));
    		Parent root=loader.load();
    		myAnchorPane.getChildren().setAll(root);
    	}
    	else {
    		mustLoginLabel.setText(mustLoginMessage);
    		mustLoginLabel.setVisible(true);
    	}
    	
    }

}
