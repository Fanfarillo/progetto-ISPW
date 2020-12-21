package logic.controller.guicontroller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class ControllerGuiItalianViewCity {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button homeButton;

    @FXML
    private Button scheduleTripButton;

    @FXML
    private Button chooseRestaurantButton;

    @FXML
    private Button searchButton;

    @FXML
    private Label nomeUtente;

    @FXML
    private ChoiceBox<?> choiceBox;

    @FXML
    private Button backButton;
    
    @FXML
    public void metodo(ActionEvent e) {
    	backButton.getText();
    }

    @FXML
    void initialize() {
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'ItalianCityView.fxml'.";
        assert scheduleTripButton != null : "fx:id=\"scheduleTripButton\" was not injected: check your FXML file 'ItalianCityView.fxml'.";
        assert chooseRestaurantButton != null : "fx:id=\"chooseRestaurantButton\" was not injected: check your FXML file 'ItalianCityView.fxml'.";
        assert searchButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file 'ItalianCityView.fxml'.";
        assert nomeUtente != null : "fx:id=\"nomeUtente\" was not injected: check your FXML file 'ItalianCityView.fxml'.";
        assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'ItalianCityView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'ItalianCityView.fxml'.";

    }
}
