package logic.controller.applicationcontroller;

import logic.engineeringclasses.bean.chooserestaurant.BeanNewReview;
import logic.engineeringclasses.dao.ReviewsDAO;
import logic.engineeringclasses.exceptions.GenericException;
import logic.model.Review;

public class WriteReview {
	
	public void write(BeanNewReview bnr) throws GenericException 
	{
		try {
		Review newReview=bnr.getReview();
		ReviewsDAO.insertReview(newReview);
		ReviewsDAO.updateAvgVote(newReview.getRestaurant());
		}
		catch(Exception e)
		{
			throw new GenericException("Please try again.");
		}
	}

}
