package logic.controller.guicontroller;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import logic.engineeringclasses.others.SizedStack;

//Base Graphic Controller: every view page has a back button and a home button
public class BaseGuiController {
	
	protected String homePage = "/logic/view/standalone/HomePageTouristView.fxml";
    
	@FXML
    protected AnchorPane myAnchorPane;
	
    @FXML
    protected Button backButton;
    
    @FXML
    protected Button homeButton;
	
	@FXML
    void goHomePage(ActionEvent event) throws IOException {			//The Home Page button onAction method
		
    	//SizedStack.getSizedStack().push(this.homePage);
		SizedStack.getSizedStack().clearStack();
    	FXMLLoader loader=new FXMLLoader(getClass().getResource(this.homePage));
    	Parent root=loader.load();
    	myAnchorPane.getChildren().setAll(root);
    }

    @FXML
    void goToBackPage(ActionEvent event) throws IOException {		//The Back Button onAction method

    	String page=SizedStack.getSizedStack().pop();
    	//String page=SizedStack.getSizedStack().read();
    	FXMLLoader loader=new FXMLLoader(getClass().getResource(page));
    	Parent root=loader.load();
    	myAnchorPane.getChildren().setAll(root);
    }

}
