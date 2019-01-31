package com.amsproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginDirectpage")
public class LoginDirectpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginDirectpage() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkbutton = (String)request.getParameter("HealthCheck");
		PrintWriter out=response.getWriter();
		if(checkbutton.equalsIgnoreCase("Perform Health Check"))
		{
			String[] checklist = request.getParameterValues("applications");
			List<String> list =  Arrays.asList(checklist);
			System.out.println(list);
			HttpSession session=request.getSession();  
	        session.setAttribute("appl",list);
	        if(null == session.getAttribute("username"))
	        {
	        RequestDispatcher rd1=request.getRequestDispatcher("Healthchecklogin.jsp");
	    	rd1.forward(request, response);
	        }
	        else
	        {
	        	ServletContext context = this.getServletContext();
	        	RequestDispatcher dispatcher = context.getRequestDispatcher("/HealthReport");

	        	// change your request and response accordingly

	        	dispatcher.forward(request, response);
	        	//RequestDispatcher rd1 = request.getRequestDispatcher("Status.jsp");
	        	//rd1.forward(request, response);
	        }
			 
		}

	}
}
