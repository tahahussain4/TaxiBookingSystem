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

import com.fdmgroup.controller.TrackingController;
import com.fdmgroup.model.Booking;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class getAllBookings
 */
@WebServlet("/allBookings")
public class AllBookings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllBookings() {
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
		TrackingController tc = new TrackingController();
		List<Booking> bookings = tc.getAllUserBookings((User)session.getAttribute("user"));
		request.setAttribute("allBookings", bookings);          
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/tracking.jsp");
		rd.forward(request,response);
	}

}
