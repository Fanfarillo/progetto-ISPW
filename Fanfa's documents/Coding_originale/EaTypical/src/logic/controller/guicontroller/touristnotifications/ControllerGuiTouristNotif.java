package logic.controller.guicontroller.touristnotifications;

import logic.controller.guicontroller.ControllerGuiHomePageTourist;
import logic.controller.guicontroller.UserBaseGuiController;
import logic.engineeringclasses.bean.BeanStringNotif;
import logic.engineeringclasses.dao.NotificationsDAO;
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

public class ControllerGuiTouristNotif extends UserBaseGuiController {
	private ObservableList<BeanStringNotif> ol;
	
	private String homePageTourist = "/logic/view/standalone/HomePageTouristView.fxml";
	private String touristNotifPage = "/logic/view/standalone/touristnotifications/TouristNotifView.fxml";
	private BeanStringNotif[] notifications;
	private String errorMessage="";
	
	public ControllerGuiTouristNotif(BeanStringNotif[] notifications, Session bs) {
		super(bs);
		
		if(notifications!=null && notifications.length==0) this.notifications=null;
		else this.notifications=notifications;
	}
	
	public ControllerGuiTouristNotif(BeanStringNotif[] notifications, String errorMessage, Session bs) {
		super(bs);
		
		if(notifications!=null && notifications.length==0) this.notifications=null;
		else this.notifications=notifications;
		
		this.errorMessage=errorMessage;
	}

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="tabella"
    private TableView<BeanStringNotif> tabella; // Value injected by FXMLLoader

    @FXML // fx:id="notifColumn"
    private TableColumn<BeanStringNotif, String> notifColumn; // Value injected by FXMLLoader

    @FXML // fx:id="ContinueButton"
    private Button ContinueButton; // Value injected by FXMLLoader

    @FXML // fx:id="errorLabel"
    private Label errorLabel; // Value injected by FXMLLoader

    @FXML
    void deleteNotifications(ActionEvent event) throws IOException {
    	try {
    		NotificationsDAO.deleteTouristNotification(this.bs.getUser().getUsername());
    	
    		FXMLLoader loader=new FXMLLoader(getClass().getResource(this.homePageTourist));
    		loader.setControllerFactory(c -> new ControllerGuiHomePageTourist(bs));
    		Parent root=loader.load();
    		myAnchorPane.getChildren().setAll(root);
    	}
    	catch(Exception e) {
    		FXMLLoader loader=new FXMLLoader(getClass().getResource(this.touristNotifPage));
    		loader.setControllerFactory(c -> new ControllerGuiTouristNotif(this.notifications, "An unknown error occurred. Please, try again later.", bs));
    		Parent root=loader.load();
    		myAnchorPane.getChildren().setAll(root);    
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'TouristNotifView.fxml'.";
        assert tabella != null : "fx:id=\"tabella\" was not injected: check your FXML file 'TouristNotifView.fxml'.";
        assert notifColumn != null : "fx:id=\"dateColumn\" was not injected: check your FXML file 'TouristNotifView.fxml'.";
        assert ContinueButton != null : "fx:id=\"ContinueButton\" was not injected: check your FXML file 'TouristNotifView.fxml'.";
        assert errorLabel != null : "fx:id=\"errorLabel\" was not injected: check your FXML file 'TouristNotifView.fxml'.";
        
        if(this.notifications==null) {
        	this.notifications = new BeanStringNotif[1];
        	this.notifications[0] = new BeanStringNotif("There is no notification");
        }
        
        errorLabel.setText(errorMessage);
        
        if(this.bs.getUser()!=null)
        	nomeUtenteLabel.setText(this.bs.getUser().getUsername());
        else
        	nomeUtenteLabel.setText("Not logged");
        
        ol = FXCollections.observableArrayList();
        for(int i=0; i<this.notifications.length; i++) {
        	ol.add(this.notifications[i]);
        }
        notifColumn.setCellValueFactory(new PropertyValueFactory<BeanStringNotif, String>("strNotif"));
        tabella.setItems(ol);
        
    }
	
}
