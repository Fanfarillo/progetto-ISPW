/**
 * Sample Skeleton for 'CreatingRestaurantView.fxml' Controller Class
 */

package logic.controller.guicontroller.SponsorRestaurant;

import logic.controller.guicontroller.OwnerBaseGuiController;
import java.net.URL;
import java.util.ResourceBundle;
//import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
//import javafx.scene.layout.AnchorPane;

public class ControllerGuiCreatingRestaurant extends OwnerBaseGuiController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="doneButton"
    private Button doneButton; // Value injected by FXMLLoader

    @FXML // fx:id="addDishButton"
    private Button addDishButton; // Value injected by FXMLLoader

    @FXML // fx:id="restNameTextBox"
    private TextField restNameTextBox; // Value injected by FXMLLoader

    @FXML // fx:id="addrNameTextBox"
    private TextField addrNameTextBox; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'CreatingRestaurantView.fxml'.";
        assert doneButton != null : "fx:id=\"doneButton\" was not injected: check your FXML file 'CreatingRestaurantView.fxml'.";
        assert addDishButton != null : "fx:id=\"addDishButton\" was not injected: check your FXML file 'CreatingRestaurantView.fxml'.";
        assert restNameTextBox != null : "fx:id=\"restNameTextBox\" was not injected: check your FXML file 'CreatingRestaurantView.fxml'.";
        assert addrNameTextBox != null : "fx:id=\"addrNameTextBox\" was not injected: check your FXML file 'CreatingRestaurantView.fxml'.";

    }
}
