/**
 * Sample Skeleton for 'AddDish.fxml' Controller Class
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

public class  ControllerGuiAddDishView{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="backButton"
    private Button backButton; // Value injected by FXMLLoader

    @FXML // fx:id="sponsorRestaurantButton"
    private Button sponsorRestaurantButton; // Value injected by FXMLLoader

    @FXML // fx:id="manageMenuButton"
    private Button manageMenuButton; // Value injected by FXMLLoader

    @FXML // fx:id="homeButton"
    private Button homeButton; // Value injected by FXMLLoader

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="scegliPiattoBox"
    private ChoiceBox<?> scegliPiattoBox; // Value injected by FXMLLoader

    @FXML // fx:id="priceTextField"
    private TextField priceTextField; // Value injected by FXMLLoader

    @FXML // fx:id="veganCheckBox"
    private CheckBox veganCheckBox; // Value injected by FXMLLoader

    @FXML // fx:id="celiacCheckBox"
    private CheckBox celiacCheckBox; // Value injected by FXMLLoader

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML
    void goToBack(ActionEvent event) {
    	System.out.print("Back\n");
    }

    @FXML
    void goToConfirmMessageView(ActionEvent event) {
    	System.out.print("confirm\n");
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
    	System.out.print("Sponsor\n");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'AddDish.fxml'.";
        assert sponsorRestaurantButton != null : "fx:id=\"sponsorRestaurantButton\" was not injected: check your FXML file 'AddDish.fxml'.";
        assert manageMenuButton != null : "fx:id=\"manageMenuButton\" was not injected: check your FXML file 'AddDish.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'AddDish.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'AddDish.fxml'.";
        assert scegliPiattoBox != null : "fx:id=\"scegliPiattoBox\" was not injected: check your FXML file 'AddDish.fxml'.";
        assert priceTextField != null : "fx:id=\"priceTextField\" was not injected: check your FXML file 'AddDish.fxml'.";
        assert veganCheckBox != null : "fx:id=\"veganCheckBox\" was not injected: check your FXML file 'AddDish.fxml'.";
        assert celiacCheckBox != null : "fx:id=\"celiacCheckBox\" was not injected: check your FXML file 'AddDish.fxml'.";
        assert okButton != null : "fx:id=\"okButton\" was not injected: check your FXML file 'AddDish.fxml'.";

    }
}
