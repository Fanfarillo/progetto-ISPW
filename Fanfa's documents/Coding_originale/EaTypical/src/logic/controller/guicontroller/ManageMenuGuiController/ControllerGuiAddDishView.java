/**
 * Sample Skeleton for 'AddDish.fxml' Controller Class
 */

package logic.controller.guicontroller.ManageMenuGuiController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import logic.controller.guicontroller.OwnerBaseGuiController;

public class ControllerGuiAddDishView extends OwnerBaseGuiController{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

   

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="scegliPiattoBox"
    private ChoiceBox<String> scegliPiattoBox; // Value injected by FXMLLoader

    @FXML // fx:id="priceTextField"
    private TextField priceTextField; // Value injected by FXMLLoader

    @FXML // fx:id="veganCheckBox"
    private CheckBox veganCheckBox; // Value injected by FXMLLoader

    @FXML // fx:id="celiacCheckBox"
    private CheckBox celiacCheckBox; // Value injected by FXMLLoader

    @FXML // fx:id="okButton"
    private Button okButton; // Value injected by FXMLLoader

    @FXML // fx:id="scegliRistorante"
    private ChoiceBox<String> scegliRistorante; // Value injected by FXMLLoader

    @FXML // fx:id="contenutoRicetta"
    private TextArea contenutoRicetta; // Value injected by FXMLLoader
    
   

    public ChoiceBox<String> getScegliPiattoBox()
    {
    	return this.scegliPiattoBox;
    }
    
    public Label getLabel() {
    	return this.nomeUtenteLabel;
    }
   

    @FXML
    void goToConfirmMessageView(ActionEvent event) {
    	String contenutoString = contenutoRicetta.getText();
    	String ristorante = scegliRistorante.getValue();
    	String ricetta = scegliPiattoBox.getValue(); 
    	double prezzo = Double.parseDouble(priceTextField.getText());
    	boolean vegano = veganCheckBox.isSelected();
    	boolean celiaco = celiacCheckBox.isSelected();
    	//System.out.print(contenutoString + " " + ristorante + " " + ricetta + " " + prezzo + " "+ vegano + " "+ celiaco);
    }

    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert myAnchorPane != null : "fx:id=\"myAnchorPane\" was not injected: check your FXML file 'AddDish.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'AddDish.fxml'.";
        assert sponsorRestaurantButton != null : "fx:id=\"sponsorRestaurantButton\" was not injected: check your FXML file 'AddDish.fxml'.";
        assert manageMenuButton != null : "fx:id=\"manageMenuButton\" was not injected: check your FXML file 'AddDish.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'AddDish.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'AddDish.fxml'.";
        assert scegliPiattoBox != null : "fx:id=\"scegliPiattoBox\" was not injected: check your FXML file 'AddDish.fxml'.";
        assert priceTextField != null : "fx:id=\"priceTextField\" was not injected: check your FXML file 'AddDish.fxml'.";
        assert veganCheckBox != null : "fx:id=\"veganCheckBox\" was not injected: check your FXML file 'AddDish.fxml'.";
        assert celiacCheckBox != null : "fx:id=\"celiacCheckBox\" was not injected: check your FXML file 'AddDish.fxml'.";
        assert okButton != null : "fx:id=\"okButton\" was not injected: check your FXML file 'AddDish.fxml'.";
        assert scegliRistorante != null : "fx:id=\"scegliRistorante\" was not injected: check your FXML file 'AddDish.fxml'.";
        assert contenutoRicetta != null : "fx:id=\"contenutoRicetta\" was not injected: check your FXML file 'AddDish.fxml'.";

    }
}
