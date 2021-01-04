package logic.controller.guicontroller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import logic.engineeringclasses.others.SizedStack;

//The second layer of Graphic Controllers: every normal user has hte ChooseResytaurant Button and the Schedule Trip Page button
public class UserBaseGuiController extends BaseGuiController {
	
    @FXML
    protected Button chooseRestaurantButton;

    @FXML
    protected Button scheduleTripButton;

	@FXML
	void goToChooseRestaurantPage(ActionEvent event) throws IOException 	//The Choose Restaurant Page button onAction method
	{
		System.out.print("Choose Restaurant\n");
		SizedStack.getSizedStack().push("/logic/view/standalone/ChooseRestaurant/RestaurantSettingsView.fxml");
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/logic/view/standalone/ChooseRestaurant/RestaurantSettingsView.fxml"));
    	Parent root=loader.load();
    	myAnchorPane.getChildren().setAll(root);
    }
	
    @FXML
    void goToScheduleTripPage(ActionEvent event) throws IOException {		//The Schedule Trip Page button onAction method	
    	System.out.print("da fare\n");
    	SizedStack.getSizedStack().push("/logic/view/standalone/ScheduleTrip/TripSettingsView.fxml");
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/logic/view/standalone/ScheduleTrip/TripSettingsView.fxml"));
    	Parent root=loader.load();
    	myAnchorPane.getChildren().setAll(root);
    }

}
