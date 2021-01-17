package logic.controller.applicationcontroller;

//import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import logic.engineeringclasses.bean.scheduletrip.BeanCheckedRestaurantSchedule;
import logic.engineeringclasses.dao.FanfaAbstractDAO;
import logic.engineeringclasses.exceptions.NoResultException;
import logic.engineeringclasses.factory.Factory;
import logic.model.Restaurant;

public class ScheduleTrip {

	private BeanCheckedRestaurantSchedule beanCRS;
	
	public ScheduleTrip(BeanCheckedRestaurantSchedule bean) {
		this.beanCRS=bean;
	}
	
	public void generateScheduling() throws NoResultException, Exception {
		// Maybe this method has to return an array of bean
		
		Factory f = Factory.getFactory();
		FanfaAbstractDAO dao = f.createRestaurantDAO();
		List<Restaurant> listOfRestaurants = dao.select1(this.beanCRS.getCity(), this.beanCRS.isVegan(), this.beanCRS.isCeliac());
		
		//if(listOfRestaurants.isEmpty()) {
		//	NoResultException e = new NoResultException("No restaurant has been found.");
		//	throw e;
		//}
		
		//SimpleDateFormat sdf = new SimpleDateFormat("EE");
		//String firstDayOfWeek = sdf.format(this.beanCRS.getDate1());
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.beanCRS.getDate1());
		int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		int numDays=0;
		Date d;
		cal.setTime(this.beanCRS.getDate2());
		
		do {
			cal.add(Calendar.DATE, -1);
			d=cal.getTime();
			numDays++;
		} while(this.beanCRS.getDate1().compareTo(d)<=0);
		
		int numMeals;
		if(this.beanCRS.isAtLunch1() && !this.beanCRS.isAtLunch2()) {
			numMeals=2*numDays;
		}
		else if(!this.beanCRS.isAtLunch1() && this.beanCRS.isAtLunch2()) {
			numMeals=2*numDays-2;
		}
		else {
			numMeals=2*numDays-1;
		}
		
		// To check:
		
		boolean[][] requiredMealsWeek = new boolean[7][2];
		if(numMeals>=14) {
			for(int i=0; i<7; i++) {
				for(int j=0; j<2; j++) {
					requiredMealsWeek[i][j]=true;
				}
			}
		}
		else {
			for(int i=0; i<7; i++) {
				for(int j=0; j<2; j++) {
					requiredMealsWeek[i][j]=false;
				}
			}
			
		}	
		
	}
	
}
