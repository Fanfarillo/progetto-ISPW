/**
 * Sample Skeleton for 'RestaurantMenuView.fxml' Controller Class
 */

package logic.controller.guicontroller.ManageMenuGuiController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ControllerGuiRestaurantMenuView {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="manageMenuButton"
    private Button manageMenuButton; // Value injected by FXMLLoader

    @FXML // fx:id="sponsorRestaurantButton"
    private Button sponsorRestaurantButton; // Value injected by FXMLLoader

    @FXML // fx:id="homeButton"
    private Button homeButton; // Value injected by FXMLLoader

    @FXML // fx:id="backButton"
    private Button backButton; // Value injected by FXMLLoader

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="deleteDishButton"
    private Button deleteDishButton; // Value injected by FXMLLoader

    @FXML // fx:id="addADishButton"
    private Button addADishButton; // Value injected by FXMLLoader

    @FXML // fx:id="modifyADishButton"
    private Button modifyADishButton; // Value injected by FXMLLoader

    @FXML // fx:id="getAdviceButton"
    private Button getAdviceButton; // Value injected by FXMLLoader

    @FXML
    void addADish(ActionEvent event) {
    	System.out.print("Add dish\n");
    }

    @FXML
    void deleteADish(ActionEvent event) {
    	System.out.print("delete dish\n");
    }

    @FXML
    void getAdvice(ActionEvent event) {
    	System.out.print("getAdvice\n");
    }

    @FXML
    void goToBack(ActionEvent event) {
    	System.out.print("back\n");
    }

    @FXML
    void goToHome(ActionEvent event) {
    	System.out.print("Home\n");
    }

    @FXML
    void goToManageMenu(ActionEvent event) {
    	System.out.print("Manage menu\n");
    }

    @FXML
    void goToSponsorRestaurant(ActionEvent event) {
    	System.out.print("sponsor restau\n");
    }

    @FXML
    void modifyADish(ActionEvent event) {
    	System.out.print("modify dish\n");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert manageMenuButton != null : "fx:id=\"manageMenuButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert sponsorRestaurantButton != null : "fx:id=\"sponsorRestaurantButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert deleteDishButton != null : "fx:id=\"deleteDishButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert addADishButton != null : "fx:id=\"addADishButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert modifyADishButton != null : "fx:id=\"modifyADishButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert getAdviceButton != null : "fx:id=\"getAdviceButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";

    }
}
