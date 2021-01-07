/**
 * Sample Skeleton for 'RestaurantMenuView.fxml' Controller Class
 */

package logic.controller.guicontroller.ManageMenuGuiController;

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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import logic.engineeringclasses.dao.RecipeDAO;
import logic.engineeringclasses.dao.RestaurantDAO;

public class ControllerGuiRestaurantMenuView  extends OwnerBaseGuiController{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;


    @FXML // fx:id="nomeUtenteLabel"
    private Label nomeUtenteLabel; // Value injected by FXMLLoader

    @FXML // fx:id="deleteDishButton"
    private Button deleteDishButton; // Value injected by FXMLLoader

    @FXML // fx:id="addADishButton"
    private Button addADishButton; // Value injected by FXMLLoader

    @FXML // fx:id="modifyADishButton"
    private Button modifyADishButton; // Value injected by FXMLLoader

    @FXML // fx:id="getAdviceButton"
    private Button getAdviceButton; // Value injected by FXMLLoader

    @FXML
    void addADish(ActionEvent event) throws IOException, ClassNotFoundException {
    	/*
    	ObservableList<String> obs = FXCollections.observableArrayList();
    	obs.addAll("luca","matteo","adrian");
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/AddDish.fxml"));
    	Parent rootParent = loader.load();
    	ControllerGuiAddDishView controllerGuiAddDishView = loader.getController();
    	ChoiceBox<String> choiceBox = controllerGuiAddDishView.getScegliPiattoBox();    	
    	choiceBox.setItems(obs);
    	*/
    	//obs1: contiene i cibi tipici
    	ObservableList<String> obs1 = FXCollections.observableArrayList();
    	
    	//obs2: contiene i nomi dei ristoranti dell'utente
    	//ObservableList<String> obs2 = FXCollections.observableArrayList();
    	
    	
    	RecipeDAO recipeDAO = new RecipeDAO();
    	obs1 = recipeDAO.selectRecipe("Luca");
    	System.out.print(obs1.toString());
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/AddDish.fxml"));
    	Parent rootParent = loader.load();
    	//ControllerGuiAddDishView controllerGuiAddDishView = new ControllerGuiAddDishView(obs1);
    	//ottengo il controller grafico
    	ControllerGuiAddDishView controllerGuiAddDishView = loader.getController();
    	  	
    	//loader.setController(controllerGuiAddDishView);
    	//carico tutte le ricette dei prodotti tipici per poterle mostrare
    	ChoiceBox<String> choiceBox = controllerGuiAddDishView.getScegliPiattoBox();  
    	choiceBox.setItems(obs1);
    	
    	//mi porto a presso l'informazione dello username
    	Label label = controllerGuiAddDishView.getLabel();
    	label.setText(nomeUtenteLabel.getText());
    	
    	//cambio scena
    	myAnchorPane.getChildren().setAll(rootParent);
    }

    @FXML
    void deleteADish(ActionEvent event) throws IOException, ClassNotFoundException {
    	ObservableList<String> obs1 = FXCollections.observableArrayList();
    	ObservableList<String> obs2 = FXCollections.observableArrayList();
    	RecipeDAO recipeDAO = new RecipeDAO();
    	obs1 = recipeDAO.selectOwnRecipe("U2");
    	RestaurantDAO restaurantDAO = new RestaurantDAO();
    	obs2 = restaurantDAO.selectOwnRecipe("U2");
    	
    	//FXMLLoader
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/DeleteDishView.fxml"));
    	Parent rootParent = loader.load();
    	
    	//ottengo il controller grafico
    	ControllerGuiDeleteDish controllerGuiDeleteDish = loader.getController();
    	  	
    	
    	//carico tutte le ricette dei prodotti tipici che i suoi ristoranti fanno
    	ChoiceBox<String> choiceBox1 = controllerGuiDeleteDish.getChoiceBoxDish();
    	choiceBox1.setItems(obs1);
    	
    	//carico tutti i ristoranti del proprietario
    	ChoiceBox<String> choiceBox2 = controllerGuiDeleteDish.getChoiceBoxRestaurant();
    	choiceBox2.setItems(obs2);
    	
    	//mi porto a presso l'informazione dello username
    	Label label = controllerGuiDeleteDish.getLabel();
    	label.setText(nomeUtenteLabel.getText());
    	
    	//cambio scena
    	myAnchorPane.getChildren().setAll(rootParent);
    }

    @FXML
    void getAdvice(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/AdviceView.fxml"));
    	Parent rootParent = loader.load();
    	myAnchorPane.getChildren().setAll(rootParent);
    }

    

   

    @FXML
    void modifyADish(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/view/standalone/ManageRestaurant/ModifyDishView.fxml"));
    	Parent rootParent = loader.load();
    	myAnchorPane.getChildren().setAll(rootParent);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert manageMenuButton != null : "fx:id=\"manageMenuButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert sponsorRestaurantButton != null : "fx:id=\"sponsorRestaurantButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert homeButton != null : "fx:id=\"homeButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert nomeUtenteLabel != null : "fx:id=\"nomeUtenteLabel\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert deleteDishButton != null : "fx:id=\"deleteDishButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert addADishButton != null : "fx:id=\"addADishButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert modifyADishButton != null : "fx:id=\"modifyADishButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        assert getAdviceButton != null : "fx:id=\"getAdviceButton\" was not injected: check your FXML file 'RestaurantMenuView.fxml'.";
        nomeUtenteLabel.setText("Luca Capotombolo");
    }
}
