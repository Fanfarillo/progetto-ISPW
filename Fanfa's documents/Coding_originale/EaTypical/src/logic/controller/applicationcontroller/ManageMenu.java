package logic.controller.applicationcontroller;

import logic.engineeringclasses.dao.RecipeDAO;
import logic.model.Recipe;

public class ManageMenu {

	
	public void addDish(String nomePiatto, String contenuto, String nomeRistorante,boolean vegano, boolean celiaco, double prezzo) throws ClassNotFoundException
	{
		//creo la entity recipe
		Recipe recipe = new Recipe(nomePiatto, contenuto, nomeRistorante, vegano, celiaco, prezzo);
		
		//richiedo la persistenza nel db
		//aggiungi la factory
		
		RecipeDAO recipeDAO = new RecipeDAO();
		recipeDAO.addDish(recipe);
		
		System.out.println("Scrittura eseguita");
		
	}
	
	public void modifyDishes(String contenuto, String ristorante, String nomePiatto, String username, double prezzo, boolean vegano, boolean celiaco) throws ClassNotFoundException
	{
		//istanzio una DAO per modificare tuple della tabella
		RecipeDAO recipeDAO = new RecipeDAO();
		
		recipeDAO.updateDishes(contenuto,ristorante,nomePiatto, username,prezzo, vegano,celiaco);
	}
	
	public void deleteDish(String nomePiatto, String nomeRistorante) throws ClassNotFoundException {
		
		//istanzio una DAO per eliminare la tupla richiesta dalla tabella
		RecipeDAO recipeDAO = new RecipeDAO();
		
		recipeDAO.deleteRecipe(nomeRistorante, nomePiatto);
	}
	
}
