package logic.controller.applicationcontroller;

import java.util.ArrayList;

import logic.engineeringclasses.bean.manageMenu.BeanAdvice;
import logic.engineeringclasses.dao.RecipeDAO;
import logic.model.Recipe;

public class GetAdvice {

public BeanAdvice advice(String username) throws ClassNotFoundException {
		
		// istanzio la DAO affinchÃƒÂ¨ possa ottenere i piatti tipici che il ristorante non offre ai clienti
		RecipeDAO recipeDAO = new RecipeDAO();
		ArrayList<Recipe> dishesMinimumPrice = (ArrayList<Recipe>) recipeDAO.selectAllOtherRecipes(username);
		
		return new BeanAdvice(dishesMinimumPrice);
		
	}

}
