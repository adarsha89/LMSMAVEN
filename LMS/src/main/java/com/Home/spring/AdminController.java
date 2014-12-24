package com.Home.spring;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	@RequestMapping("/EmployeeAddingController")
	public String addEmployee() 
	{
	
	    return "addEmployeePage";
	    	     
	}
	@RequestMapping("/EmployeeUpdatingController")
	public String updateEmployee() 
	{
	
	    return "updateEmployeePage";
	    	     
	}
	@RequestMapping("/EmployeeDeletingController")
	public String deleteEmployee() 
	{
	
	    return "deleteEmployeePage";
	    	     
	}
	@RequestMapping("/EmployeeRetrievingController")
	public String retrieveEmployee() 
	{
	
	    return "retrieveEmployeePage";
	    	     
	}
	
}
