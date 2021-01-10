/**
 * Sample Skeleton for 'SchedulingView.fxml' Controller Class
 */

package logic.controller.guicontroller.ScheduleTrip;

import logic.controller.guicontroller.UserBaseGuiController;
import logic.engineeringclasses.others.SizedStack;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.control.cell.PropertyValueFactory;

public class ControllerGuiScheduling extends UserBaseGuiController {
	
//	private ObservableList<Data> ol;
	
	private String schedulingPage = "/logic/view/standalone/ScheduleTrip/SchedulingView.fxml";
	private String tripSettingsPage = "/logic/view/standalone/ScheduleTrip/TripSettingsView.fxml";

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="changeSettingsButton"
    private Button changeSettingsButton; // Value injected by FXMLLoader

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="tabella"
    private TableView<?> tabella; // Value injected by FXMLLoader

    @FXML // fx:id="dateColumn"
    private TableColumn<?, ?> dateColumn; // Value injected by FXMLLoader

    @FXML // fx:id="hourColumn"
    private TableColumn<?, ?> hourColumn; // Value injected by FXMLLoader

    @FXML // fx:id="nameColumn"
    private TableColumn<?, ?> nameColumn; // Value injected by FXMLLoader

    @FXML // fx:id="addressColumn"
    private TableColumn<?, ?> addressColumn; // Value injected by FXMLLoader

    @FXML // fx:id="generateNewSchedulingButton"
    private Button generateNewSchedulingButton; // Value injected by FXMLLoader

    @FXML // fx:id="saveSchedulingButton"
    private Button saveSchedulingButton; // Value injected by FXMLLoader

    @FXML
    void generateNewScheduling(ActionEvent event) throws IOException {
		SizedStack.getSizedStack().push(this.schedulingPage);
    	FXMLLoader loader=new FXMLLoader(getClass().getResource(this.schedulingPage));
    	Parent root=loader.load();
    	myAnchorPane.getChildren().setAll(root);   
    }

    @FXML
    void goBackToTripSettingsPage(ActionEvent event) throws IOException {
		SizedStack.getSizedStack().push(this.tripSettingsPage);
    	FXMLLoader loader=new FXMLLoader(getClass().getResource(this.tripSettingsPage));
    	Parent root=loader.load();
    	myAnchorPane.getChildren().setAll(root);   
    }

    @FXML
    void saveScheduling(ActionEvent event) {
    	System.out.println("To do: save scheduling.");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert changeSettingsButton != null : "fx:id=\"changeSettingsButton\" was not injected: check your FXML file 'SchedulingView.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'SchedulingView.fxml'.";
        assert tabella != null : "fx:id=\"tabella\" was not injected: check your FXML file 'SchedulingView.fxml'.";
        assert dateColumn != null : "fx:id=\"dateColumn\" was not injected: check your FXML file 'SchedulingView.fxml'.";
        assert hourColumn != null : "fx:id=\"hourColumn\" was not injected: check your FXML file 'SchedulingView.fxml'.";
        assert nameColumn != null : "fx:id=\"nameColumn\" was not injected: check your FXML file 'SchedulingView.fxml'.";
        assert addressColumn != null : "fx:id=\"addressColumn\" was not injected: check your FXML file 'SchedulingView.fxml'.";
        assert generateNewSchedulingButton != null : "fx:id=\"generateNewSchedulingButton\" was not injected: check your FXML file 'SchedulingView.fxml'.";
        assert saveSchedulingButton != null : "fx:id=\"saveSchedulingButton\" was not injected: check your FXML file 'SchedulingView.fxml'.";
        
//      ol = FXCollections.observableArrayList(new BeanRestaurant("stringaData","stringaOra","stringaRistorante","stringaIndirizzo"), BeanRestaurant("stringaData","stringaOra","stringaRistorante","stringaIndirizzo"));
//      dateColumn.setCellValueFactory(new PropertyValueFactory<BeanRestaurant,String>("stringaData"));
//      hourColumn.setCellValueFactory(new PropertyValueFactory<BeanRestaurant,String>("stringaOra"));
//      nameColumn.setCellValueFactory(new PropertyValueFactory<BeanRestaurant,String>("stringaRistorante"));
//      addressColumn.setCellValueFactory(new PropertyValueFactory<BeanRestaurant,String>("stringaIndirizzo"));
//      tabella.setItems(ol);

    }
}
