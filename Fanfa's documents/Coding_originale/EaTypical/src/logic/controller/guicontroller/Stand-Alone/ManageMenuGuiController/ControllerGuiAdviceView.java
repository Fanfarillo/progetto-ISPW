/**
 * Sample Skeleton for 'AdviceView.fxml' Controller Class
 */

package logic.controller.guicontroller.ManageMenuGuiController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerGuiAdviceView {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="homeButton"
    private Button homeButton; // Value injected by FXMLLoader

    @FXML // fx:id="manageMenuButton"
    private Button manageMenuButton; // Value injected by FXMLLoader

    @FXML // fx:id="sponsorRestaurantButton"
    private Button sponsorRestaurantButton; // Value injected by FXMLLoader

    @FXML // fx:id="backButton"
    private Button backButton; // Value injected by FXMLLoader

    @FXML // fx:id="doneButton"
    private Button doneButton; // Value injected by FXMLLoader

    @FXML
    void done(ActionEvent event) {
    	System.out.print("done\n");
    }

    @FXML
    void goBack(ActionEvent event) {
    	System.out.print("back\n");
    }

    @FXML
    void goToHome(ActionEvent event) {
    	System.out.print("home\n");
    }

    @FXML
    void manageMenu(ActionEvent event) {
    	System.out.print("manage\n");
    }

    @FXML
    void sponsorRestaurant(ActionEvent event) {
    	System.out.print("sponsor\n");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'AdviceView.fxml'.";
        assert manageMenuButton != null : "fx:id=\"manageMenuButton\" was not injected: check your FXML file 'AdviceView.fxml'.";
        assert sponsorRestaurantButton != null : "fx:id=\"sponsorRestaurantButton\" was not injected: check your FXML file 'AdviceView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'AdviceView.fxml'.";
        assert doneButton != null : "fx:id=\"doneButton\" was not injected: check your FXML file 'AdviceView.fxml'.";

    }
}
