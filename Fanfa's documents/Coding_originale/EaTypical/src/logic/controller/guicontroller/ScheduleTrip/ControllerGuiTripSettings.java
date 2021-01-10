/**
 * Sample Skeleton for 'TripSettingsView.fxml' Controller Class
 */

package logic.controller.guicontroller.ScheduleTrip;

import logic.controller.guicontroller.UserBaseGuiController;
import logic.engineeringclasses.others.SizedStack;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
//import javafx.scene.layout.AnchorPane;

public class ControllerGuiTripSettings extends UserBaseGuiController {
	ObservableList<String> list = FXCollections.observableArrayList();
	
	private String schedulingPage = "/logic/view/standalone/ScheduleTrip/SchedulingView.fxml";

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="firstDay"
    private ChoiceBox<String> firstDay; // Value injected by FXMLLoader

    @FXML // fx:id="firstMonth"
    private ChoiceBox<String> firstMonth; // Value injected by FXMLLoader

    @FXML // fx:id="firstYear"
    private ChoiceBox<String> firstYear; // Value injected by FXMLLoader

    @FXML // fx:id="radioLunch1"
    private RadioButton radioLunch1; // Value injected by FXMLLoader

    @FXML // fx:id="firstMeal"
    private ToggleGroup firstMeal; // Value injected by FXMLLoader

    @FXML // fx:id="radioDinner1"
    private RadioButton radioDinner1; // Value injected by FXMLLoader

    @FXML // fx:id="lastDay"
    private ChoiceBox<String> lastDay; // Value injected by FXMLLoader

    @FXML // fx:id="lastMonth"
    private ChoiceBox<String> lastMonth; // Value injected by FXMLLoader

    @FXML // fx:id="lastYear"
    private ChoiceBox<String> lastYear; // Value injected by FXMLLoader

    @FXML // fx:id="radioLunch2"
    private RadioButton radioLunch2; // Value injected by FXMLLoader

    @FXML // fx:id="lastMeal"
    private ToggleGroup lastMeal; // Value injected by FXMLLoader

    @FXML // fx:id="radioDinner2"
    private RadioButton radioDinner2; // Value injected by FXMLLoader

    @FXML // fx:id="veganCheckbox"
    private CheckBox veganCheckbox; // Value injected by FXMLLoader

    @FXML // fx:id="celiacCheckbox"
    private CheckBox celiacCheckbox; // Value injected by FXMLLoader

    @FXML // fx:id="textBudget"
    private TextField textBudget; // Value injected by FXMLLoader

    @FXML // fx:id="generateSchedulingButton"
    private Button generateSchedulingButton; // Value injected by FXMLLoader

    @FXML // fx:id="rangeQuality"
    private ChoiceBox<String> rangeQuality; // Value injected by FXMLLoader
    
    @FXML
    void goToSchedulingPage(ActionEvent event) throws IOException {
		SizedStack.getSizedStack().push(this.schedulingPage);
    	FXMLLoader loader=new FXMLLoader(getClass().getResource(this.schedulingPage));
    	Parent root=loader.load();
    	myAnchorPane.getChildren().setAll(root);    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert myAnchorPane != null : "fx:id=\"pane\" was not injected: check your FXML file 'TripSettingsView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'TripSettingsView.fxml'.";
        assert chooseRestaurantButton != null : "fx:id=\"chooseRestButton\" was not injected: check your FXML file 'TripSettingsView.fxml'.";
        assert scheduleTripButton != null : "fx:id=\"scheduleButton\" was not injected: check your FXML file 'TripSettingsView.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'TripSettingsView.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'TripSettingsView.fxml'.";
        assert firstDay != null : "fx:id=\"firstDay\" was not injected: check your FXML file 'TripSettingsView.fxml'.";
        assert firstMonth != null : "fx:id=\"firstMonth\" was not injected: check your FXML file 'TripSettingsView.fxml'.";
        assert firstYear != null : "fx:id=\"firstYear\" was not injected: check your FXML file 'TripSettingsView.fxml'.";
        assert radioLunch1 != null : "fx:id=\"radioLunch1\" was not injected: check your FXML file 'TripSettingsView.fxml'.";
        assert firstMeal != null : "fx:id=\"firstMeal\" was not injected: check your FXML file 'TripSettingsView.fxml'.";
        assert radioDinner1 != null : "fx:id=\"radioDinner1\" was not injected: check your FXML file 'TripSettingsView.fxml'.";
        assert lastDay != null : "fx:id=\"lastDay\" was not injected: check your FXML file 'TripSettingsView.fxml'.";
        assert lastMonth != null : "fx:id=\"lastMonth\" was not injected: check your FXML file 'TripSettingsView.fxml'.";
        assert lastYear != null : "fx:id=\"lastYear\" was not injected: check your FXML file 'TripSettingsView.fxml'.";
        assert radioLunch2 != null : "fx:id=\"radioLunch2\" was not injected: check your FXML file 'TripSettingsView.fxml'.";
        assert lastMeal != null : "fx:id=\"lastMeal\" was not injected: check your FXML file 'TripSettingsView.fxml'.";
        assert radioDinner2 != null : "fx:id=\"radioDinner2\" was not injected: check your FXML file 'TripSettingsView.fxml'.";
        assert veganCheckbox != null : "fx:id=\"veganCheckbox\" was not injected: check your FXML file 'TripSettingsView.fxml'.";
        assert celiacCheckbox != null : "fx:id=\"celiacCheckbox\" was not injected: check your FXML file 'TripSettingsView.fxml'.";
        assert textBudget != null : "fx:id=\"textBudget\" was not injected: check your FXML file 'TripSettingsView.fxml'.";
        assert generateSchedulingButton != null : "fx:id=\"generateSchedButton\" was not injected: check your FXML file 'TripSettingsView.fxml'.";
        assert rangeQuality != null : "fx:id=\"rangeQuality\" was not injected: check your FXML file 'TripSettingsView.fxml'.";

        loadDataDays();
        loadDataMonths();
        loadDataYears();
        loadDataQuality();
    }
    
    private void loadDataDays() {
//    	list.removeAll(list);
    	String one="1";
    	String two="2";
    	String three="3";
    	String four="4";
    	String five="5";
    	String six="6";
    	String seven="7";
    	String eight="8";
    	String nine="9";
    	String ten="10";
    	String eleven="11";
    	String twelve="12";
    	String thirteen="13";
    	String fourteen="14";
    	String fifteen="15";
    	String sixteen="16";
    	String seventeen="17";
    	String eighteen="18";
    	String nineteen="19";
    	String twenty="20";
    	String twentyone="21";
    	String twentytwo="22";
    	String twentythree="23";
    	String twentyfour="24";
    	String twentyfive="25";
    	String twentysix="26";
    	String twentyseven="27";
    	String twentyeight="28";
    	String twentynine="29";
    	String thirty="30";
    	String thirtyone="31";
    	list.addAll(one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve,thirteen,fourteen,fifteen,sixteen,seventeen,eighteen,nineteen,twenty,twentyone,twentytwo,twentythree,twentyfour,twentyfive,twentysix,twentyseven,twentyeight,twentynine,thirty,thirtyone);
    	firstDay.getItems().addAll(list);
    	lastDay.getItems().addAll(list);
    }
    
    private void loadDataMonths() {
    	list.removeAll(list);
    	String jan="January";
    	String feb="February";
    	String mar="March";
    	String apr="April";
    	String may="May";
    	String jun="June";
    	String jul="July";
    	String aug="August";
    	String sep="September";
    	String oct="October";
    	String nov="November";
    	String dec="December";
    	list.addAll(jan,feb,mar,apr,may,jun,jul,aug,sep,oct,nov,dec);
    	firstMonth.getItems().addAll(list);
    	lastMonth.getItems().addAll(list);
    }
    
    private void loadDataYears() {
    	list.removeAll(list);
    	String a="2021";
    	String b="2022";
    	String c="2023";
    	String d="2024";
    	String e="2025";
    	String f="2026";
    	String g="2027";
    	String h="2028";
    	String i="2029";
    	String j="2030";
    	list.addAll(a,b,c,d,e,f,g,h,i,j);
    	firstYear.getItems().addAll(list);
    	lastYear.getItems().addAll(list);
    }
    
    private void loadDataQuality() {
    	list.removeAll(list);
    	String one="1 star";
    	String two="2 stars";
    	String three="3 stars";
    	String four="4 stars";
    	String five="5 stars";
    	list.addAll(one,two,three,four,five);
    	rangeQuality.getItems().addAll(list);
    }
}
