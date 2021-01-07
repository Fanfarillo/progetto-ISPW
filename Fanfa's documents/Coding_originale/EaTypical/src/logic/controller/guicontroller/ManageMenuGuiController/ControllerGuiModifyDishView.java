/**
 * Sample Skeleton for 'ModifyDishView.fxml' Controller Class
 */

package logic.controller.guicontroller.ManageMenuGuiController;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logic.controller.applicationcontroller.ManageMenu;

public class ControllerGuiModifyDishView  extends OwnerBaseGuiController{

	
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    
    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="choiseBox"
    private ChoiceBox<String> choiseBox; // Value injected by FXMLLoader

    @FXML // fx:id="veganCheck"
    private CheckBox veganCheck; // Value injected by FXMLLoader

    @FXML // fx:id="celiacCheck"
    private CheckBox celiacCheck; // Value injected by FXMLLoader

    @FXML // fx:id="priceText"
    private TextField priceText; // Value injected by FXMLLoader

    @FXML // fx:id="modifyButton"
    private Button modifyButton; // Value injected by FXMLLoader

  
    
    public Label getLabel() {
    	return this.nomeUtenteLabel;
    }
    
    public ChoiceBox<String> getChoiceBox(){
    	return this.choiseBox;
    }

    @FXML
    void modify(ActionEvent event) {
    	//System.out.println("modify\n");
    	
    	//leggo gli input dell'utente
    	String ricetta = choiseBox.getValue(); 
    	double prezzo = Double.parseDouble(priceText.getText());
    	boolean vegano = veganCheck.isSelected();
    	boolean celiaco = celiacCheck.isSelected();
    	
    	
    	ManageMenu manageMenu = new ManageMenu();
    	manageMenu.
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/ConfirmMessageView.fxml"));
    	Parent rootParent = loader.load();
    	myAnchorPane.getChildren().setAll(rootParent);
    }

   

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert manageMenuButton != null : "fx:id=\"manageMenuButton\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert sponsorRestaurantButton != null : "fx:id=\"sponsorRestaurantButton\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert choiseBox != null : "fx:id=\"choiseBox\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert veganCheck != null : "fx:id=\"veganCheck\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert celiacCheck != null : "fx:id=\"celiacCheck\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert priceText != null : "fx:id=\"priceText\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert modifyButton != null : "fx:id=\"modifyButton\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
       
    }
}

