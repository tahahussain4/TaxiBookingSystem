package com.fdmgroup.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.controller.CarManagementController;
import com.fdmgroup.controller.RoleManagementController;

/**
 * Servlet implementation class RemoveRole
 */
@WebServlet("/deleteRole")
public class DeleteRole extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRole() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoleManagementController rmc = new RoleManagementController();
		String roleIdStr = request.getParameter("roleId");
		
		if(roleIdStr != ""){
			int roleId = Integer.parseInt(roleIdStr);
			if(rmc.deleteRole(roleId)){
				request.setAttribute("successMsg", "Success");	
			}
			else{
				request.setAttribute("errorMsg", "Fail");	
			}
		}
		else{
			request.setAttribute("errorMsg", "Please fill out all the details");	
		}
	
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/roleManagement.jsp");
		rd.forward(request, response);
	}

}
