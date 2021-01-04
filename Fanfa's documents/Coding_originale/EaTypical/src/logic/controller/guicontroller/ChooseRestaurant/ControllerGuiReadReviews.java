/**
 * Sample Skeleton for 'ReadReviewsView.fxml' Controller Class
 */

package logic.controller.guicontroller.ChooseRestaurant;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import logic.controller.guicontroller.UserBaseGuiController;
public class ControllerGuiReadReviews extends UserBaseGuiController{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="scroll"
    private AnchorPane scroll; // Value injected by FXMLLoader

    @FXML // fx:id="voteLabel"
    private Label voteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="nomeRistLabel"
    private Label nomeRistLabel; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'ReadReviewsView.fxml'.";
        assert chooseRestaurantButton != null : "fx:id=\"chooseRestButton\" was not injected: check your FXML file 'ReadReviewsView.fxml'.";
        assert scheduleTripButton != null : "fx:id=\"scheduleButton\" was not injected: check your FXML file 'ReadReviewsView.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'ReadReviewsView.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'ReadReviewsView.fxml'.";
        assert scroll != null : "fx:id=\"scroll\" was not injected: check your FXML file 'ReadReviewsView.fxml'.";
        assert voteLabel != null : "fx:id=\"voteLabel\" was not injected: check your FXML file 'ReadReviewsView.fxml'.";
        assert nomeRistLabel != null : "fx:id=\"nomeRistLabel\" was not injected: check your FXML file 'ReadReviewsView.fxml'.";

    }
}
