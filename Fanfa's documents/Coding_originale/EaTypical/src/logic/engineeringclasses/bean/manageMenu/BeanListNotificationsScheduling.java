package logic.engineeringclasses.bean.manageMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Luca Capotombolo
 *
 */
public class BeanListNotificationsScheduling {
	
	ArrayList<BeanSchedulingNotification> notifications = null;
	
	public BeanListNotificationsScheduling() {
		notifications = new ArrayList<>();
	}
	
	public List<BeanSchedulingNotification> getNotifications(){
		return notifications;
	}
}
