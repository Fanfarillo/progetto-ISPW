package logic.controller.guicontroller.ChooseRestaurant;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import logic.engineeringclasses.others.SizedStack;
import logic.controller.guicontroller.UserBaseGuiController;
import logic.engineeringclasses.others.Cities;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControllerGuiItalianViewCity extends UserBaseGuiController{
	
	ObservableList<String> list=FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane myAnchorPane;


    @FXML
    private Button searchButton;

    @FXML
    private Label nomeUtente;

    @FXML
    private ChoiceBox<String> choiceBox;


    @FXML
    private ImageView torino;

    @FXML
    private ImageView aosta;

    @FXML
    private ImageView genova;

    @FXML
    private ImageView milano;

    @FXML
    private ImageView trento;

    @FXML
    private ImageView trieste;

    @FXML
    private ImageView venezia;

    @FXML
    private ImageView bologna;

    @FXML
    private ImageView firenze;

    @FXML
    private ImageView ancona;

    @FXML
    private ImageView perugia;

    @FXML
    private ImageView roma;

    @FXML
    private ImageView laquila;

    @FXML
    private ImageView campobasso;

    @FXML
    private ImageView napoli;

    @FXML
    private ImageView bari;

    @FXML
    private ImageView potenza;

    @FXML
    private ImageView catanzaro;

    @FXML
    private ImageView palermo;

    @FXML
    private ImageView cagliari;

 

    @FXML
    void search(ActionEvent event) throws IOException {
    	System.out.print("Search\n");
    	SizedStack.getSizedStack().push("/logic/view/standalone/ChooseRestaurant/RestaurantView.fxml");
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/logic/view/standalone/ChooseRestaurant/RestaurantView.fxml"));
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

    @FXML
    void initialize() {
        assert myAnchorPane != null : "fx:id=\"myAnchorPane\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert searchButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert nomeUtente != null : "fx:id=\"nomeUtente\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
        assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'ItalianViewCity.fxml'.";
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
