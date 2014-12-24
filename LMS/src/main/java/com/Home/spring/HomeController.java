package com.Home.spring;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

import com.Home.Employee;
import com.jaxb.classes.JaxbClient;
import com.jaxb.retrievedEmployeesList.RetrievedEmployeesList;
import com.rest.contents.EmployeeClient;



@Controller
public class HomeController {
	
	@RequestMapping(value={"/User"}, method = {RequestMethod.POST,RequestMethod.GET})
	public String printWelcome(ModelMap model, Principal principal,HttpServletRequest request,HttpServletResponse response) {
		String user=null;
		String password=null;
		if( request.getSession(false)!=null)
				{
					System.out.println("Is not null");
					if(request.getSession(false).getAttribute("username")!=null)
					{
						user = (String) request.getSession(false).getAttribute("username");
						password=(String) request.getSession(false).getAttribute("password");		
					}
					
					else
					{
						if(request.getParameter("username")!=null)
						{
							user = request.getParameter("username");
							password=request.getParameter("password");	
						}
								
					}
					if(user!=null)
					{
						System.out.println("Is not null");
						if(user.equals("admin"))
						{
							if(password.equals("admin"))
							{
								System.out.println("You are an admin");
								request.getSession(false).setAttribute("username",user);
								request.getSession(false).setAttribute("password",password);
								request.getSession(false).setAttribute("ROLE","admin");
								
								return "adminHomePage";
							}
							else 
							{
								return "errorPage";
							}
							
						}
						
						else 
						{
							RetrievedEmployeesList retrievedEmployeesList=new RetrievedEmployeesList();
							String baseURL=request.getRequestURL().toString().replaceAll(request.getContextPath()+request.getServletPath(), "/");
							try {
								retrievedEmployeesList=EmployeeClient.retrieveEmployee(baseURL,null, user, password, null, null, null, null, null, null);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (DatatypeConfigurationException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (JAXBException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
							List<Employee> listOfEmployees=null;
							try
							{
								listOfEmployees=JaxbClient.GetListOfRetrievedEmployees(retrievedEmployeesList);
							}catch(Exception e)
							{
								
							}
						    if(listOfEmployees!=null)
						    {
						    	request.getSession(false).setAttribute("username",user);
								request.getSession(false).setAttribute("password",password);
								request.getSession().setMaxInactiveInterval(5*60);
								request.getSession(false).setAttribute("ROLE","NORMAL_USER");
						    	return "userHomePage";
							}
						    else
						    {
						    	return "errorPage";
						    }	
							
							
						}
					}
					else
					{
						System.out.println("Is null");
						return "loginPage";
					}
					
					
				}
		else
		{
			System.out.println("Is null");
			return "loginPage";
		}

	
		
		
 
	}
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value={"/login","/"}, method = RequestMethod.GET)
	public String login(ModelMap model) {
		
		return "loginPage";
 
	}
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
 
		model.addAttribute("error", "true");
		return "errorPage";
 
	}
	
	@RequestMapping(value="/EmployeeLogout", method = RequestMethod.GET)
	public String logout(ModelMap model,HttpServletRequest request,HttpServletResponse response) {
		
		
		if(request.getSession(false).getAttribute("username")!=null)
		{
			request.getSession(false).setAttribute("username",null);
			request.getSession(false).setAttribute("password",null);	
			return "logoutPage";
		}
		else
		{
			
			return "loginPage";
		}
		
 
	}
}
