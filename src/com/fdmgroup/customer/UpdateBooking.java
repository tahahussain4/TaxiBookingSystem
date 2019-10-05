package com.fdmgroup.customer;

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
import com.fdmgroup.model.Size;
import com.fdmgroup.model.User;
import com.fdmgroup.util.ExtractDateTime;

/**
 * Servlet implementation class UpdateBooking
 */
@WebServlet("/updateBooking")
public class UpdateBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookingController bookingController = new BookingController();
//		
		
		int bookingId = Integer.parseInt(request.getParameter("bookingId"));
		LocalTime localTime = ExtractDateTime.getTime(request.getParameter("time"));
		LocalDate localDate = ExtractDateTime.getDate(request.getParameter("date"));
		String pickUpLocation= request.getParameter("pickUpAddress");
		String destination= request.getParameter("destination");
		Boolean carPoolDecision= null; 
		HttpSession session = request.getSession();
		Size size=null;
		
		String strSize = request.getParameter("size");
		if(strSize != "" && strSize != null){
			size = Size.valueOf(strSize);
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
		
		String msg = bookingController.changeBooking((User)session.getAttribute("user"),bookingId,localDate,localTime,size,pickUpLocation,destination,carPoolDecision,null);
		request.setAttribute("serverMsg", msg);
		
		RequestDispatcher rd = request.getRequestDispatcher("booking");
		rd.forward(request, response);
	}

}
