package test;
import org.junit.Test;

import logic.controller.applicationcontroller.ManageMenu;
import logic.engineeringclasses.bean.manageMenu.BeanDeleteDish;
import logic.engineeringclasses.bean.manageMenu.BeanDish;
import logic.engineeringclasses.exceptions.DishAlreadyExists;
import logic.engineeringclasses.exceptions.InvalidDishDelete;

import static org.junit.Assert.*;


public class TestManageMenu {

	/*
	 * All'interno del database già e' presente tale piatto
	 * il risultato dell'esecuzione di questo metodo mi generera' l'eccezione DishAlreadyDish
	 * in quanto non e' rispettato il vincolo di chiave
	 */
	@Test
	public void testAddDishDishAlreadyExists() throws ClassNotFoundException {
		ManageMenu manageMenu = new ManageMenu();
		int code;
		
		try {
			manageMenu.addDish(new BeanDish("carbonara", "da luca4", "ow", false, false, 10, 0));
			code = 0;
		}catch(DishAlreadyExists exists) {	//l'eccezione si verifica
			exists.printStackTrace();
			code = 1;
		}
		
		assertEquals(1, code);
	}
	
	/*
	 * All'interno del database non e' presente tale piatto
	 * il risultato dell'esecuzione di questo metodo mi aggiungerà
	 * all'interno del db un nuovo piatto
	 */
	@Test
	public void testAddDishNewDish() throws ClassNotFoundException {
		ManageMenu manageMenu = new ManageMenu();
		int code;
		
		try {
			manageMenu.addDish(new BeanDish("cacio e pepe", "da romeo", "ow", false, false, 10, 0));
			code = 0;
		}catch(DishAlreadyExists exists) {	//l'eccezione non si verifica
			exists.printStackTrace();
			code = 1;
		}
		
		assertEquals(0, code);
	}
	
	/*
	 * All'interno del database non e' presente la coppia ristorante-piatto inserita
	 * il risultato dell'esecuzione di questo metodo mi genererà una eccezione
	 * in quanto il piatto non può essere eliminato (non esiste)
	 */
	@Test
	public void testDeleteDishNotExists() throws ClassNotFoundException {
		ManageMenu manageMenu = new ManageMenu();
		int code;
		
		try {
			manageMenu.deleteDish(new BeanDeleteDish("da luca", "cicoria", 2));
			code = 0;
		}catch( InvalidDishDelete invalidDish) {	//l'eccezione si verifica
			invalidDish.printStackTrace();
			code = 1;
		}
		
		assertEquals(1, code);
	}
	
	/*
	 * All'interno del database e' presente la coppia ristorante-piatto 
	 * richiesta per l'eliminazione. Tale coppia verra' eliminata dal db
	 */
	@Test
	public void testDeleteDishExists() throws ClassNotFoundException {
		ManageMenu manageMenu = new ManageMenu();
		int code;
		
		try {
			manageMenu.deleteDish(new BeanDeleteDish("da luca3", "amatriciana", 2));
			code = 0;
		}catch( InvalidDishDelete invalidDish) {	//l'eccezione non si verifica
			invalidDish.printStackTrace();
			code = 1;
		}
		
		assertEquals(0, code);
	}
	
	
	
}
