package logic.controller.guicontroller.favrestaurants;

import logic.controller.guicontroller.UserBaseGuiController;
import logic.engineeringclasses.bean.BeanFavRestaurant;
import logic.engineeringclasses.dao.FavouriteRestDAO;
import logic.engineeringclasses.others.Session;

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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControllerGuiFavRestaurants extends UserBaseGuiController {
	private ObservableList<BeanFavRestaurant> ol;
	
	private String favRestPage = "/logic/view/standalone/favrestaurants/FavRestaurantsView.fxml";
	private BeanFavRestaurant[] favRest;
	private String errorMessage="";
	
	public ControllerGuiFavRestaurants(BeanFavRestaurant[] favRest, Session bs) {
		super(bs);
		
		if(favRest!=null && favRest.length==0) this.favRest=null;
		else this.favRest=favRest;
	}
	
	public ControllerGuiFavRestaurants(BeanFavRestaurant[] favRest, String errorMessage, Session bs) {
		super(bs);
		
		if(favRest!=null && favRest.length==0) this.favRest=null;
		else this.favRest=favRest;
		
		this.errorMessage=errorMessage;
	}
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="tabella"
    private TableView<BeanFavRestaurant> tabella; // Value injected by FXMLLoader

    @FXML // fx:id="cityColumn"
    private TableColumn<BeanFavRestaurant, String> cityColumn; // Value injected by FXMLLoader

    @FXML // fx:id="nameRestColumn"
    private TableColumn<BeanFavRestaurant, String> nameRestColumn; // Value injected by FXMLLoader

    @FXML // fx:id="addressColumn"
    private TableColumn<BeanFavRestaurant, String> addressColumn; // Value injected by FXMLLoader

    @FXML // fx:id="avgVoteColumn"
    private TableColumn<BeanFavRestaurant, String> avgVoteColumn; // Value injected by FXMLLoader

    @FXML // fx:id="deleteAllButton"
    private Button deleteAllButton; // Value injected by FXMLLoader

    @FXML // fx:id="errorLabel"
    private Label errorLabel; // Value injected by FXMLLoader

    @FXML
    void deleteRestaurants(ActionEvent event) throws IOException {
    	try {
    		FavouriteRestDAO.delete(this.bs.getUser().getUsername());
    		
    		FXMLLoader loader=new FXMLLoader(getClass().getResource(this.favRestPage));
    		loader.setControllerFactory(c -> new ControllerGuiFavRestaurants(null, bs));
    		Parent root=loader.load();
    		myAnchorPane.getChildren().setAll(root);    		
    	}
    	catch(Exception e) {
    		FXMLLoader loader=new FXMLLoader(getClass().getResource(this.favRestPage));
    		loader.setControllerFactory(c -> new ControllerGuiFavRestaurants(this.favRest, "An unknown error occurred. Please, try again later.", bs));
    		Parent root=loader.load();
    		myAnchorPane.getChildren().setAll(root); 
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'FavRestaurantsView.fxml'.";
        assert tabella != null : "fx:id=\"tabella\" was not injected: check your FXML file 'FavRestaurantsView.fxml'.";
        assert cityColumn != null : "fx:id=\"dateColumn\" was not injected: check your FXML file 'FavRestaurantsView.fxml'.";
        assert nameRestColumn != null : "fx:id=\"nameColumn\" was not injected: check your FXML file 'FavRestaurantsView.fxml'.";
        assert addressColumn != null : "fx:id=\"addressColumn\" was not injected: check your FXML file 'FavRestaurantsView.fxml'.";
        assert avgVoteColumn != null : "fx:id=\"avgVoteColumn\" was not injected: check your FXML file 'FavRestaurantsView.fxml'.";
        assert deleteAllButton != null : "fx:id=\"deleteAllButton\" was not injected: check your FXML file 'FavRestaurantsView.fxml'.";
        assert errorLabel != null : "fx:id=\"errorLabel\" was not injected: check your FXML file 'FavRestaurantsView.fxml'.";
        
        if(this.favRest==null) {
        	this.favRest = new BeanFavRestaurant[1];
        	this.favRest[0] = new BeanFavRestaurant("There is no restaurant", "", "", "");
        }
        
        if(this.bs.getUser()!=null)
        	nomeUtenteLabel.setText(this.bs.getUser().getUsername());
        else
        	nomeUtenteLabel.setText("Not logged");
        
        errorLabel.setText(errorMessage);
        
        ol = FXCollections.observableArrayList();
        for(int i=0; i<this.favRest.length; i++) {
        	ol.add(this.favRest[i]);
        }
        cityColumn.setCellValueFactory(new PropertyValueFactory<BeanFavRestaurant, String>("city"));
        nameRestColumn.setCellValueFactory(new PropertyValueFactory<BeanFavRestaurant, String>("name"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<BeanFavRestaurant, String>("address"));
        avgVoteColumn.setCellValueFactory(new PropertyValueFactory<BeanFavRestaurant, String>("strAvgVote"));
        
        tabella.setItems(ol);
        
    }
    
}
