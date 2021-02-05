package logic.engineeringclasses.bean.manageMenu;

import java.util.ArrayList;
import java.util.List;

import logic.model.Recipe;

public class BeanAdvice {
	
	List<Recipe> recipes;
	
	public BeanAdvice(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public List<String> getDishes() {
		List<String> dishes = new ArrayList<>();
		for(int i=0;i<recipes.size();i++) {
			dishes.add(recipes.get(i).getDishName());
		}
		return dishes;
	}
	
	public List<String> getPrices() {
		List<String> prices = new ArrayList<>();
		for(int i=0;i<recipes.size();i++) {
			prices.add(String.valueOf(recipes.get(i).getPrice()));
		}
		return prices;
	}

	public void setPiattiMancanti(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	
	
}
