package com.Home;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "LoginServlet", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("Username");
	    String password = request.getParameter("Password");
	    RequestDispatcher requestDispatcher=null;
	    if(username.equals("admin") && password.equals("admin"))
	    {

		    request.getSession().setAttribute("Username", username);
		    request.getSession().setAttribute("Password", password);
	    	requestDispatcher=request.getRequestDispatcher("AdminHomePage.jsp");
	    }
	    else
	    {
	    	requestDispatcher=request.getRequestDispatcher("ErrorInLogin.jsp");
	    }
	    	requestDispatcher.forward(request, response);
	    
	    
	}

}
