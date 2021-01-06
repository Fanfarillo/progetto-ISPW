package logic.controller.guicontroller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import logic.engineeringclasses.others.SizedStack;

//The second layer of Graphic Controllers: every normal user has the ChooseResytaurant Button and the Schedule Trip Page button
public class UserBaseGuiController extends BaseGuiController {
	
	protected String chooseRestPage = "/logic/view/standalone/ChooseRestaurant/ItalianViewCity.fxml";
	protected String scheduleTripPage = "/logic/view/standalone/ScheduleTrip/ItalianViewCity.fxml";
	
    @FXML
    protected Button chooseRestaurantButton;

    @FXML
    protected Button scheduleTripButton;

	@FXML
	void goToChooseRestaurantPage(ActionEvent event) throws IOException {	//The Choose Restaurant Page button onAction method
	
		System.out.print("Choose Restaurant\n");
		SizedStack.getSizedStack().push(this.chooseRestPage);
    	FXMLLoader loader=new FXMLLoader(getClass().getResource(this.chooseRestPage));
    	Parent root=loader.load();
    	myAnchorPane.getChildren().setAll(root);
    }
	
    @FXML
    void goToScheduleTripPage(ActionEvent event) throws IOException {		//The Schedule Trip Page button onAction method	
    	
    	System.out.print("Schedule Trip\n");
    	SizedStack.getSizedStack().push(this.scheduleTripPage);
    	FXMLLoader loader=new FXMLLoader(getClass().getResource(this.scheduleTripPage));
    	Parent root=loader.load();
    	myAnchorPane.getChildren().setAll(root);
    }

}
