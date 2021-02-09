package logic.controller.applicationcontroller;



import logic.engineeringclasses.bean.managerestaurant.BeanDeleteDish;
import logic.engineeringclasses.bean.managerestaurant.BeanDish;
import logic.engineeringclasses.dao.RecipeDAO;
import logic.engineeringclasses.exceptions.DishAlreadyExists;
import logic.engineeringclasses.exceptions.InvalidDishDelete;
import logic.engineeringclasses.exceptions.InvalidDishModify;
import logic.model.Recipe;


/**
 * 
 * @author Luca Capotombolo
 *
 */
public class ManageMenu {

	
	public void addDish(BeanDish beanAddDish) throws ClassNotFoundException, DishAlreadyExists
	{
		//creo la entity recipe
		Recipe recipe = new Recipe(beanAddDish.getDish(), beanAddDish.getContent(), beanAddDish.getRestaurant(), beanAddDish.isVegano(), beanAddDish.isCeliac(), beanAddDish.getPrice());
		
		//richiedo la persistenza nel db
		
		RecipeDAO recipeDAO = new RecipeDAO();
		recipeDAO.addDish(recipe);
		
	}
	
	public void modifyDishes(BeanDish beanModifyDish) throws ClassNotFoundException, InvalidDishModify
	{

		//CREA LA ENTITY !! --------------------------------------------------------------------------
		//istanzio una DAO per modificare tuple della tabella
		RecipeDAO recipeDAO = new RecipeDAO();
		Recipe recipe = new Recipe(beanModifyDish.getDish(),beanModifyDish.getContent(),beanModifyDish.getRestaurant(),beanModifyDish.isVegano(),beanModifyDish.isCeliac(),beanModifyDish.getPrice());
		
		recipeDAO.updateDishes(recipe);
	}
	
	public void deleteDish(BeanDeleteDish beanDeleteDish) throws ClassNotFoundException, InvalidDishDelete {
		
		//istanzio una DAO per eliminare la tupla richiesta dalla tabella
		RecipeDAO recipeDAO = new RecipeDAO();
		
		recipeDAO.deleteRecipe(beanDeleteDish.getRestaurant(), beanDeleteDish.getDish());
	}
	
	
	
}
