package logic.controller.guicontroller.Web;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletRestaurantMenuView extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String b1 = req.getParameter("delete");
		String b2 = req.getParameter("modify");
		String b3 = req.getParameter("add");
		String b4 = req.getParameter("advice");
		String b5 = req.getParameter("home");
		String b6 = req.getParameter("manageMenu");
		String b7 = req.getParameter("sponsorRestaurant");
		String b8 = req.getParameter("back");
		
		
		req.setAttribute("nome", "Matteo");
		
		
		
		if(b1!=null) {
			req.getRequestDispatcher("DeleteDishView.jsp").forward(req, resp);
			System.out.print("delete");
		}
		if(b2!=null) {
			req.getRequestDispatcher("ModifyDishView.jsp").forward(req, resp);
			System.out.print("modify");
		}
		if(b3!=null) {
			req.getRequestDispatcher("AddDishView.jsp").forward(req, resp);
			System.out.print("add");
		}
		if(b4!=null) {
			req.getRequestDispatcher("AdviceView.jsp").forward(req, resp);
			System.out.print("advice");
		}
		if(b5!=null) {
			req.getRequestDispatcher("HomePageOwner.jsp").forward(req, resp);
			System.out.print("home");
		}
		if(b6!=null) {
			req.getRequestDispatcher("RestaurantMenuview.jsp").forward(req, resp);
			System.out.print("manage");
		}
		if(b7!=null) {
			req.getRequestDispatcher("CreatingRestaurantView.jsp").forward(req, resp);
			System.out.print("sponsor");
		}
		if(b8!=null) {
			req.getRequestDispatcher("HomePageOwner.jsp").forward(req, resp);
			System.out.print("back");
		}
		
	}
	
}
