/**
 * Sample Skeleton for 'NotificationsRestaurantView.fxml' Controller Class
 */

package logic.controller.guicontroller.ManageMenuGuiController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import logic.controller.guicontroller.OwnerBaseGuiController;

public class ControllerGuiNotificationsRestaurantView  extends OwnerBaseGuiController{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

  

    @FXML // fx:id="chooseRestaurantButton"
    private Button chooseRestaurantButton; // Value injected by FXMLLoader

    @FXML // fx:id="scheduleATripButton"
    private Button scheduleATripButton; // Value injected by FXMLLoader


    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="tabella"
    private TableView<?> tabella; // Value injected by FXMLLoader

    @FXML // fx:id="colonnaRistorante"
    private TableColumn<?, ?> colonnaRistorante; // Value injected by FXMLLoader

    @FXML // fx:id="colonnaNotifica"
    private TableColumn<?, ?> colonnaNotifica; // Value injected by FXMLLoader

    @FXML
    void chooseRestaurant(ActionEvent event) {
    	System.out.println("a");
    }

    

    @FXML
    void schedule(ActionEvent event) {
    	System.out.println("at");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'NotificationsRestaurantView.fxml'.";
        assert chooseRestaurantButton != null : "fx:id=\"chooseRestaurantButton\" was not injected: check your FXML file 'NotificationsRestaurantView.fxml'.";
        assert scheduleATripButton != null : "fx:id=\"scheduleATripButton\" was not injected: check your FXML file 'NotificationsRestaurantView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'NotificationsRestaurantView.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'NotificationsRestaurantView.fxml'.";
        assert tabella != null : "fx:id=\"tabella\" was not injected: check your FXML file 'NotificationsRestaurantView.fxml'.";
        assert colonnaRistorante != null : "fx:id=\"colonnaRistorante\" was not injected: check your FXML file 'NotificationsRestaurantView.fxml'.";
        assert colonnaNotifica != null : "fx:id=\"colonnaNotifica\" was not injected: check your FXML file 'NotificationsRestaurantView.fxml'.";

    }
}
