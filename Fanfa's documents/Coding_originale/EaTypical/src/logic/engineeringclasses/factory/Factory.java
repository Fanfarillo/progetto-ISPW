package logic.engineeringclasses.factory;

import logic.engineeringclasses.dao.*;

public class Factory {
	
	private static Factory instance=null;
	
	protected Factory() {}
	
	public static synchronized Factory getFactory() {
		if(Factory.instance==null) {
			Factory.instance = new Factory();
		}
		return Factory.instance;
	}
	
	// Methods for DAOs creation
	public FanfaAbstractDAO createRestaurantDAO() {
		return new FanfaRestaurantDAO();
	}
	
}
