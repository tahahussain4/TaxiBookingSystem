package com.fdmgroup.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.controller.CarManagementController;
import com.fdmgroup.model.Size;

/**
 * Servlet implementation class deleteCar
 */
@WebServlet("/deleteCar")
public class DeleteCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarManagementController cm = new CarManagementController();
		String carIdStr = request.getParameter("carId");
		
		if(carIdStr != ""){
			int carId = Integer.parseInt(carIdStr);
			if(cm.deleteCar(carId)){
				request.setAttribute("successMsg", "Success");	
			}
			else{
				request.setAttribute("errorMsg", "Fail");	
			}
		}
		else{
			request.setAttribute("errorMsg", "Please fill out all the details");	
		}
	
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/carManagement.jsp");
		rd.forward(request, response);
	}

}
