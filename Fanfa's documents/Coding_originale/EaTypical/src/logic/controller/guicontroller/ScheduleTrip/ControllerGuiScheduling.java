/**
 * Sample Skeleton for 'SchedulingView.fxml' Controller Class
 */

package logic.controller.guicontroller.ScheduleTrip;

import logic.controller.applicationcontroller.ScheduleTrip;
import logic.controller.guicontroller.UserBaseGuiController;
import logic.engineeringclasses.bean.scheduletrip.BeanOutputSchedule;
import logic.engineeringclasses.bean.scheduletrip.ConvertedBeanSchedule;
import logic.engineeringclasses.others.SizedStack;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
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

public class ControllerGuiScheduling extends UserBaseGuiController {
	
	private ObservableList<ConvertedBeanSchedule> ol;
	private String schedulingPage = "/logic/view/standalone/ScheduleTrip/SchedulingView.fxml";
	private String tripSettingsPage = "/logic/view/standalone/ScheduleTrip/TripSettingsView.fxml";
	private String username;
	private String city;
	private BeanOutputSchedule[] scheduling;
	private ConvertedBeanSchedule[] convertedScheduling;
	private String errorMessage="";
	
	public ControllerGuiScheduling(String username, String city, BeanOutputSchedule[] scheduling) {
		this.username=username;
		this.city=city;
		this.scheduling=scheduling;
		this.convertedScheduling = convertDataType();
	}
	
	public ControllerGuiScheduling(String username, String city, BeanOutputSchedule[] scheduling, String errorMessage) {
		this.username=username;
		this.city=city;
		this.scheduling=scheduling;
		this.convertedScheduling = convertDataType();
		this.errorMessage=errorMessage;
	}

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="changeSettingsButton"
    private Button changeSettingsButton; // Value injected by FXMLLoader

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="tabella"
    private TableView<ConvertedBeanSchedule> tabella; // Value injected by FXMLLoader

    @FXML // fx:id="dateColumn"
    private TableColumn<ConvertedBeanSchedule, String> dateColumn; // Value injected by FXMLLoader

    @FXML // fx:id="hourColumn"
    private TableColumn<ConvertedBeanSchedule, String> hourColumn; // Value injected by FXMLLoader

    @FXML // fx:id="nameColumn"
    private TableColumn<ConvertedBeanSchedule, String> nameColumn; // Value injected by FXMLLoader

    @FXML // fx:id="addressColumn"
    private TableColumn<ConvertedBeanSchedule, String> addressColumn; // Value injected by FXMLLoader    

    @FXML // fx:id="avgPriceColumn"
    private TableColumn<ConvertedBeanSchedule, String> avgPriceColumn; // Value injected by FXMLLoader

    @FXML // fx:id="avgVoteColumn"
    private TableColumn<ConvertedBeanSchedule, String> avgVoteColumn; // Value injected by FXMLLoader

    @FXML // fx:id="generateNewSchedulingButton"
    private Button generateNewSchedulingButton; // Value injected by FXMLLoader

    @FXML // fx:id="saveSchedulingButton"
    private Button saveSchedulingButton; // Value injected by FXMLLoader
    
    @FXML // fx:id="cittaLabel"
    private Label cittaLabel; // Value injected by FXMLLoader

    @FXML // fx:id="errorLabel"
    private Label errorLabel; // Value injected by FXMLLoader

    @FXML
    void generateNewScheduling(ActionEvent event) throws IOException {
    	for(int i=0; i<this.scheduling.length; i++) {
    		this.scheduling[i].setRestFromList();
    	}    	
		SizedStack.getSizedStack().push(this.schedulingPage);
    	FXMLLoader loader=new FXMLLoader(getClass().getResource(this.schedulingPage));
    	loader.setControllerFactory(c -> new ControllerGuiScheduling(this.username, this.city, this.scheduling));
    	Parent root=loader.load();
    	myAnchorPane.getChildren().setAll(root);   
    }

    @FXML
    void goBackToTripSettingsPage(ActionEvent event) throws IOException {
		SizedStack.getSizedStack().push(this.tripSettingsPage);
    	FXMLLoader loader=new FXMLLoader(getClass().getResource(this.tripSettingsPage));
    	loader.setControllerFactory(c -> new ControllerGuiTripSettings(this.username, this.city));
    	Parent root=loader.load();
    	myAnchorPane.getChildren().setAll(root);   
    }

    @FXML
    void saveScheduling(ActionEvent event) throws IOException {
    	// To complete
    	try {
    	ScheduleTrip scheduleTrip = new ScheduleTrip();
    	scheduleTrip.saveScheduleTrip(this.convertedScheduling, this.username);
    	}
    	
    	catch(Exception e) {
    		FXMLLoader loader=new FXMLLoader(getClass().getResource(this.schedulingPage));
    		loader.setControllerFactory(c -> new ControllerGuiScheduling(this.username, this.city, this.scheduling, "An unknown error occurred. Please, try again later."));
    		Parent root=loader.load();
    		myAnchorPane.getChildren().setAll(root);
    	}
    	
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
        assert cittaLabel != null : "fx:id=\"cittaLabel\" was not injected: check your FXML file 'SchedulingView.fxml'.";
        assert errorLabel != null : "fx:id=\"errorLabel\" was not injected: check your FXML file 'SchedulingView.fxml'.";
        
        nomeUtenteLabel.setText(this.username);
        cittaLabel.setText(this.city);
        errorLabel.setText(this.errorMessage);
        
        ol = FXCollections.observableArrayList();
        for(int i=0; i<this.convertedScheduling.length; i++) {
        	ol.add(this.convertedScheduling[i]);
        }
        dateColumn.setCellValueFactory(new PropertyValueFactory<ConvertedBeanSchedule, String>("strDate"));
        hourColumn.setCellValueFactory(new PropertyValueFactory<ConvertedBeanSchedule, String>("strHour"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<ConvertedBeanSchedule, String>("name"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<ConvertedBeanSchedule, String>("address"));
        avgPriceColumn.setCellValueFactory(new PropertyValueFactory<ConvertedBeanSchedule, String>("strAvgPrice"));
        avgVoteColumn.setCellValueFactory(new PropertyValueFactory<ConvertedBeanSchedule, String>("strAvgVote"));
        
        tabella.setItems(ol);
    }
    
    private ConvertedBeanSchedule[] convertDataType() {
    	ConvertedBeanSchedule[] convertedScheduling = new ConvertedBeanSchedule[this.scheduling.length];

    	String[] dateAndHour;
    	String strAvgPrice;
    	String strAvgVote;
    	
    	DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
    	
    	for(int i=0; i<this.scheduling.length; i++) {	
    		dateAndHour = new String[2];
    		dateAndHour[0] = df.format(this.scheduling[i].getDate());
    		
    		if(this.scheduling[i].isAtLunch()) dateAndHour[1]="Lunch";
    		else dateAndHour[1]="Dinner";    		
    		
    		strAvgPrice = Double.toString(this.scheduling[i].getRest().getAvgPrice());
    		strAvgVote = Double.toString(this.scheduling[i].getRest().getAvgVote());
    		
    		convertedScheduling[i] = new ConvertedBeanSchedule(dateAndHour, this.scheduling[i].getRest().getName(), this.scheduling[i].getRest().getAddress(), this.city, strAvgPrice, strAvgVote);
    	}
    	return convertedScheduling;
    }
    
}
