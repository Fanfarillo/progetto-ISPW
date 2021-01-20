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

public class RegisterGuiController extends UserBaseGuiController {

	@FXML
	private ResourceBundle resources;
		
	@FXML
	private AnchorPane myAnchorPane;

	@FXML
	private URL location;

	@FXML
	private Button registerButton;

	@FXML
	private Button registerWithFbButton;

	@FXML
	private Label name_error;

	@FXML
    private Label surname_error;

	@FXML
    private Label username_error;

    @FXML
    private Label password_error;
	    
    @FXML
    private CheckBox ownerCheckbox;


    @FXML
    void RegisterMethod(ActionEvent event) {

    }


    @FXML
    void initialize() {
    	assert myAnchorPane != null : "fx:id=\"myAnchorPane\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert name_error != null : "fx:id=\"name_error\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert surname_error != null : "fx:id=\"surname_error\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert username_error != null : "fx:id=\"username_error\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert password_error != null : "fx:id=\"password_error\" was not injected: check your FXML file 'RegisterView.fxml'.";

    }
}
