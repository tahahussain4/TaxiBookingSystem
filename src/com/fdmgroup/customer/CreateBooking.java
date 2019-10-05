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
import com.fdmgroup.model.SessionUser;
import com.fdmgroup.model.Size;
import com.fdmgroup.model.User;
import com.fdmgroup.util.ExtractDateTime;

/**
 * Servlet implementation class createBooking
 */
@WebServlet("/createBooking")
public class CreateBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookingController bookingController = new BookingController();
//		
		LocalTime localTime = ExtractDateTime.getTime(request.getParameter("time"));
		LocalDate localDate = ExtractDateTime.getDate(request.getParameter("date"));
		Size size = Size.valueOf(request.getParameter("size"));
		String pickUpLocation= request.getParameter("pickUpAddress");
		String destination= request.getParameter("destination");
		boolean carPoolDecision= Boolean.getBoolean(request.getParameter("carpoolOption"));
		HttpSession session = request.getSession();
		
		String msg = bookingController.addNew((User)session.getAttribute("user"),localDate,localTime,size,pickUpLocation,destination,carPoolDecision);
		request.setAttribute("serverMsg", msg);
		
		RequestDispatcher rd = request.getRequestDispatcher("booking");
		rd.forward(request, response);
	}

}
