/**
 * Sample Skeleton for 'ModifyDishView.fxml' Controller Class
 */

package logic.controller.guicontroller.ManageMenuGuiController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerGuiModifyDishView {

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

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="choiseBox"
    private ChoiceBox<?> choiseBox; // Value injected by FXMLLoader

    @FXML // fx:id="veganCheck"
    private CheckBox veganCheck; // Value injected by FXMLLoader

    @FXML // fx:id="celiacCheck"
    private CheckBox celiacCheck; // Value injected by FXMLLoader

    @FXML // fx:id="priceText"
    private TextField priceText; // Value injected by FXMLLoader

    @FXML // fx:id="modifyButton"
    private Button modifyButton; // Value injected by FXMLLoader

    @FXML
    void back(ActionEvent event) {
    	System.out.println("back\n");
    }

    @FXML
    void goToHome(ActionEvent event) {
    	System.out.println("home\n");
    }

    @FXML
    void manageMenu(ActionEvent event) {
    	System.out.println("manage\n");
    }

    @FXML
    void modify(ActionEvent event) {
    	System.out.println("modify\n");
    }

    @FXML
    void sponsorRestaurant(ActionEvent event) {
    	System.out.println("sponsor\n");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert manageMenuButton != null : "fx:id=\"manageMenuButton\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert sponsorRestaurantButton != null : "fx:id=\"sponsorRestaurantButton\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert choiseBox != null : "fx:id=\"choiseBox\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert veganCheck != null : "fx:id=\"veganCheck\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert celiacCheck != null : "fx:id=\"celiacCheck\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert priceText != null : "fx:id=\"priceText\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert modifyButton != null : "fx:id=\"modifyButton\" was not injected: check your FXML file 'ModifyDishView.fxml'.";

    }
}

