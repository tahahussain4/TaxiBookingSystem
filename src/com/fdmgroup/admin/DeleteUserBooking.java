package com.fdmgroup.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.controller.BookingController;
import com.fdmgroup.controller.BookingManagementController;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class DeleteUserBooking
 */
@WebServlet("/deleteUserBooking")
public class DeleteUserBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserBooking() {
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
		int bookingId = Integer.parseInt(request.getParameter("bookingId"));
		HttpSession session = request.getSession();
		
		String msg= bookingController.deleteBooking((User)session.getAttribute("user"),bookingId);
		request.setAttribute("serverMsg", msg);
		
		RequestDispatcher rd = request.getRequestDispatcher("bookingManagement");
		rd.forward(request, response);
	}

}
