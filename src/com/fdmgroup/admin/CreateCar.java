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
 * Servlet implementation class createCar
 */
@WebServlet("/createCar")
public class CreateCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCar() {
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
		CarManagementController cm = new CarManagementController();
		String model = request.getParameter("model");
		Size size = Size.valueOf(request.getParameter("size"));
		String gearType = request.getParameter("gear");
		String occupancyStr = request.getParameter("occupancy");
		
		if(occupancyStr != "" && gearType != "" && model != ""){
			int peopleCapacity = Integer.parseInt(occupancyStr);
			if(cm.addCar(model, size, gearType, peopleCapacity)){
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
