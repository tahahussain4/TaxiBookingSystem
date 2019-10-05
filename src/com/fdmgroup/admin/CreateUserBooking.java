package com.fdmgroup.admin;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.controller.BookingController;
import com.fdmgroup.controller.BookingManagementController;
import com.fdmgroup.model.Size;
import com.fdmgroup.model.User;
import com.fdmgroup.util.ExtractDateTime;

/**
 * Servlet implementation class createUserBooking
 */
@WebServlet("/createUserBooking")
public class CreateUserBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUserBooking() {
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
		BookingManagementController bookingController = new BookingManagementController();
//		
		String username= request.getParameter("username");
		LocalTime localTime = ExtractDateTime.getTime(request.getParameter("time"));
		LocalDate localDate = ExtractDateTime.getDate(request.getParameter("date"));
		Size size = Size.valueOf(request.getParameter("size"));
		String pickUpLocation= request.getParameter("pickUpAddress");
		String destination= request.getParameter("destination");
		boolean carPoolDecision= Boolean.getBoolean(request.getParameter("carpoolOption"));
		HttpSession session = request.getSession();
		
		String msg = bookingController.addBooking(username,localDate,localTime,size,pickUpLocation,destination,carPoolDecision);
		request.setAttribute("serverMsg", msg);
		
		RequestDispatcher rd = request.getRequestDispatcher("bookingManagement");
		rd.forward(request, response);
	}

}
