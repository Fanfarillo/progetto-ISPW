/**
 * Sample Skeleton for 'ConfirmMessageView.fxml' Controller Class
 */


package logic.controller.guicontroller.ManageMenuGuiController;
import logic.controller.applicationcontroller.ManageMenu;
import logic.controller.guicontroller.OwnerBaseGuiController;
import logic.engineeringclasses.bean.manageMenu.BeanAddDish;
import logic.engineeringclasses.bean.manageMenu.BeanDeleteDish;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * @author Luca Capotombolo
 */



public class ControllerGuiConfirmMessageView  extends OwnerBaseGuiController{
	
	
	private BeanDeleteDish beanDeleteDish;
	private BeanAddDish beanAddDish;		
	private String username;
	
	
	public ControllerGuiConfirmMessageView(String username,BeanDeleteDish beanDeleteDish) {
		this.username = username;
		this.beanDeleteDish = beanDeleteDish;
		
	}
	
	public ControllerGuiConfirmMessageView(String username,BeanAddDish beanAddDish) {
		this.beanAddDish = beanAddDish;
		this.username = username;
		
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

    
    /**
     * Scarta la opzioni e ritorna al menu principale
     * @param event
     * @throws IOException
     */
    @FXML
    void discardChanges(ActionEvent event) throws IOException {
    	
    	//scarto tutte le opzioni e ritorno al menu iniziale
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/RestaurantMenuView.fxml"));
    	loader.setControllerFactory(c -> {return new ControllerGuiRestaurantMenuView(username);});
    	Parent root = loader.load();
    	myAnchorPane.getChildren().setAll(root);
    }

    
    /**
     * Eseguo effettivamente l'operazione richiesta
     * @param event
     * @throws ClassNotFoundException
     * @throws IOException
     */
    @FXML
    void done(ActionEvent event) throws ClassNotFoundException, IOException {
    	
    	if(beanAddDish!=null) {
    		if(beanAddDish.getTipoModifica()==0) {
    			ManageMenu manageMenu = new ManageMenu();
    			manageMenu.addDish(beanAddDish);
    			
    		}else {
    			ManageMenu manageMenu = new ManageMenu();
    			manageMenu.modifyDishes(beanAddDish);	
    			
    		}
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/RestaurantMenuView.fxml"));
        	loader.setControllerFactory(c -> {return new ControllerGuiRestaurantMenuView(username);});
        	Parent root = loader.load();
        	myAnchorPane.getChildren().setAll(root);
    	}
    	
    	if(beanDeleteDish!=null) {
    		ManageMenu manageMenu = new ManageMenu();
			manageMenu.deleteDish(beanDeleteDish);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/RestaurantMenuView.fxml"));
	    	loader.setControllerFactory(c -> {return new ControllerGuiRestaurantMenuView(username);});
	    	Parent root = loader.load();
	    	myAnchorPane.getChildren().setAll(root);
			return;
    	}
    	/*
    	switch (this.beanAddDish.getTipoModifica()) {
    	
    	
		case 0: {
			
			//esegue l'aggiunta del piatto e la relativa notifica agli utenti che hanno i suoi ristoranti con
			//quel piatto tra i preferiti
			
			//ricordati di sostituire tutto cio con una Bean!
			ManageMenu manageMenu = new ManageMenu();
			manageMenu.addDish(beanAddDish);
			break;
			
		}
		
		case 1: {
			
			//esegue la modifica di un piatto
			ManageMenu manageMenu = new ManageMenu();
			manageMenu.modifyDishes(beanAddDish);			
			break;
			
		}
		
		case 2: {
			
			//esegue l'eliminazione del piatto selezionato cucinato in un suo ristorante, precedentemente selezionato
			
			ManageMenu manageMenu = new ManageMenu();
			manageMenu.deleteDish(beanDeleteDish);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + stato);
			
		}
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/RestaurantMenuView.fxml"));
    	loader.setControllerFactory(c -> {return new ControllerGuiRestaurantMenuView(username);});
    	Parent root = loader.load();
    	myAnchorPane.getChildren().setAll(root);*/
    }

    
    /**
     * Reindirro al menu principale
     * @param event
     * @throws IOException
     */
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
