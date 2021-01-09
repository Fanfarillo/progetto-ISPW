package logic.controller.applicationcontroller;

import logic.engineeringclasses.dao.RecipeDAO;
import logic.model.Recipe;

public class ManageMenu {

	
	public void addDish(String nomePiatto, String contenuto, String nomeRistorante,boolean vegano, boolean celiaco, double prezzo) throws ClassNotFoundException
	{
		//creo la entity recipe
		Recipe recipe = new Recipe(nomePiatto, contenuto, "Da Luca", vegano, celiaco, prezzo);
		
		//richiedo la persistenza nel db
		//aggiungi la factory
		
		RecipeDAO recipeDAO = new RecipeDAO();
		recipeDAO.addDish(recipe);
		
		System.out.println("Scrittura eseguita");
		
	}
	
	public void modifyDishes(String nomePiatto, String username, double prezzo, boolean vegano, boolean celiaco)
	{
		//istanzio una DAO per modificare tuple della tabella
		RecipeDAO recipeDAO = new RecipeDAO();
		
		//attenzione: i nomi dei ristoranti dell'utente li leggo dal database
		recipeDAO.updateDishes(nomePiatto,username);
	}
	
}
