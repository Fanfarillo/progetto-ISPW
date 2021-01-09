/**
 * Sample Skeleton for 'DeleteDishView.fxml' Controller Class
 */

package logic.controller.guicontroller.ManageMenuGuiController;
import logic.controller.guicontroller.OwnerBaseGuiController;

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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class ControllerGuiDeleteDish  extends OwnerBaseGuiController{

	private ObservableList<String> obs1;
	private ObservableList<String> obs2;
	private String username;
	
	public ControllerGuiDeleteDish(String username,ObservableList<String> obs1, ObservableList<String> obs2) {
		this.obs1 = FXCollections.observableArrayList(obs1);
    	this.obs2 = FXCollections.observableArrayList(obs2);
		this.username = username;
	}
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private ChoiceBox<String> scegliRistorante;

    @FXML // fx:id="nomeUtente"
    private Label nomeUtente; // Value injected by FXMLLoader

    @FXML // fx:id="choiseDish"
    private ChoiceBox<String> choiseDish; // Value injected by FXMLLoader

    @FXML // fx:id="deleteButton"
    private Button deleteButton; // Value injected by FXMLLoader

    @FXML
    void delete(ActionEvent event) throws IOException {
    	
    	String ristorante = scegliRistorante.getValue();
    	String ricetta = choiseDish.getValue(); 
    	
    	
    	//ottengo il nodo radice fxml e vado a settare il controller grafico della nuova GUI
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/ConfirmMessageView.fxml"));
    	loader.setControllerFactory(c -> {return new ControllerGuiConfirmMessageView(ricetta, ristorante);});
    	Parent rootParent = loader.load();
    	myAnchorPane.getChildren().setAll(rootParent);
    }

        

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'DeleteDishView.fxml'.";
        assert manageMenuButton != null : "fx:id=\"manageMenuButton\" was not injected: check your FXML file 'DeleteDishView.fxml'.";
        assert sponsorRestaurantButton != null : "fx:id=\"sponsorRestaurantButton\" was not injected: check your FXML file 'DeleteDishView.fxml'.";
        assert backButton != null : "fx:id=\"back\" was not injected: check your FXML file 'DeleteDishView.fxml'.";
        assert nomeUtente != null : "fx:id=\"nomeUtente\" was not injected: check your FXML file 'DeleteDishView.fxml'.";
        assert choiseDish != null : "fx:id=\"choiseDish\" was not injected: check your FXML file 'DeleteDishView.fxml'.";
        assert deleteButton != null : "fx:id=\"deleteButton\" was not injected: check your FXML file 'DeleteDishView.fxml'.";
        choiseDish.setItems(this.obs1);
        scegliRistorante.setItems(this.obs2);
        nomeUtente.setText(username);
    }
}
