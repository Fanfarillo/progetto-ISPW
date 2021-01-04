/**
 * Sample Skeleton for 'RestaurantMenuView.fxml' Controller Class
 */

package logic.controller.guicontroller.ManageMenuGuiController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import logic.controller.guicontroller.OwnerBaseGuiController;

public class ControllerGuiRestaurantMenuView  extends OwnerBaseGuiController{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;


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
    void addADish(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/AddDish.fxml"));
    	Parent rootParent = loader.load();
    	myAnchorPane.getChildren().setAll(rootParent);
    }

    @FXML
    void deleteADish(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/DeleteDishView.fxml"));
    	Parent rootParent = loader.load();
    	myAnchorPane.getChildren().setAll(rootParent);
    }

    @FXML
    void getAdvice(ActionEvent event) throws IOException {
    	System.out.print("Eccome");
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/AdviceView.fxml"));
    	Parent rootParent = loader.load();
    	System.out.print("Eccome");
    	myAnchorPane.getChildren().setAll(rootParent);
    }

    

   

    @FXML
    void modifyADish(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/ModifyDishView.fxml"));
    	Parent rootParent = loader.load();
    	myAnchorPane.getChildren().setAll(rootParent);
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
