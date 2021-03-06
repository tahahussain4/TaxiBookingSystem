package com.fdmgroup.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { "/day" }, 
		initParams = { 
				@WebInitParam(name = "username", value = "guest")
		})
public class ShowDayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowDayServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		if(day == 1 ){
			day = 7;
		}
		else{
			day --;
		}
		
		List<String> countries = new ArrayList<>();
		countries.add("Canada");
		countries.add("USA");
		countries.add("China");
		countries.add("Belgium");
		request.setAttribute("countries", countries);
		
		request.setAttribute("dayOfWeek", day);
		RequestDispatcher rd = request.getRequestDispatcher("showday.jsp");
		rd.forward(request, response);
	}
}
