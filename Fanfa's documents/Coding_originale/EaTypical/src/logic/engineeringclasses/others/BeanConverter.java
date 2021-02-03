package logic.engineeringclasses.others;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import logic.engineeringclasses.bean.scheduletrip.BeanOutputRestaurant;
import logic.engineeringclasses.bean.scheduletrip.BeanOutputSchedule;
import logic.engineeringclasses.bean.scheduletrip.ConvertedBeanSchedule;
import logic.model.Restaurant;
import logic.model.Scheduling;
import logic.model.Tourist;
import logic.model.User;

public class BeanConverter {

	public BeanOutputSchedule[] convertScheduling(User user) throws ParseException {
		
		Tourist tourist = (Tourist) user;
		List<Scheduling> tripList = tourist.getTrip();
		if(tripList.isEmpty()) return null;
		
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
		if(tripList.isEmpty()) return "";
		
		Iterator<Scheduling> iter = tripList.iterator();
		Scheduling schedEntity = iter.next();
		return schedEntity.getRest().getCity();
		
	}
	
    public ConvertedBeanSchedule[] convertDataType(BeanOutputSchedule[] scheduling, String city) {
    	ConvertedBeanSchedule[] convertedBeanSchedule = new ConvertedBeanSchedule[scheduling.length];

    	String[] dateAndHour;
    	String[] restInfo;
    	String strAvgPrice;
    	String strAvgVote;
    	
    	DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
    	
    	for(int i=0; i<scheduling.length; i++) {	
    		dateAndHour = new String[2];
    		dateAndHour[0] = df.format(scheduling[i].getDate());
    		
    		if(scheduling[i].isAtLunch()) dateAndHour[1]="Lunch";
    		else dateAndHour[1]="Dinner";
    		
    		restInfo = new String[4];
    		restInfo[0] = scheduling[i].getRest().getUsernameOwner();
    		restInfo[1] = scheduling[i].getRest().getName();
    		restInfo[2] = scheduling[i].getRest().getAddress();
    		restInfo[3] = city;
    		
    		strAvgPrice = Double.toString(scheduling[i].getRest().getAvgPrice());
    		strAvgVote = Double.toString(scheduling[i].getRest().getAvgVote());
    		
    		convertedBeanSchedule[i] = new ConvertedBeanSchedule(dateAndHour, restInfo, strAvgPrice, strAvgVote);    	
    		
    	}
    	return convertedBeanSchedule;
    }
    
    public ConvertedBeanSchedule[] emptyScheduling() {
    	ConvertedBeanSchedule[] convertedScheduling = new ConvertedBeanSchedule[1];
    	
    	String[] dateAndHour = new String[2];
    	for(int i=0; i<2; i++) {
    		dateAndHour[i] = "";
    	}
    	
    	String[] restInfo = new String[4];
    	restInfo[0]="";
    	restInfo[1]="There is no scheduling";
    	restInfo[2]="";
    	restInfo[3]="";
    	
    	convertedScheduling[0] = new ConvertedBeanSchedule(dateAndHour, restInfo, "", "");
    	return convertedScheduling;
    }
	
}
