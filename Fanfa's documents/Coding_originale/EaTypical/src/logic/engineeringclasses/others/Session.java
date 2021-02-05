package logic.engineeringclasses.others;

import logic.model.User;

public class Session {

	private User user;
	private boolean isOwner;
	private boolean isWeb;
	private String firstPage;
	private String webHomeOwner="HomePageOwnerView.jsp";
	private String webHomeTourist="HomePageTouristView.jsp";
	private String homeTourist="/logic/view/standalone/HomePageTouristView.fxml";
	private String homeOwner="/logic/view/standalone/HomePageOwnerView.fxml";
	
	public boolean isOwner() {
		return isOwner;
	}

	public void setOwner(boolean isOwner) {
		this.isOwner = isOwner;
	}

	public Session(boolean isWeb) {
		this.user = null;
		this.isWeb=isWeb;
		if(isWeb)
			this.firstPage="HomePageTouristView.jsp";
		else
			this.firstPage="/logic/view/standalone/HomePageTouristView.fxml";
	}
	
	

	public String getFirstPage() {
		return firstPage;
	}


	public void setFirstPage(boolean isOwner)
	{
		if(this.isWeb&&isOwner)
		{
			this.firstPage=this.webHomeOwner;
		}
		else if(this.isWeb&&!isOwner)
		{
			this.firstPage=this.webHomeTourist;
		}
		else if(isOwner)
		{
			this.firstPage=this.homeOwner;
		}
		else
		{
			this.firstPage=this.homeTourist;
		}
			
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
