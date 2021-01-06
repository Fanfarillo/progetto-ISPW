/**
 * Sample Skeleton for 'HomePageTouristView.fxml' Controller Class
 */

package logic.controller.guicontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.layout.AnchorPane;

public class ControllerGuiHomePageTourist extends UserBaseGuiController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="tripsButton"
    private Button tripsButton; // Value injected by FXMLLoader

    @FXML // fx:id="favouriteRestaurantsButton"
    private Button favouriteRestaurantsButton; // Value injected by FXMLLoader

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="labelBenvenuto"
    private Label labelBenvenuto; // Value injected by FXMLLoader

    @FXML
    void goToFavouriteRestaurantsPage(ActionEvent event) {
    	//To do
    	System.out.print("To do\n");
    }

    @FXML
    void goToTripsPage(ActionEvent event) {
    	//To do
    	System.out.print("To do\n");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert myAnchorPane != null : "fx:id=\"myAnchorPane\" was not injected: check your FXML file 'HomePageTouristView.fxml'.";
        assert tripsButton != null : "fx:id=\"tripsButton\" was not injected: check your FXML file 'HomePageTouristView.fxml'.";
        assert favouriteRestaurantsButton != null : "fx:id=\"favouriteRestaurantsButton\" was not injected: check your FXML file 'HomePageTouristView.fxml'.";
        assert scheduleTripButton != null : "fx:id=\"scheduleTripButton\" was not injected: check your FXML file 'HomePageTouristView.fxml'.";
        assert chooseRestaurantButton != null : "fx:id=\"chooseRestaurantButton\" was not injected: check your FXML file 'HomePageTouristView.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'HomePageTouristView.fxml'.";
        assert labelBenvenuto != null : "fx:id=\"labelBenvenuto\" was not injected: check your FXML file 'HomePageTouristView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'HomePageTouristView.fxml'.";

    }
}
