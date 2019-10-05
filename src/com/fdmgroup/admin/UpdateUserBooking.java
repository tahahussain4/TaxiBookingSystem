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
 * Servlet implementation class UpdateUserBooking
 */
@WebServlet("/updateUserBooking")
public class UpdateUserBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserBooking() {
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
		
		int bookingId = Integer.parseInt(request.getParameter("bookingId"));
		LocalTime localTime = null;
		LocalDate localDate = ExtractDateTime.getDate(request.getParameter("date"));
		String pickUpLocation= request.getParameter("pickUpAddress");
		String destination= request.getParameter("destination");
		Boolean carPoolDecision= null; 
		Boolean deleted = Boolean.valueOf(request.getParameter("deleted"));
		HttpSession session = request.getSession();
		Size size=null;
		
		String strSize = request.getParameter("size");
		if(strSize != "" && strSize != null){
			size = Size.valueOf(strSize);
		}
		
		if(request.getParameter("time") != null && request.getParameter("time") != ""){
			localTime = ExtractDateTime.getTime(request.getParameter("time"));
		}
		if(request.getParameter("date") != null && request.getParameter("date") != ""){
			localDate = ExtractDateTime.getDate(request.getParameter("date"));
		}
		
		
		String option = request.getParameter("carpoolOption");
		if(option != null){
			carPoolDecision = Boolean.valueOf(option);
		}
		
		if(pickUpLocation == ""){
			pickUpLocation = null;
		}
		
		if(destination == ""){
			destination =null;
		}
		
		String msg = bookingController.updateBooking((User)session.getAttribute("user"),bookingId,localDate,localTime,size,pickUpLocation,destination,carPoolDecision,deleted);
		request.setAttribute("serverMsg", msg);
		
		RequestDispatcher rd = request.getRequestDispatcher("bookingManagement");
		rd.forward(request, response);
	}

}
