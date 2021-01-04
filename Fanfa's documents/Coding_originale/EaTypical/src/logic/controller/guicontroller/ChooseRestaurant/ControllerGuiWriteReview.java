/**
 * Sample Skeleton for 'WriteReviewView.fxml' Controller Class
 */

package logic.controller.guicontroller.ChooseRestaurant;

import java.net.URL;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import logic.controller.guicontroller.UserBaseGuiController;
public class ControllerGuiWriteReview extends UserBaseGuiController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="s1"
    private RadioButton s1; // Value injected by FXMLLoader

    @FXML // fx:id="s2"
    private RadioButton s2; // Value injected by FXMLLoader

    @FXML // fx:id="s5"
    private RadioButton s5; // Value injected by FXMLLoader

    @FXML // fx:id="s3"
    private RadioButton s3; // Value injected by FXMLLoader

    @FXML // fx:id="s4"
    private RadioButton s4; // Value injected by FXMLLoader

    @FXML // fx:id="textArea"
    private TextArea textArea; // Value injected by FXMLLoader

    @FXML // fx:id="publishButton"
    private Button publishButton; // Value injected by FXMLLoader
    
    @FXML
    void publishMethod(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'WriteReviewView.fxml'.";
        assert chooseRestaurantButton != null : "fx:id=\"chooseRestButton\" was not injected: check your FXML file 'WriteReviewView.fxml'.";
        assert scheduleTripButton != null : "fx:id=\"scheduleButton\" was not injected: check your FXML file 'WriteReviewView.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'WriteReviewView.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'WriteReviewView.fxml'.";
        assert s1 != null : "fx:id=\"s1\" was not injected: check your FXML file 'WriteReviewView.fxml'.";
        assert s2 != null : "fx:id=\"s2\" was not injected: check your FXML file 'WriteReviewView.fxml'.";
        assert s5 != null : "fx:id=\"s5\" was not injected: check your FXML file 'WriteReviewView.fxml'.";
        assert s3 != null : "fx:id=\"s3\" was not injected: check your FXML file 'WriteReviewView.fxml'.";
        assert s4 != null : "fx:id=\"s4\" was not injected: check your FXML file 'WriteReviewView.fxml'.";
        assert textArea != null : "fx:id=\"textArea\" was not injected: check your FXML file 'WriteReviewView.fxml'.";
        assert publishButton != null : "fx:id=\"publishButton\" was not injected: check your FXML file 'WriteReviewView.fxml'.";

    }
}
