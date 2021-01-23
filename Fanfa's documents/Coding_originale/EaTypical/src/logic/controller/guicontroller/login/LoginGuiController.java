package logic.controller.guicontroller.login;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import logic.controller.applicationcontroller.Login;
import logic.controller.guicontroller.UserBaseGuiController;
import logic.engineeringclasses.bean.login.BeanUser;
import logic.engineeringclasses.exceptions.DataException;
import logic.engineeringclasses.exceptions.WrongUsernameOrPasswordException;
import logic.model.User;

public class LoginGuiController extends UserBaseGuiController {
	
	private String userErrorMessage="The username can't be empty!";
	private String passwordErrorMessage="The password can't be empty!";
	private String genericErrorMessage="Please try again!";
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private CheckBox ownerCheckbox;
    
    @FXML
    private Button loginButton;

    @FXML
    private Button loginWithFBButton;

    @FXML
    private Label passwordError;

    @FXML
    private Label userError;

    @FXML
    private Label dataError;
    
    @FXML
    private Label genericError;
    

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;


    @FXML
    void loginMethod(ActionEvent event) {
    	
    	try
    	{
	    	String username= usernameField.getText();
	    	String pw=passwordField.getText();
	    	boolean isOwner=ownerCheckbox.isSelected();
	    	BeanUser bu= new BeanUser();
	    	bu.setUsername(username);
	    	bu.setOwner(isOwner);
	    	bu.setPassword(pw);
	    	Login loginAppContr= new Login();
	    	User loggedtourist=loginAppContr.loginMethod(bu);		//try to login
	    	//TODO    call the homepage and pass the user	    	
	    	
	    	
    	}
    	catch(DataException de)		//when username or password fields are empty
    	{
    		setErrorLabelText(de.getCode());
    	}
    	catch(WrongUsernameOrPasswordException we)			//when username or password or both are wrong
    	{
    		this.dataError.setText(we.getMessage());
    		this.dataError.setVisible(true);
    	}
    	catch (Exception e) {				//other unexpected exception that may occur
    		this.genericError.setText(e.getMessage());
    		this.genericError.setVisible(true);
		}
    	
    }
    
    
    
    private void setErrorLabelText(int i)
    {
    	if(i==0)
		{
			this.userError.setText(this.userErrorMessage);
			this.userError.setVisible(true);
		}
		else
		{
			this.passwordError.setText(this.passwordErrorMessage);
			this.passwordError.setVisible(true);
		}
    }
    
    

    @FXML
    void initialize() {
    	
    	assert myAnchorPane != null : "fx:id=\"myAnchorPane\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert scheduleTripButton != null : "fx:id=\"scheduleTripButton\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert chooseRestaurantButton != null : "fx:id=\"chooseRestaurantButton\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert usernameField != null : "fx:id=\"usernameField\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert loginWithFBButton != null : "fx:id=\"loginWithFBButton\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert passwordError != null : "fx:id=\"passwordError\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert userError != null : "fx:id=\"userError\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert dataError != null : "fx:id=\"dataError\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert ownerCheckbox != null : "fx:id=\"ownerCheckbox\" was not injected: check your FXML file 'LoginView.fxml'.";
        assert genericError != null : "fx:id=\"genericError\" was not injected: check your FXML file 'LoginView.fxml'.";

    }
}
