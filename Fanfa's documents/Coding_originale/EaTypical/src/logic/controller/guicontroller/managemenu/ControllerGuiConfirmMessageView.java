/**
 * Sample Skeleton for 'ConfirmMessageView.fxml' Controller Class
 */


package logic.controller.guicontroller.managemenu;

import logic.controller.applicationcontroller.ManageMenu;
import logic.controller.guicontroller.OwnerBaseGuiController;
import logic.engineeringclasses.bean.managerestaurant.BeanDeleteDish;
import logic.engineeringclasses.bean.managerestaurant.BeanDish;
import logic.engineeringclasses.exceptions.DishAlreadyExists;
import logic.engineeringclasses.exceptions.InvalidDishDelete;
import logic.engineeringclasses.exceptions.InvalidDishModify;
import logic.engineeringclasses.others.Session;

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
	
	private static final String DESTINATION = "/logic/view/standalone/managemenu/RestaurantMenuView.fxml";
	private BeanDeleteDish beanDeleteDish;
	private BeanDish beanDish;	
	
	
	public ControllerGuiConfirmMessageView(BeanDeleteDish beanDeleteDish,Session bs) {
		super(bs);
		this.beanDeleteDish = beanDeleteDish;
		
	}
	
	public ControllerGuiConfirmMessageView(BeanDish beanDish,Session bs) {
		super(bs);
		this.beanDish = beanDish;
		
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
     * Scarta la opzione e ritorna al menu principale
     * @param event
     * @throws IOException
     */
    @FXML
    void discardChanges(ActionEvent event) throws IOException {
    	
    	//scarto tutte le opzioni e ritorno al menu iniziale
    	FXMLLoader loader = new FXMLLoader(getClass().getResource(DESTINATION));
    	loader.setControllerFactory(c -> new ControllerGuiRestaurantMenuView(bs));
    	Parent root = loader.load();
    	myAnchorPane.getChildren().setAll(root);
    }

    
    /**
     * Eseguo effettivamente l'operazione richiesta: aggiornameto, eliminazione o inserimento di un piatto
     * @param event
     * @throws ClassNotFoundException
     * @throws IOException
     */
    @FXML
    void done(ActionEvent event) throws ClassNotFoundException, IOException {
    	ManageMenu manageMenu = new ManageMenu();
    	//E' diverso da null se e' stata richiesta la modifica di un piatto o l'inserimento di un piatto
    	if(beanDish!=null) {
    		//verifico se e' stata richiesta una scrittura
    		if(beanDish.getTypeChange()==0) {
    			try {
    				manageMenu.addDish(beanDish);
				} catch (DishAlreadyExists e) {
					FXMLLoader loader = new FXMLLoader(getClass().getResource(DESTINATION));
		        	loader.setControllerFactory(c -> new ControllerGuiRestaurantMenuView(0,e.getMess(),bs));
		        	Parent root = loader.load();
		        	myAnchorPane.getChildren().setAll(root);
		        	return;
				}
    			
    			
    		}else {
    			try {
    				manageMenu.modifyDishes(beanDish);
				} catch (InvalidDishModify e) {
					FXMLLoader loader = new FXMLLoader(getClass().getResource(DESTINATION));
		        	loader.setControllerFactory(c -> new ControllerGuiRestaurantMenuView(1, e.getMess(),bs));
		        	Parent root = loader.load();
		        	myAnchorPane.getChildren().setAll(root);
		        	return;
				}    			
    		}
    	
    	}
    	
    	//E' diversa da null se e' stata richiesta l'eliminazione di un piatto
    	if(beanDeleteDish!=null) {
    		try {
    			manageMenu.deleteDish(beanDeleteDish);
			} catch (InvalidDishDelete e) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource(DESTINATION));
	        	loader.setControllerFactory(c -> new ControllerGuiRestaurantMenuView(2, e.getMess(),bs));
	        	Parent root = loader.load();
	        	myAnchorPane.getChildren().setAll(root);
	        	return;
			}
			
    	}
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource(DESTINATION));
		//se vale -1 allora non vi e' stato alcun errore
    	loader.setControllerFactory(c -> new ControllerGuiRestaurantMenuView(bs));
    	Parent root = loader.load();
    	myAnchorPane.getChildren().setAll(root);
    	
    }

    
    

    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'ConfirmMessageView.fxml'.";
        assert manageMenuButton != null : "fx:id=\"manageMenuButton\" was not injected: check your FXML file 'ConfirmMessageView.fxml'.";
        assert sponsorRestaurantButton != null : "fx:id=\"sponsorMenuButton\" was not injected: check your FXML file 'ConfirmMessageView.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'ConfirmMessageView.fxml'.";
        assert doneButton != null : "fx:id=\"doneButton\" was not injected: check your FXML file 'ConfirmMessageView.fxml'.";
        assert discardAllTheChangesButton != null : "fx:id=\"discardAllTheChangesButton\" was not injected: check your FXML file 'ConfirmMessageView.fxml'.";
        nomeUtenteLabel.setText(bs.getUser().getUsername());
    }
}
