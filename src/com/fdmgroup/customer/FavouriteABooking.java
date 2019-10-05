package com.fdmgroup.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.controller.FavouriteController;
import com.fdmgroup.controller.TrackingController;
import com.fdmgroup.model.Booking;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class favouriteABooking
 */
@WebServlet("/favouriteABooking")
public class FavouriteABooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavouriteABooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  = request.getSession();
		FavouriteController fc = new FavouriteController();
		String bookingIdStr = request.getParameter("bookingId");
		User user = (User)session.getAttribute("user");
		if(bookingIdStr != ""){
			if(fc.addFavourite(user,Integer.parseInt(bookingIdStr))){
				request.setAttribute("successMsg", "Success");
			} else {
				request.setAttribute("errorMsg", "Fail");
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("tracking");
		rd.forward(request,response);
	}

}
