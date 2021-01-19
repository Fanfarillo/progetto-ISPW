package logic.controller.applicationcontroller;

import logic.engineeringclasses.bean.manageMenu.BeanAddDish;
import logic.engineeringclasses.bean.manageMenu.BeanDeleteDish;
import logic.engineeringclasses.dao.RecipeDAO;
import logic.model.Recipe;

public class ManageMenu {

	
	public void addDish(BeanAddDish beanAddDish) throws ClassNotFoundException
	{
		//creo la entity recipe
		Recipe recipe = new Recipe(beanAddDish.getPiatto(), beanAddDish.getContenuto(), beanAddDish.getRistorante(), beanAddDish.isVegano(), beanAddDish.isCeliaco(), beanAddDish.getPrezzo());
		
		//richiedo la persistenza nel db
		//aggiungi la factory
		
		RecipeDAO recipeDAO = new RecipeDAO();
		recipeDAO.addDish(recipe);
		
		System.out.println("Scrittura eseguita");
		
	}
	
	public void modifyDishes(BeanAddDish beanAddDish) throws ClassNotFoundException
	{

		//CREA LA ENTITY !! --------------------------------------------------------------------------
		//istanzio una DAO per modificare tuple della tabella
		RecipeDAO recipeDAO = new RecipeDAO();
		
		recipeDAO.updateDishes(beanAddDish);
	}
	
	public void deleteDish(BeanDeleteDish beanDeleteDish) throws ClassNotFoundException {
		
		//istanzio una DAO per eliminare la tupla richiesta dalla tabella
		RecipeDAO recipeDAO = new RecipeDAO();
		
		recipeDAO.deleteRecipe(beanDeleteDish.getRistorante(), beanDeleteDish.getPiatto());
	}
	
}
