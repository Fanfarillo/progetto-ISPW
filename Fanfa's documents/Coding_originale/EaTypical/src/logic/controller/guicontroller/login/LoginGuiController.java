package logic.controller.guicontroller.login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import logic.controller.guicontroller.UserBaseGuiController;

public class LoginGuiController extends UserBaseGuiController {
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane myAnchorPane;

    @FXML
    private Button homeButton;

    @FXML
    private Button scheduleTripButton;

    @FXML
    private Button chooseRestaurantButton;

    @FXML
    private Button backButton;
    
    @FXML
    private CheckBox ownerCheckbox;

    @FXML
    private Label password_error;

    @FXML
    private Label user_error;

    @FXML
    private Label data_error;


    @FXML
    void loginMethod(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert myAnchorPane != null : "fx:id=\"myAnchorPane\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert scheduleTripButton != null : "fx:id=\"scheduleTripButton\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert chooseRestaurantButton != null : "fx:id=\"chooseRestaurantButton\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert password_error != null : "fx:id=\"password_error\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert user_error != null : "fx:id=\"user_error\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert data_error != null : "fx:id=\"data_error\" was not injected: check your FXML file 'LoginView.fxml'.";

    }
}
