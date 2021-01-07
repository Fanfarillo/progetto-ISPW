/**
 * Sample Skeleton for 'DeleteDishView.fxml' Controller Class
 */

package logic.controller.guicontroller.ManageMenuGuiController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class ControllerGuiDeleteDish  extends OwnerBaseGuiController{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private ChoiceBox<String> scegliRistorante;

    @FXML // fx:id="nomeUtente"
    private Label nomeUtente; // Value injected by FXMLLoader

    @FXML // fx:id="choiseDish"
    private ChoiceBox<String> choiseDish; // Value injected by FXMLLoader

    @FXML // fx:id="deleteButton"
    private Button deleteButton; // Value injected by FXMLLoader

    @FXML
    void delete(ActionEvent event) {
    	System.out.println("delete\n");
    }

    public ChoiceBox<String> getChoiceBoxDish() {
		return this.choiseDish;
	}
    
    public Label getLabel() {
    	return this.nomeUtente;
    }
    
    public ChoiceBox<String> getChoiceBoxRestaurant() {
    	return this.scegliRistorante;
    }

    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'DeleteDishView.fxml'.";
        assert manageMenuButton != null : "fx:id=\"manageMenuButton\" was not injected: check your FXML file 'DeleteDishView.fxml'.";
        assert sponsorRestaurantButton != null : "fx:id=\"sponsorRestaurantButton\" was not injected: check your FXML file 'DeleteDishView.fxml'.";
        assert backButton != null : "fx:id=\"back\" was not injected: check your FXML file 'DeleteDishView.fxml'.";
        assert nomeUtente != null : "fx:id=\"nomeUtente\" was not injected: check your FXML file 'DeleteDishView.fxml'.";
        assert choiseDish != null : "fx:id=\"choiseDish\" was not injected: check your FXML file 'DeleteDishView.fxml'.";
        assert deleteButton != null : "fx:id=\"deleteButton\" was not injected: check your FXML file 'DeleteDishView.fxml'.";

    }
}
