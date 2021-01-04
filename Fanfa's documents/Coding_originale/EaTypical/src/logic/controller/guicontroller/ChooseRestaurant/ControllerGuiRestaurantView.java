/**
 * Sample Skeleton for 'RestaurantView.fxml' Controller Class
 */

package logic.controller.guicontroller.ChooseRestaurant;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import logic.controller.guicontroller.UserBaseGuiController;
import logic.engineeringclasses.others.SizedStack;
public class ControllerGuiRestaurantView extends UserBaseGuiController{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="tabella1"
    private TableView<?> tabella1; // Value injected by FXMLLoader

    @FXML // fx:id="tabella2"
    private TableView<?> tabella2; // Value injected by FXMLLoader

    @FXML // fx:id="nomeRistLabel"
    private Label nomeRistLabel; // Value injected by FXMLLoader

    @FXML // fx:id="addressLabel"
    private Label addressLabel; // Value injected by FXMLLoader

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="saveFavButton"
    private Button saveFavButton; // Value injected by FXMLLoader

    @FXML // fx:id="readReviewsButton"
    private Button readReviewsButton; // Value injected by FXMLLoader

    @FXML // fx:id="writeReviewButton"
    private Button writeReviewButton; // Value injected by FXMLLoader

    @FXML
    void goToReadreviewsPage(ActionEvent event) throws IOException {		//TO DO
    	System.out.print("reviewPage\n");
    	SizedStack.getSizedStack().push("/logic/view/standalone/ChooseRestaurant/ReadReviewsView.fxml");
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/logic/view/standalone/ChooseRestaurant/ReadReviewsView.fxml"));
    	Parent root=loader.load();
    	myAnchorPane.getChildren().setAll(root);
    }
    
    @FXML
    void goToWriteReviewPage(ActionEvent event) throws IOException {		//TO Do
    	System.out.print("WritereviewPage\n");
    	SizedStack.getSizedStack().push("/logic/view/standalone/ChooseRestaurant/WriteReviewView.fxml");
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/logic/view/standalone/ChooseRestaurant/WriteReviewView.fxml"));
    	Parent root=loader.load();
    	myAnchorPane.getChildren().setAll(root);
    }
    
    @FXML
    void saveFavourites(ActionEvent event) {			//TO DO
    	System.out.print("saveFav");
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert chooseRestaurantButton != null : "fx:id=\"chooseRestButton\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert scheduleTripButton != null : "fx:id=\"scheduleButton\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert tabella1 != null : "fx:id=\"tabella1\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert tabella2 != null : "fx:id=\"tabella2\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert nomeRistLabel != null : "fx:id=\"nomeRistLabel\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert addressLabel != null : "fx:id=\"addressLabel\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert saveFavButton != null : "fx:id=\"saveFavButton\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert readReviewsButton != null : "fx:id=\"readReviewsButton\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert writeReviewButton != null : "fx:id=\"writeReviewButton\" was not injected: check your FXML file 'RestaurantView.fxml'.";

    }
}
