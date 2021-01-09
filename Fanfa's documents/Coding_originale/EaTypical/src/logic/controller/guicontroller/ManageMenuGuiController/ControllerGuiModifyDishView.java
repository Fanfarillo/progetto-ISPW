/**
 * Sample Skeleton for 'ModifyDishView.fxml' Controller Class
 */

package logic.controller.guicontroller.ManageMenuGuiController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import logic.controller.guicontroller.OwnerBaseGuiController;

public class ControllerGuiModifyDishView  extends OwnerBaseGuiController{

	private String username;
	private ObservableList<String> obs;
	private ObservableList<String> obs2;
	
	public ControllerGuiModifyDishView(String username, ObservableList<String> obs,ObservableList<String> obs2) {
		this.username = username;
		this.obs = FXCollections.observableArrayList(obs);
		this.obs2 = FXCollections.observableArrayList(obs2);
		
	}
	
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
    
    @FXML
    private ChoiceBox<String> choiseRistoranti;
    
    @FXML
    private TextArea nuovoContenuto;

  

    @FXML
    void modify(ActionEvent event) throws IOException {
    	
    	
    	//definisco ed inizializzo i parametri del costruttore del controller grafico    	
    	String ricetta = choiseBox.getValue(); 
    	double prezzo = Double.parseDouble(priceText.getText());
    	boolean vegano = veganCheck.isSelected();
    	boolean celiaco = celiacCheck.isSelected();
    	
    	//ottengo il nodo radice fxml e vado a settare il controller grafico della nuova GUI
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/ConfirmMessageView.fxml"));
    	loader.setControllerFactory(c -> {return new ControllerGuiConfirmMessageView(nuovoContenuto.getText(),nomeUtenteLabel.getText(),ricetta, choiseRistoranti.getValue(),vegano, celiaco, prezzo);});
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
        assert choiseRistoranti != null : "fx:id=\"choiseRistoranti\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert veganCheck != null : "fx:id=\"veganCheck\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert celiacCheck != null : "fx:id=\"celiacCheck\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert priceText != null : "fx:id=\"priceText\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert modifyButton != null : "fx:id=\"modifyButton\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        assert nuovoContenuto != null : "fx:id=\"nuovoContenuto\" was not injected: check your FXML file 'ModifyDishView.fxml'.";
        nomeUtenteLabel.setText(username);
        choiseBox.setItems(obs);
        choiseRistoranti.setItems(obs2);
    }
}

