package logic.engineeringclasses.factory;

import logic.engineeringclasses.dao.*;

public class Factory {
	
	private static Factory instance=null;
	
	protected Factory() {}
	
	public synchronized static Factory getFactory() {
		if(Factory.instance==null) {
			Factory.instance = new Factory();
		}
		return Factory.instance;
	}
	
	// Metodi per la creazione delle DAO
	public FanfaAbstractDAO createRestaurantDAO() {
		return new FanfaRestaurantDAO();
	}
	
}
