package logic.controller.applicationcontroller;

import logic.engineeringclasses.dao.RecipeDAO;
import logic.model.Recipe;

public class ManageMenu {

	
	public void addDish(String nomePiatto, String nomeRistorante, String contenuto, double prezzo, boolean vegano, boolean celiaco) throws ClassNotFoundException
	{
		//creo la entity recipe
		Recipe recipe = new Recipe(nomePiatto, contenuto, "Da Luca", vegano, celiaco, prezzo);
		
		//richiedo la persistenza nel db
		//aggiungi la factory
		
		RecipeDAO recipeDAO = new RecipeDAO();
		recipeDAO.addDish(recipe);
		
		System.out.println("Scrittura eseguita");
		
	}
	
}
