package com.Home.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import com.Home.applicationRelated.ApplicationLogger;

public class LoginFilter implements Filter {
  public LoginFilter() {
        // TODO Auto-generated constructor stub
    }
public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("Hi In the filter");
		ApplicationLogger applicationLogger=new ApplicationLogger();
		applicationLogger.logInfo("Hi");
		 String url = ((HttpServletRequest) request).getServletPath();;
		 String queryString = ((HttpServletRequest)request).getQueryString();
		System.out.println(url + "?" + queryString);
		 String uri = ((HttpServletRequest) request).getRequestURI();
		 System.out.println(uri);
	        	System.out.println("Required URI");
	            if(url.matches(".*(Employee|.jsp).*")){
				if(((HttpServletRequest) request).getSession(false).getAttribute("username")!=null)
				{
					String user =(String) ((HttpServletRequest) request).getSession(false).getAttribute("username");
					String password=(String) ((HttpServletRequest) request).getSession(false).getAttribute("password");
					if(user.equals("admin"))
					{
						if(password.equals("admin"))
						{
							System.out.println("You are an admin");
						}
						else 
						{
							RequestDispatcher requestDispatcher=(RequestDispatcher)request.getRequestDispatcher("/");
							requestDispatcher.forward((HttpServletRequest) request,(HttpServletResponse) response);
						}
						
					}
					else 
					{
						RequestDispatcher requestDispatcher=(RequestDispatcher)request.getRequestDispatcher("/");
						requestDispatcher.forward((HttpServletRequest) request,(HttpServletResponse) response);
					}
				}
				else
				{
					System.out.println("Hi");
					RequestDispatcher requestDispatcher=(RequestDispatcher)request.getRequestDispatcher("/");
					System.out.println("Hi");
					requestDispatcher.forward((HttpServletRequest) request,(HttpServletResponse) response);
				}
								
				
	            }
		// pass the request along the filter chain
		
		/*if( ((HttpServletRequest) request).getSession(false)!=null)
		{
			System.out.println("Is not null");
			if(((HttpServletRequest) request).getSession(false).getAttribute("username")!=null)
			{
				String user =(String) ((HttpServletRequest) request).getSession(false).getAttribute("username");
				String password=(String) ((HttpServletRequest) request).getSession(false).getAttribute("password");
				if(user.equals("admin"))
				{
					if(password.equals("admin"))
					{
						System.out.println("You are an admin");
					}
					else 
					{
						RequestDispatcher requestDispatcher=(RequestDispatcher)request.getRequestDispatcher("/");
						requestDispatcher.forward((HttpServletRequest) request,(HttpServletResponse) response);
					}
					
				}
				else 
				{
					RequestDispatcher requestDispatcher=(RequestDispatcher)request.getRequestDispatcher("/");
					requestDispatcher.forward((HttpServletRequest) request,(HttpServletResponse) response);
				}
			}
			else
			{
				RequestDispatcher requestDispatcher=(RequestDispatcher)request.getRequestDispatcher("/");
				requestDispatcher.forward((HttpServletRequest) request,(HttpServletResponse) response);
			}
							
			
			
		}
		*/
	            
		
		chain.doFilter(request, response);
	}
public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
