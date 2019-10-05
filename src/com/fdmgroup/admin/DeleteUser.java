package com.fdmgroup.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.controller.CarManagementController;
import com.fdmgroup.controller.UserManagementController;

/**
 * Servlet implementation class deleteUser
 */
@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUser() {
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
		UserManagementController um = new UserManagementController();
		String username = request.getParameter("username");
		
		if(username != ""){
			if(um.deleteUser(username)){
				request.setAttribute("successMsg", "Success");	
			}
			else{
				request.setAttribute("errorMsg", "Fail");	
			}
		}
		else{
			request.setAttribute("errorMsg", "Please fill out all the details");	
		}
	
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/userManagement.jsp");
		rd.forward(request, response);
	}

}
