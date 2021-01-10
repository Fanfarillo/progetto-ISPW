/**
 * Sample Skeleton for 'ItalianViewCity.fxml' Controller Class
 */

package logic.controller.guicontroller.ScheduleTrip;

import logic.controller.guicontroller.UserBaseGuiController;
import logic.engineeringclasses.others.Cities;
import logic.engineeringclasses.others.SizedStack;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
//import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControllerGuiItalianViewCity extends UserBaseGuiController {	
	ObservableList<String> list=FXCollections.observableArrayList();
	
	private String tripSettingsPage = "/logic/view/standalone/ScheduleTrip/TripSettingsView.fxml";

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="continueButton"
    private Button continueButton; // Value injected by FXMLLoader

    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="choiceBox"
    private ChoiceBox<String> choiceBox; // Value injected by FXMLLoader
    
    @FXML // fx:id="torino"
    private ImageView torino; // Value injected by FXMLLoader

    @FXML // fx:id="aosta"
    private ImageView aosta; // Value injected by FXMLLoader

    @FXML // fx:id="genova"
    private ImageView genova; // Value injected by FXMLLoader

    @FXML // fx:id="milano"
    private ImageView milano; // Value injected by FXMLLoader

    @FXML // fx:id="trento"
    private ImageView trento; // Value injected by FXMLLoader

    @FXML // fx:id="trieste"
    private ImageView trieste; // Value injected by FXMLLoader

    @FXML // fx:id="venezia"
    private ImageView venezia; // Value injected by FXMLLoader

    @FXML // fx:id="bologna"
    private ImageView bologna; // Value injected by FXMLLoader

    @FXML // fx:id="firenze"
    private ImageView firenze; // Value injected by FXMLLoader

    @FXML // fx:id="ancona"
    private ImageView ancona; // Value injected by FXMLLoader

    @FXML // fx:id="perugia"
    private ImageView perugia; // Value injected by FXMLLoader

    @FXML // fx:id="roma"
    private ImageView roma; // Value injected by FXMLLoader

    @FXML // fx:id="laquila"
    private ImageView laquila; // Value injected by FXMLLoader

    @FXML // fx:id="campobasso"
    private ImageView campobasso; // Value injected by FXMLLoader

    @FXML // fx:id="napoli"
    private ImageView napoli; // Value injected by FXMLLoader

    @FXML // fx:id="bari"
    private ImageView bari; // Value injected by FXMLLoader

    @FXML // fx:id="potenza"
    private ImageView potenza; // Value injected by FXMLLoader

    @FXML // fx:id="catanzaro"
    private ImageView catanzaro; // Value injected by FXMLLoader

    @FXML // fx:id="palermo"
    private ImageView palermo; // Value injected by FXMLLoader

    @FXML // fx:id="cagliari"
    private ImageView cagliari; // Value injected by FXMLLoader
    
    @FXML
    void goToTripSettingsPage(ActionEvent event) throws IOException { 	//The Trip Settings Page button onAction method
		SizedStack.getSizedStack().push(this.tripSettingsPage);
    	FXMLLoader loader=new FXMLLoader(getClass().getResource(this.tripSettingsPage));
    	Parent root=loader.load();
    	myAnchorPane.getChildren().setAll(root);
    }
    
    @FXML
    void selectCityChoiceBox(MouseEvent event) {
    	String imageId=((ImageView)event.getSource()).getId();
    	String selection;
    	if(imageId.equals("laquila"))
    	{
    		selection="L'Aquila";
    	}
    	else
    	{
    		selection=(imageId.substring(0, 1).toUpperCase() + imageId.substring(1));
    	}
    	choiceBox.getSelectionModel().select(selection);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert myAnchorPane != null : "fx:id=\"pane\" was not injected: check your FXML file 'TripSettingsView.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert scheduleTripButton != null : "fx:id=\"scheduleTripButton\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert chooseRestaurantButton != null : "fx:id=\"chooseRestaurantButton\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert continueButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtente\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert torino != null : "fx:id=\"torino\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert aosta != null : "fx:id=\"aosta\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert genova != null : "fx:id=\"genova\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert milano != null : "fx:id=\"milano\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert trento != null : "fx:id=\"trento\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert trieste != null : "fx:id=\"trieste\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert venezia != null : "fx:id=\"venezia\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert bologna != null : "fx:id=\"bologna\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert firenze != null : "fx:id=\"firenze\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert ancona != null : "fx:id=\"ancona\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert perugia != null : "fx:id=\"perugia\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert roma != null : "fx:id=\"roma\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert laquila != null : "fx:id=\"laquila\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert campobasso != null : "fx:id=\"campobasso\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert napoli != null : "fx:id=\"napoli\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert bari != null : "fx:id=\"bari\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert potenza != null : "fx:id=\"potenza\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert catanzaro != null : "fx:id=\"catanzaro\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert palermo != null : "fx:id=\"palermo\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert cagliari != null : "fx:id=\"cagliari\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        for(Cities city:Cities.values())
        {
        	list.add(city.nome);
        }
        choiceBox.setItems(this.list);

    }
}
