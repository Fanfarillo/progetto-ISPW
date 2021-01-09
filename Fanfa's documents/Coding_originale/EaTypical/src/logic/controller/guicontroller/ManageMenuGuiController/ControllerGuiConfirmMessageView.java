/**
 * Sample Skeleton for 'ConfirmMessageView.fxml' Controller Class
 */

package logic.controller.guicontroller.ManageMenuGuiController;
import logic.controller.applicationcontroller.ManageMenu;
import logic.controller.guicontroller.OwnerBaseGuiController;
import logic.engineeringclasses.dao.RecipeDAO;
import logic.model.Recipe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ControllerGuiConfirmMessageView  extends OwnerBaseGuiController{
	
	private String contenuto;
	private int stato;
	private String ristorante;
	private String piatto;
	private boolean forCeliac;
	private boolean forVegan;
	private double prezzo;
	private String username;
	
	public ControllerGuiConfirmMessageView(String contenuto, String username,String piatto, String ristorante, boolean vegano, boolean celiaco, double prezzo) {
		this.piatto = piatto;
		this.contenuto = contenuto;
		this.prezzo = prezzo;
		this.forCeliac = celiaco;
		this.forVegan = vegano;
		this.username = username;
		this.ristorante = ristorante;
		this.stato = 1;
	}
	
	public ControllerGuiConfirmMessageView(String nomePiatto, String nomeRistorante) {
		this.piatto = nomePiatto;
		this.ristorante = nomeRistorante;
		this.stato = 2;
	}
	
	public ControllerGuiConfirmMessageView(String username,int stato,String contenuto, String ristorante, String piatto, boolean forVegan, boolean forCeliac, double prezzo) {
		this.contenuto = contenuto;
		this.stato = stato;
		this.ristorante = ristorante;
		this.prezzo = prezzo;
		this.forCeliac = forCeliac;
		this.forVegan = forVegan;
		this.piatto = piatto;
		this.username = username;
		System.out.println(contenuto+ristorante+prezzo+forCeliac+forVegan+piatto);
		
	}

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;


    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="doneButton"
    private Button doneButton; // Value injected by FXMLLoader

    @FXML // fx:id="discardAllTheChangesButton"
    private Button discardAllTheChangesButton; // Value injected by FXMLLoader

    @FXML // fx:id="keepManagingMenuButton"
    private Button keepManagingMenuButton; // Value injected by FXMLLoader

    @FXML
    void discardChanges(ActionEvent event) throws IOException {
    	
    	//scarto tutte le opzioni e ritorno al menu iniziale
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/RestaurantMenuView.fxml"));
    	loader.setControllerFactory(c -> {return new ControllerGuiRestaurantMenuView(username);});
    	Parent root = loader.load();
    	myAnchorPane.getChildren().setAll(root);
    }

    @FXML
    void done(ActionEvent event) throws ClassNotFoundException, IOException {
    	
    	
    	switch (this.stato) {
    	
    	
		case 0: {
			
			//esegue l'aggiunta del piatto e la relativa notifica agli utenti che hanno i suoi ristoranti con
			//quel piatto tra i preferiti
			
			//ricordati di sostituire tutto cio con una Bean!
			ManageMenu manageMenu = new ManageMenu();
			manageMenu.addDish(this.piatto, this.contenuto, this.ristorante, this.forVegan, this.forCeliac, this.prezzo);
			break;
			
		}
		
		case 1: {
			
			//esegue la modifica di un piatto
			ManageMenu manageMenu = new ManageMenu();
			manageMenu.modifyDishes(this.contenuto,this.ristorante,this.piatto, this.username, this.prezzo, this.forVegan, this.forCeliac);			
			break;
			
		}
		
		case 2: {
			
			//esegue l'eliminazione del piatto selezionato cucinato in un suo ristorante, precedentemente selezionato
			
			ManageMenu manageMenu = new ManageMenu();
			manageMenu.deleteDish(piatto, ristorante);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + stato);
			
		}
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/RestaurantMenuView.fxml"));
    	loader.setControllerFactory(c -> {return new ControllerGuiRestaurantMenuView(username);});
    	Parent root = loader.load();
    	myAnchorPane.getChildren().setAll(root);
    }

    

    @FXML
    void keepManagingMenu(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/RestaurantMenuView.fxml"));
    	loader.setControllerFactory(c -> {return new ControllerGuiRestaurantMenuView(username);});
    	Parent root = loader.load();
    	myAnchorPane.getChildren().setAll(root);
    }

    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'ConfirmMessageView.fxml'.";
        assert manageMenuButton != null : "fx:id=\"manageMenuButton\" was not injected: check your FXML file 'ConfirmMessageView.fxml'.";
        assert sponsorRestaurantButton != null : "fx:id=\"sponsorMenuButton\" was not injected: check your FXML file 'ConfirmMessageView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'ConfirmMessageView.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'ConfirmMessageView.fxml'.";
        assert doneButton != null : "fx:id=\"doneButton\" was not injected: check your FXML file 'ConfirmMessageView.fxml'.";
        assert discardAllTheChangesButton != null : "fx:id=\"discardAllTheChangesButton\" was not injected: check your FXML file 'ConfirmMessageView.fxml'.";
        assert keepManagingMenuButton != null : "fx:id=\"keepManagingMenuButton\" was not injected: check your FXML file 'ConfirmMessageView.fxml'.";
        nomeUtenteLabel.setText(username);
    }
}
