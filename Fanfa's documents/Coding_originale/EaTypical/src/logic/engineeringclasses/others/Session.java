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
		int page=0;
		if(this.isWeb&&isOwner) page=1;
		if(this.isWeb&&!isOwner) page=2;
		if(!this.isWeb&&isOwner) page=3;
		if(!this.isWeb&&!isOwner) page=4;
		switch(page){
		case 1: this.firstPage=this.webHomeOwner; break;
		case 2: this.firstPage=this.webHomeTourist; break;
		case 3: this.firstPage=this.homeOwner; break;
		case 4: this.firstPage=this.homeTourist; break;
		default: break;}		
		setOwner(isOwner);
			
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
