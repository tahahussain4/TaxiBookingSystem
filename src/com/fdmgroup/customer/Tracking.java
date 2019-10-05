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

import com.fdmgroup.controller.BookingController;
import com.fdmgroup.controller.FavouriteController;
import com.fdmgroup.controller.TrackingController;
import com.fdmgroup.dao.BookingJPADao;
import com.fdmgroup.dao.FavouriteJPADao;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class Tracking
 */
@WebServlet("/tracking")
public class Tracking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tracking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookingController bc= new BookingController();
		FavouriteJPADao fj = new FavouriteJPADao();
		BookingJPADao bj = new BookingJPADao();
		TrackingController tc = new TrackingController();

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		List<com.fdmgroup.model.Booking> allBookings = tc.getAllUserBookings((User)session.getAttribute("user"));
		List<com.fdmgroup.model.Booking> activeBookings = tc.getAllActiveBookings((User)session.getAttribute("user"));
		request.setAttribute("allUserBookings", allBookings);     
		request.setAttribute("allActiveBookings", activeBookings);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/tracking.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		doGet(request, response);
	}

}
