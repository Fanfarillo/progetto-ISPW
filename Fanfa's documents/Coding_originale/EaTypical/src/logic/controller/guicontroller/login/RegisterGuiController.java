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
import javafx.scene.layout.AnchorPane;
import logic.controller.applicationcontroller.Login;
import logic.controller.guicontroller.UserBaseGuiController;
import logic.engineeringclasses.bean.login.BeanUser;
import logic.engineeringclasses.exceptions.AlreadyInUseUsernameException;
import logic.engineeringclasses.exceptions.DataException;
import logic.engineeringclasses.factory.UserFactory;
import logic.model.User;

public class RegisterGuiController extends UserBaseGuiController {
	
	private String userErrorMessage="The username can't be empty!";
	private String passwordErrorMessage="The password can't be empty!";
	private String nameErrorMessage="The name can't be empty!";
	private String surnameErrorMessage="The surname can't be empty!";
	private String genericErrorMessage="Please try again!";

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
    private TextField nameField;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label nameError;

    @FXML
    private Label surnameError;

    @FXML
    private Label usernameError;

    @FXML
    private Label passwordError;

	    
    @FXML
    private CheckBox ownerCheckbox;
    
    @FXML
    private Label newUsernameError;

    @FXML
    private Label genericError;


    @FXML
    void RegisterMethod(ActionEvent event) {
    		try
    		{
	    		String username=this.usernameField.getText();
	    		String name=this.nameField.getText();
	    		String surname=this.surnameField.getText();
	    		String pw=this.passwordField.getText();
	    		boolean isOwner=this.ownerCheckbox.isSelected();
	    		BeanUser bu=new BeanUser();
	    		bu.setName(name);
	    		bu.setSurname(surname);
	    		bu.setUsername(username);
	    		bu.setPassword(pw);   		
	    		bu.setOwner(isOwner);
	    		Login registerAppCont= new Login();		
	    		registerAppCont.registerMethod(bu);						//try to register
	    		User user;
	    		if(isOwner)
	    		{
	    			user=UserFactory.getFactory().createOwner(name, surname, null, username, null, null);
	    		}
	    		else
	    		{
	    			user=UserFactory.getFactory().createTourist(name, surname, username, null, null);
	    		}			//create the correct user entity
	    		
	    		//TODO return user to homepage
    		}
    		catch(DataException de)				//one or more fields are empty
    		{
    			switch(de.getCode())
    			{
    				case 0: setErrorLabelText(0);
    				case 1: setErrorLabelText(1);
    				case 2: setErrorLabelText(2);
    				case 3: setErrorLabelText(3);
    			}
    		}
    		catch(AlreadyInUseUsernameException ae)		//the username has already been chosen
    		{
    			this.newUsernameError.setText(ae.getMessage());
    			this.newUsernameError.setVisible(true);
    		}
    		catch(Exception e)			//other exception that may occur
    		{
    			this.genericError.setText(e.getMessage());
    			this.genericError.setVisible(true);
    		}
    }
    
    private void setErrorLabelText(int i)		//the method that set the error labels
    {
    	switch(i)
    	{
	    	case 0:
				this.usernameError.setText(this.userErrorMessage);
				this.usernameError.setVisible(true);
				break;
			case 1:
				this.nameError.setText(this.nameErrorMessage);
				this.nameError.setVisible(true);
				break;
			case 2:
				this.surnameError.setText(this.surnameErrorMessage);
				this.surnameError.setVisible(true);
				break;
			case 3:
				this.passwordError.setText(this.passwordErrorMessage);
				this.passwordError.setVisible(true);
				break;
    	}
    }


    @FXML
    void initialize() {
    	assert myAnchorPane != null : "fx:id=\"myAnchorPane\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert ownerCheckbox != null : "fx:id=\"ownerCheckbox\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert scheduleTripButton != null : "fx:id=\"scheduleTripButton\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert chooseRestaurantButton != null : "fx:id=\"chooseRestaurantButton\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert nameField != null : "fx:id=\"nameField\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert surnameField != null : "fx:id=\"surnameField\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert usernameField != null : "fx:id=\"usernameField\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert registerButton != null : "fx:id=\"registerButton\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert registerWithFbButton != null : "fx:id=\"registerWithFbButton\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert nameError != null : "fx:id=\"nameError\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert surnameError != null : "fx:id=\"surnameError\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert usernameError != null : "fx:id=\"usernameError\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert passwordError != null : "fx:id=\"passwordError\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert newUsernameError != null : "fx:id=\"newUsernameError\" was not injected: check your FXML file 'RegisterView.fxml'.";
        assert genericError != null : "fx:id=\"genericError\" was not injected: check your FXML file 'RegisterView.fxml'.";

    }
}
