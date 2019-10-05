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
import com.fdmgroup.model.User;


/**
 * Servlet implementation class Booking
 */
@WebServlet("/booking")
public class Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Booking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrackingController tc = new TrackingController();
		HttpSession session = request.getSession();
		List<com.fdmgroup.model.Booking> bookings = tc.getAllUserBookings((User)session.getAttribute("user"));
		request.setAttribute("allBookings", bookings);          
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/booking.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
