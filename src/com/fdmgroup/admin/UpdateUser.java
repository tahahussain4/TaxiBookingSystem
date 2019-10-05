package com.fdmgroup.admin;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.controller.UserManagementController;
import com.fdmgroup.dao.IRoleDao;
import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.dao.RoleJPADao;
import com.fdmgroup.dao.UserJPADao;
import com.fdmgroup.model.Role;
import com.fdmgroup.util.ExtractDateTime;

/**
 * Servlet implementation class updateUser
 */
@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUserDao userDao = new UserJPADao();
		IRoleDao roleDao = new RoleJPADao();
		HttpSession session = request.getSession();
		UserManagementController umc = new UserManagementController();
		
		System.out.println(request.getParameter("userId"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String preferredPickupLocation = request.getParameter("preferredPickup");		
		
		if(username == ""){
			username = null;
		}
		if(password == ""){
			password = null;
		}
		if(firstname == ""){
			firstname = null;
		}
		if(lastname == ""){
			lastname = null;
		}
		
		if(preferredPickupLocation == ""){
			preferredPickupLocation = null;
		}
		
		if (umc.updateUser(userId,username, password, firstname, lastname, preferredPickupLocation, null)){
			request.setAttribute("successMsg","Success");
		}
		else {
			request.setAttribute("errorMsg","Fail,Please review the information");
		}
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/userManagement.jsp");
		rd.forward(request, response);
	}

}
