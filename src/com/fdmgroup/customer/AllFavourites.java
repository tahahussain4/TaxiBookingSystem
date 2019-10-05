package com.fdmgroup.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.controller.FavouriteController;
import com.fdmgroup.model.Booking;
import com.fdmgroup.model.Favourite;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class AllFavourites
 */
@WebServlet("/allFavourites")
public class AllFavourites extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllFavourites() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  = request.getSession();
		FavouriteController fc = new FavouriteController();
		String bookingIdStr = request.getParameter("bookingId");
		
		List<Favourite> favourites = fc.getAllUserFavourites((User)session.getAttribute("user"));
		if(favourites != null){
			request.setAttribute("allFavourites", favourites);
		}else{
			request.setAttribute("errorMsg", "Fail");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/favourite.jsp");
		rd.forward(request,response);
	}

}
