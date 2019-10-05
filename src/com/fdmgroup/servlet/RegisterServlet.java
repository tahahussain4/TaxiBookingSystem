package com.fdmgroup.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.fdmgroup.dao.IRoleDao;
import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.dao.RoleJPADao;
import com.fdmgroup.dao.UserJPADao;
import com.fdmgroup.model.Role;
import com.fdmgroup.model.SessionUser;
import com.fdmgroup.model.User;
import com.fdmgroup.util.ExtractDateTime;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUserDao userDao = new UserJPADao();
		IRoleDao roleDao = new RoleJPADao();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		LocalDate dateOfBirth = ExtractDateTime.getDate(request.getParameter("dateOfBirth"));
		String preferredPickupLocation = request.getParameter("preferredPickup");
		Role role = roleDao.findByRoleType("customer");
		HttpSession session;
		System.out.println("HI");
		
		if(role == null){
			role = new Role("customer");
		}

		User u = new User(username, password, firstname, lastname, role,preferredPickupLocation,dateOfBirth);
		User createdUser = null;
		
		if(userDao.findByUsername(username) == null){
			createdUser = userDao.create(u);
		}
		
		if (createdUser != null){
			session = request.getSession();
			session.setAttribute("user", createdUser);
			session.setMaxInactiveInterval(300);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/welcomeCustomer.jsp");
			rd.forward(request, response);
		}
		else {
			session = request.getSession();
			session.setAttribute("errorMsg","Please review the information");
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
	}
}
