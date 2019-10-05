package com.fdmgroup.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.controller.RoleManagementController;

/**
 * Servlet implementation class CreateRole
 */
@WebServlet("/createRole")
public class CreateRole extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateRole() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RoleManagementController rmc = new RoleManagementController();
		String role = request.getParameter("role");
		if(role != ""){
			if(rmc.addRole(role)){
				request.setAttribute("successMsg","Success");
			} else{
				request.setAttribute("errorMsg","Fail");
			}
		}
		else{
			request.setAttribute("errorMsg","Fail");
		}
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/roleManagement.jsp");
		rd.forward(request, response);
	}
}
