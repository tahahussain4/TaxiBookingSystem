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

/**
 * Servlet implementation class DeleteFavourite
 */
@WebServlet("/deleteFavourite")
public class DeleteFavourite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFavourite() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  = request.getSession();
		FavouriteController fc = new FavouriteController();
		String bookingIdStr = request.getParameter("bookingId");
		
		if(bookingIdStr != ""){
			if(fc.deleteFavourite(Integer.parseInt(bookingIdStr))){
				request.setAttribute("successMsg", "Success");
			} else {
				request.setAttribute("errorMsg", "Fail");
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("tracking");
		rd.forward(request,response);
	}

}
