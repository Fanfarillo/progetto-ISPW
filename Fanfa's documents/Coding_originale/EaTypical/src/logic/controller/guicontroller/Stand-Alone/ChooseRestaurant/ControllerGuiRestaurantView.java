/**
 * Sample Skeleton for 'RestaurantView.fxml' Controller Class
 */

package logic.controller.guicontroller.ChooseRestaurant;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class ControllerGuiRestaurantView {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="backButton"
    private Button backButton; // Value injected by FXMLLoader

    @FXML // fx:id="chooseRestButton"
    private Button chooseRestButton; // Value injected by FXMLLoader

    @FXML // fx:id="scheduleButton"
    private Button scheduleButton; // Value injected by FXMLLoader

    @FXML // fx:id="homeButton"
    private Button homeButton; // Value injected by FXMLLoader

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

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert chooseRestButton != null : "fx:id=\"chooseRestButton\" was not injected: check your FXML file 'RestaurantView.fxml'.";
        assert scheduleButton != null : "fx:id=\"scheduleButton\" was not injected: check your FXML file 'RestaurantView.fxml'.";
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
