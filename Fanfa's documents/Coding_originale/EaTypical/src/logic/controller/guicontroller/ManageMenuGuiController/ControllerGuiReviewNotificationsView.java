/**
 * Sample Skeleton for 'NotificationsRestaurantViewScheduling.fxml' Controller Class
 */

package logic.controller.guicontroller.ManageMenuGuiController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.controller.guicontroller.ControllerGuiHomePageOwner;
import logic.controller.guicontroller.OwnerBaseGuiController;
import logic.engineeringclasses.bean.manageMenu.BeanListReviews;
import logic.engineeringclasses.bean.manageMenu.BeanReview;
import logic.engineeringclasses.others.Session;

public class ControllerGuiReviewNotificationsView extends OwnerBaseGuiController{

	private BeanListReviews beanListReviews;
	
    public ControllerGuiReviewNotificationsView(Session bs,BeanListReviews beanListReviews) {
		super(bs);
		this.beanListReviews= beanListReviews; 
	}

	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;


    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="nomeUtente"
    private Label nomeUtente; // Value injected by FXMLLoader

    @FXML // fx:id="tabellaNotifiche"
    private TableView<BeanReview> tabellaNotifiche; // Value injected by FXMLLoader
    
    @FXML
	private TableColumn<BeanReview, String> votoColonna;

    @FXML // fx:id="turistaColonna"
    private TableColumn<BeanReview,String> turistaColonna; // Value injected by FXMLLoader

    @FXML // fx:id="ristoranteColonna"
    private TableColumn<BeanReview,String> ristoranteColonna; // Value injected by FXMLLoader

    @FXML // fx:id="contenutoColonna"
    private TableColumn<BeanReview,String> contenutoColonna; // Value injected by FXMLLoader

    @FXML // fx:id="continueButton"
    private Button continueButton; // Value injected by FXMLLoader

   

    @FXML
    void goToHome() throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/HomePageOwnerView.fxml"));
    	
   	   //setto il nuovo controller grafico
   	   loader.setControllerFactory(c -> new ControllerGuiHomePageOwner(bs));
   	   Parent rootParent = loader.load();    	
     	
     	//cambio scena
     	myAnchorPane.getChildren().setAll(rootParent);
    }

   

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
       
        assert tabellaNotifiche != null : "fx:id=\"tabellaNotifiche\" was not injected: check your FXML file 'NotificationsRestaurantViewScheduling.fxml'.";
        assert turistaColonna != null : "fx:id=\"turistaColonna\" was not injected: check your FXML file 'NotificationsRestaurantViewScheduling.fxml'.";
        assert ristoranteColonna != null : "fx:id=\"ristoranteColonna\" was not injected: check your FXML file 'NotificationsRestaurantViewScheduling.fxml'.";
        assert votoColonna != null : "fx:id=\"votoColonna\" was not injected: check your FXML file 'NotificationsRestaurantViewScheduling.fxml'.";
        assert contenutoColonna != null : "fx:id=\"contenutoColonna\" was not injected: check your FXML file 'NotificationsRestaurantViewScheduling.fxml'.";
        assert continueButton != null : "fx:id=\"continueButton\" was not injected: check your FXML file 'NotificationsRestaurantViewScheduling.fxml'.";
        assert myAnchorPane != null : "fx:id=\"myAnchorPane\" was not injected: check your FXML file 'NotificationsRestaurantViewScheduling.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'NotificationsRestaurantViewScheduling.fxml'.";
        assert manageMenuButton != null : "fx:id=\"manageMenuButton\" was not injected: check your FXML file 'NotificationsRestaurantViewScheduling.fxml'.";
        assert sponsorRestaurantButton != null : "fx:id=\"sponsorRestaurantButton\" was not injected: check your FXML file 'NotificationsRestaurantViewScheduling.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'NotificationsRestaurantViewScheduling.fxml'.";
        assert nomeUtente != null : "fx:id=\"nomeUtente\" was not injected: check your FXML file 'NotificationsRestaurantViewScheduling.fxml'.";
        
        nomeUtente.setText(bs.getUser().getUsername());
        turistaColonna.setCellValueFactory(new PropertyValueFactory<>("tourist"));
        ristoranteColonna.setCellValueFactory(new PropertyValueFactory<>("restaurant"));
        contenutoColonna.setCellValueFactory(new PropertyValueFactory<>("content"));
        votoColonna.setCellValueFactory(new PropertyValueFactory<>("voto"));
        BeanReview beanReview;
        
        ObservableList<BeanReview> observableList = FXCollections.observableArrayList();
        for(int i = 0; i<beanListReviews.getContents().size();i++) {
        	beanReview = new BeanReview(beanListReviews.getTourists().get(i), beanListReviews.getRestaurants().get(i), beanListReviews.getContents().get(i), beanListReviews.getVotes().get(i));
        	observableList.add(beanReview);        	
        }
        
        tabellaNotifiche.setItems(observableList);
    }
}
