package logic.controller.applicationcontroller;

import java.util.ArrayList;

import logic.engineeringclasses.bean.manageMenu.BeanAdvice;
import logic.engineeringclasses.dao.RecipeDAO;
import logic.model.Recipe;

public class GetAdvice {

public BeanAdvice advice(String username) throws ClassNotFoundException {
		
		// istanzio la DAO affinchÃ¨ possa ottenere i piatti tipici che il ristorante non offre ai clienti
		RecipeDAO recipeDAO = new RecipeDAO();
		ArrayList<Recipe> piattiMancanti = (ArrayList<Recipe>) recipeDAO.selectNoRecipe(username);
		
		//impacchetto i piatti 'mancanti' all'interno di una Bean che verrÃ  passata al controller grafico chiamante
		
		/* ottengo i nomi delle varie ricette per poterle passare al controller grafico */
		ArrayList<String> recipes = new ArrayList<>();
		for(Recipe elem: piattiMancanti) {
			recipes.add(elem.getDishName());
		}
		return new BeanAdvice(recipes);
		
	}

}
