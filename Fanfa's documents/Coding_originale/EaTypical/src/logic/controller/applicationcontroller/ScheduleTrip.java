package logic.controller.applicationcontroller;

import logic.engineeringclasses.bean.scheduletrip.BeanCheckedRestaurantSchedule;

public class ScheduleTrip {

	private BeanCheckedRestaurantSchedule beanCheckedRestSched;
	
	public ScheduleTrip(BeanCheckedRestaurantSchedule bean) {
		this.beanCheckedRestSched=bean;
	}
	
	public void generateScheduling() {
		// Maybe this method has to return an array of beans.
	}
	
}
