package logic.engineeringclasses.others;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import logic.engineeringclasses.bean.BeanFavRestaurant;
import logic.engineeringclasses.bean.BeanStringNotif;
import logic.engineeringclasses.bean.login.BeanLoggedUser;
import logic.engineeringclasses.bean.scheduletrip.BeanOutputRestaurant;
import logic.engineeringclasses.bean.scheduletrip.BeanOutputSchedule;
import logic.engineeringclasses.bean.scheduletrip.ConvertedBeanSchedule;
import logic.engineeringclasses.exceptions.GenericException;
import logic.model.Restaurant;
import logic.model.Scheduling;
import logic.model.TouristNotification;
public class BeanConverter {

	public BeanOutputSchedule[] convertScheduling(BeanLoggedUser user) throws ParseException {
		List<Scheduling> tripList = user.getTrip();
		if(tripList==null || tripList.isEmpty()) return new BeanOutputSchedule[0];
		
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
			
			beanRest = new BeanOutputRestaurant(null, rest.getName(), rest.getAddress(), rest.getCity(), rest.getMenu().getTotalPrice(), rest.getAvgVote(), rest.getOpeningHours());
			
			date = df.parse(schedEntity.getDate());
			beanSched = new BeanOutputSchedule(date, schedEntity.isAtLunch(), beanRest);
			
			tripArray[i] = beanSched;
			i++;			
		}
		
		return tripArray;
		
	}
	
	public String getCityFromScheduling(BeanLoggedUser user) {
		List<Scheduling> tripList = user.getTrip();
		if(tripList==null || tripList.isEmpty()) return "";
		
		Iterator<Scheduling> iter = tripList.iterator();
		Scheduling schedEntity = iter.next();
		return schedEntity.getRest().getCity();
		
	}
	
	public BeanFavRestaurant[] convertFavRestaurants(BeanLoggedUser user) {
		List<Restaurant> favRestList = user.getFavouriteRestaurants();
		if(favRestList==null || favRestList.isEmpty()) return new BeanFavRestaurant[0];
		
		BeanFavRestaurant[] favRestArray = new BeanFavRestaurant[favRestList.size()];
		Iterator<Restaurant> iter = favRestList.iterator();
		
		String strAvgVote;
		BeanFavRestaurant beanRest;
		
		int i=0;		// Counter for array index
		
		while(iter.hasNext()) {
			Restaurant rest = iter.next();
			strAvgVote = Double.toString(rest.getAvgVote());
			
			beanRest = new BeanFavRestaurant(rest.getName(), rest.getAddress(), rest.getCity(), strAvgVote);
			favRestArray[i] = beanRest;
			i++;
		}
		
		return favRestArray;
		
	}
	
	public BeanStringNotif[] convertNotif(BeanLoggedUser user) throws GenericException {
		List<TouristNotification> notifList = user.getNotifications();
		if(notifList==null || notifList.isEmpty()) return new BeanStringNotif[0];
		
		BeanStringNotif[] notifArray = new BeanStringNotif[notifList.size()];
		Iterator<TouristNotification> iter = notifList.iterator();
		
		BeanStringNotif beanNotif;
		
		String s1 = " has been ";
		String s2;
		String s3 = " menu of ";
		
		String typeModif;
		
		int i=0;		// Counter for array index
		
		while(iter.hasNext()) {
			TouristNotification notif = iter.next();
			
			typeModif = notif.getNotificationType();
			
			if(typeModif.equals("0")) s2="added into";
			else if(typeModif.equals("1")) s2 = "modified into";
			else if(typeModif.equals("2")) s2 = "deleted from";
			else throw new GenericException("An unknown error occurred. Please, try again later.");
			
			beanNotif = new BeanStringNotif(notif.getDish() + s1 + s2 + s3 + notif.getRestaurantName());
			
			notifArray[i]=beanNotif;
			i++;
		}
		
		return notifArray;
		
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
