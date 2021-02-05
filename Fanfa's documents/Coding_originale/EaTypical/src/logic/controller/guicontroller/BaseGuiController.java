package logic.controller.guicontroller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import logic.engineeringclasses.others.Session;

//Base Graphic Controller: every view page has a back button and a home button
public class BaseGuiController {
	
	
	 protected Session bs;
	 protected BaseGuiController(Session bs){
	 	this.bs = bs;
	 }
	
	
	
    
	@FXML
    protected AnchorPane myAnchorPane;
    
    @FXML
    protected Button homeButton;
	
	@FXML
    void goHomePage(ActionEvent event) throws IOException {			//The Home Page button onAction method				
		// Bisogna aggiungere il controllo su se si tratta di un utente non loggato, un turista o un owner
    	FXMLLoader loader=new FXMLLoader(getClass().getResource(this.bs.getFirstPage()));
		if(this.bs.isOwner())
		{
			loader.setControllerFactory(c -> new ControllerGuiHomePageOwner(this.bs));
		}
		else
			loader.setControllerFactory(c -> new ControllerGuiHomePageTourist(this.bs));
    	
    	Parent root=loader.load();
    	myAnchorPane.getChildren().setAll(root);
    }


}
