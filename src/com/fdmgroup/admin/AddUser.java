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
import com.fdmgroup.model.User;
import com.fdmgroup.util.ExtractDateTime;

/**
 * Servlet implementation class addUser
 */
@WebServlet("/addUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
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
		IUserDao userDao = new UserJPADao();
		IRoleDao roleDao = new RoleJPADao();
		HttpSession session = request.getSession();
		UserManagementController umc = new UserManagementController();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		Role role = new Role(request.getParameter("role"));
		LocalDate dateOfBirth = ExtractDateTime.getDate(request.getParameter("dateOfBirth"));
		String preferredPickupLocation = request.getParameter("preferredPickup");		
		
		
		umc.addUser(username, password, firstname, lastname, role, preferredPickupLocation, dateOfBirth); 
		
		request.setAttribute("serverMsg","Success");

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/userManagement.jsp");
		rd.forward(request, response);
	}

}
