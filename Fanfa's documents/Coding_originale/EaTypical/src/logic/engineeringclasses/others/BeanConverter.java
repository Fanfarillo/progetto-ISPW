package logic.engineeringclasses.others;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import logic.engineeringclasses.bean.scheduletrip.BeanOutputRestaurant;
import logic.engineeringclasses.bean.scheduletrip.BeanOutputSchedule;
import logic.model.Restaurant;
import logic.model.Scheduling;
import logic.model.Tourist;
import logic.model.User;

public class BeanConverter {

	public BeanOutputSchedule[] convertScheduling(User user) throws ParseException {
		
		Tourist tourist = (Tourist) user;
		List<Scheduling> tripList = tourist.getTrip();
		if(tripList==null) return null;
		
		BeanOutputSchedule[] tripArray = new BeanOutputSchedule[tripList.size()];
		Iterator<Scheduling> iter = tripList.iterator();
		
		Date date;
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		BeanOutputRestaurant beanRest;
		BeanOutputSchedule beanSched;
		
		int i=0;		// Counter for array index
		
		while(iter.hasNext()) {
			Scheduling schedEntity = iter.next();
			Restaurant rest = schedEntity.getRest();
			beanRest = new BeanOutputRestaurant(rest.getOwner().getUsername(), rest.getName(), rest.getAddress(), rest.getCity(), rest.getMenu().getTotalPrice(), rest.getAvgVote(), rest.getOpeningHours());
			
			date = df.parse(schedEntity.getDate());
			beanSched = new BeanOutputSchedule(date, schedEntity.isAtLunch(), beanRest);
			
			tripArray[i] = beanSched;
			i++;			
		}
		
		return tripArray;
		
	}
	
	public String getCityFromScheduling(User user) {
		Tourist tourist = (Tourist) user;
		List<Scheduling> tripList = tourist.getTrip();
		if(tripList==null) return "";
		
		Iterator<Scheduling> iter = tripList.iterator();
		Scheduling schedEntity = iter.next();
		return schedEntity.getRest().getCity();
		
	}
	
}
