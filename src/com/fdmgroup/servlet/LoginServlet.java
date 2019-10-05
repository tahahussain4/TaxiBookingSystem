package com.fdmgroup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.controller.HomeController;
import com.fdmgroup.dao.IRoleDao;
import com.fdmgroup.dao.IUserDao;
import com.fdmgroup.dao.RoleJPADao;
import com.fdmgroup.dao.UserJPADao;
import com.fdmgroup.model.SessionUser;
import com.fdmgroup.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/home.jsp");
		rd.forward(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HomeController hc = HomeController.getInstance();
		IUserDao ud = new UserJPADao();
		IRoleDao roleDao = new RoleJPADao();
		HttpSession session;
		
		User foundUser = ud.findByUsername(username);
	
		if (foundUser != null && foundUser.getPassword().equals(password)){
			session = request.getSession();
			session.setAttribute("user", foundUser);
			session.setMaxInactiveInterval(1000);
			if(foundUser.getRole().getRoleType().equals("admin")){
				RequestDispatcher rd = request.getRequestDispatcher("bookingManagement");
				rd.forward(request, response);
			}

			else{
				RequestDispatcher rd = request.getRequestDispatcher("booking");
				rd.forward(request,response);
			}
		} else {
			request.setAttribute("errorMsg","Username/Password is wrong");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/home.jsp");
			rd.forward(request,response);
		}
	}
}
