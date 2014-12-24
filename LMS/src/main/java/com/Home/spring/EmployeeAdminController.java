package com.Home.spring;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;















import java.util.Map;

import javax.annotation.Nullable;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;






import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Home.Employee;
import com.Home.applicationRelated.ApplicationRelatedBeans;
import com.json.restClient.JerseyClient;
import com.json.serviceClasses.ListOfRetrievedEmployees;
import com.json.serviceClasses.RetrievedEmployee;
import com.rest.contents.EmployeeClient;
import com.sun.jersey.spi.dispatch.RequestDispatcher;
@Controller
public class EmployeeAdminController {
	/*@RequestMapping("/EmployeeAdditionController")
	public String addEmployee(HttpServletRequest request, HttpServletResponse response,ModelMap model) throws IOException 
	{
		String baseURL=request.getRequestURL().toString().replaceAll(request.getContextPath()+request.getServletPath(), "/");
		System.out.println(baseURL);
		SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
		Date joiningDate=null;
		String addEmployeeSuccessState=null;
		String empID = request.getParameter("EmpID");
	    String username = request.getParameter("Username");
	    String password = request.getParameter("Password");
	    String designation =request.getParameter("Designation");
	    if(request.getParameter("JoiningDate")!=null && request.getParameter("JoiningDate")!="")
		{
	    	joiningDate =	Date.valueOf(simpleDateFormat.format(Date.valueOf(request.getParameter("JoiningDate"))));
		}
		String companyEmailID = request.getParameter("CompanyEmailID");
	    String firstName =request.getParameter("FirstName");
	    String lastName =request.getParameter("LastName");
	    String managerID=request.getParameter("ManagerID");
	    System.out.println(empID+username+password+designation+joiningDate+companyEmailID+managerID+firstName+lastName);
	    try {
	    	 //addEmployeeSuccessState=EmployeeClient.createEmployee(baseURL, empID,  username,  password,  designation,  joiningDate,  companyEmailID,  managerID,  firstName,  lastName );
	    	addEmployeeSuccessState=JerseyClient.createEmployee(baseURL, empID, username, password, designation, joiningDate, companyEmailID, managerID, firstName, lastName);
	    } catch (DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    if(addEmployeeSuccessState.equals(null))
	    {
	    	addEmployeeSuccessState="some problem while adding";
	    	
	    }
	    
	    model.addAttribute("AddEmployeeSuccessState", addEmployeeSuccessState);

	    
	    return "addEmployeePage";
	    	     
	}*/
	/*@RequestMapping("/EmployeeUpdationController")
	
	
	public String updateEmployee(HttpServletRequest request, HttpServletResponse response,ModelMap model) throws IOException 
	{String baseURL=request.getRequestURL().toString().replaceAll(request.getContextPath()+request.getServletPath(), "/");
	String updateEmployeeSuccessState=null;
	String employeeID =  request.getParameter("EmpID");
    String password = request.getParameter("Password");
    String designation =request.getParameter("Designation");
    String managerID=request.getParameter("ManagerID");
    try {
    	 updateEmployeeSuccessState=JerseyClient.updateEmployee(baseURL,employeeID, password, designation, managerID);
	} catch (DatatypeConfigurationException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (JAXBException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    if(updateEmployeeSuccessState.equals(null))
    {
    	updateEmployeeSuccessState="some problem while updating";
    	
    }
    else
    {
    	updateEmployeeSuccessState="Employee successfully updated";
    }
    	
	model.addAttribute("UpdateEmployeeSuccessState", updateEmployeeSuccessState);
 		 

		return "updateEmployeePage";
	}*/
	/*@RequestMapping("/EmployeeRetrievalController" )
	
	public String retrieveEmployee(HttpServletRequest request, HttpServletResponse response,ModelMap model) throws IOException
	{
		
		// TODO Auto-generated method stub
		List<Employee> listofemployees=new ArrayList<Employee>();
		ApplicationRelatedBeans applicationRelatedBeans=new ApplicationRelatedBeans();
			String restJSONWebServiceURL=applicationRelatedBeans.getRestJSONWebServiceURL();
			System.out.println(restJSONWebServiceURL);
			//RetrievedEmployeesList retrievedEmployeesList=new RetrievedEmployeesList();
			ListOfRetrievedEmployees listOfRetrievedEmployees=new ListOfRetrievedEmployees();
			List<RetrievedEmployee> listOfEmployees=null;
			SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
			String pageToBeDispatchedTo=null;
			Date joiningDate=null;
			String retrieveEmployeeSuccessState=null;
			String empID =null;
			String username=null;
			String password=null;
			String designation=null;
			String companyEmailID=null;
			String managerID=null;
			String firstName=null;
			String lastName=null;				 
				 
					if(request.getParameter("EmpID")!=null && request.getParameter("EmpID")!="")
					{
						empID =request.getParameter("EmpID");
					}
					if(request.getParameter("Username")!=null && request.getParameter("Username")!="")
					{
						username =	request.getParameter("Username");
					}
					if(request.getParameter("Password")!=null && request.getParameter("Password")!="")
					{
						password =	request.getParameter("Password");
					}
					if(request.getParameter("Designation")!=null && request.getParameter("Designation")!="")
					{
						 designation =  request.getParameter("Designation");
					}
					if(request.getParameter("JoiningDate")!=null && request.getParameter("JoiningDate")!="")
					{
						joiningDate =	Date.valueOf(simpleDateFormat.format(Date.valueOf(request.getParameter("JoiningDate"))));
						
					}
					if(request.getParameter("CompanyEmailID")!=null && request.getParameter("CompanyEmailID")!="")
					{
						companyEmailID =	request.getParameter("CompanyEmailID");
					}
					if(request.getParameter("ManagerID")!=null && request.getParameter("ManagerID")!="")
					{
						managerID =	request.getParameter("ManagerID");
					}
					if(request.getParameter("FirstName")!=null && request.getParameter("FirstName")!="")
					{
						firstName =	request.getParameter("FirstName");
					}
					if(request.getParameter("LastName")!=null && request.getParameter("LastName")!="")
					{
						lastName =	request.getParameter("LastName");
					}		
			try {
				listOfRetrievedEmployees=JerseyClient.retrieveEmployee(restJSONWebServiceURL,empID, username, password, designation, joiningDate, companyEmailID, managerID, firstName, lastName);
			} catch (DatatypeConfigurationException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			} catch (JAXBException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}try
			{
				//listOfEmployees=JaxbClient.GetListOfRetrievedEmployees(retrievedEmployeesList);
				listOfEmployees=listOfRetrievedEmployees.getListOfRetrievedEmployees();
			}catch(NullPointerException e)
			{
				System.out.println(e.getMessage());
				
			}
			
				
				
			if(listOfEmployees==null)
		    {
		    	retrieveEmployeeSuccessState="No such Employee found";
		    	pageToBeDispatchedTo="retrieveEmployeePage";
		    	model.addAttribute("RetrieveEmployeeSuccessState", retrieveEmployeeSuccessState);
			}
		    else
		    	
		    {	
		    	for(RetrievedEmployee retrievedEmployee:listOfEmployees)
				{
		    		Employee employee=new Employee(retrievedEmployee.getEmpID(), retrievedEmployee.getUsername(), retrievedEmployee.getPassword(), retrievedEmployee.getDesignation(), retrievedEmployee.getJoiningDate(), retrievedEmployee.getCompanyEmailID(), retrievedEmployee.getManagerID(), retrievedEmployee.getFirstName(), retrievedEmployee.getLastName());

					System.out.println(retrievedEmployee.getEmpID()+retrievedEmployee.getFirstName());
					
				}
		    	request.setAttribute("ListOfEmployees",listOfEmployees );
		    	pageToBeDispatchedTo="retrieveEmployeePage";
		    	model.addAttribute("ListOfEmployees", listofemployees);
		    }
			ModelMap modelMap=new ModelMap();
			modelMap.addAttribute("ListOfEmployees", listofemployees);
			return "retrieveEmployeePage";
					
			
		    
	}*/
	
	

	
	
	/*	@RequestMapping("/EmployeeDeletionController")
	public String deleteEmployee(HttpServletRequest request, HttpServletResponse response,ModelMap model) throws IOException
	{
		
		// TODO Auto-generated method stub
		String baseURL=request.getRequestURL().toString().replaceAll(request.getContextPath()+request.getServletPath(), "/");
		String deleteEmployeeSuccessState=null;
		Date joiningDate=null;
		SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
		String empID =	request.getParameter("EmpID");
		String username =	request.getParameter("Username");
		String designation =  request.getParameter("Designation");
		if(request.getParameter("JoiningDate")!=null && request.getParameter("JoiningDate")!="")
		{
			joiningDate =	Date.valueOf(simpleDateFormat.format(Date.valueOf(request.getParameter("JoiningDate"))));
		}
		String companyEmailID =	request.getParameter("CompanyEmailID");
		String managerID =	request.getParameter("ManagerID");
		String firstName =	request.getParameter("FirstName");
		String lastName =	request.getParameter("LastName");
		try {
			deleteEmployeeSuccessState=EmployeeClient.deleteEmployee(baseURL,empID, username, designation, joiningDate, companyEmailID, managerID, firstName, lastName);
		} catch (DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(deleteEmployeeSuccessState.equals(null))
	    {
			deleteEmployeeSuccessState="some problem while deleting";
	    }
		else
		{
			System.out.println(deleteEmployeeSuccessState);
			deleteEmployeeSuccessState="Employee deleted";
		}
		
	    	
	    	model.addAttribute("DeleteEmployeeSuccessState", deleteEmployeeSuccessState);
			
	    	String pageToBeDispatchedTo="deleteEmployeePage";
	    	

		return pageToBeDispatchedTo;
		
		    
	}*/		
		
		@RequestMapping("/EmployeeAdditionJSON")
		protected @ResponseBody Map<String, String> addEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			System.out.println(request.getParameter("Username")+request.getParameter("Password"));
			System.out.println("In EmployeeAdditionController");
			Map<String, String> mapResponse=new HashMap<String, String>();
			ApplicationRelatedBeans applicationRelatedBeans=new ApplicationRelatedBeans();
			String restJSONWebServiceURL=applicationRelatedBeans.getRestJSONWebServiceURL();
			System.out.println(restJSONWebServiceURL);
			SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
			String joiningDate=null;
			String addEmployeeSuccessState=null;
			String empID = request.getParameter("EmpID");
		    String username = request.getParameter("Username");
		    String password = request.getParameter("Password");
		    String designation =request.getParameter("Designation");
		    if(request.getParameter("JoiningDate")!=null && request.getParameter("JoiningDate")!="")
			{
		    	joiningDate =request.getParameter("JoiningDate");
			}
			String companyEmailID = request.getParameter("CompanyEmailID");
		    String firstName =request.getParameter("FirstName");
		    String lastName =request.getParameter("LastName");
		    String managerID=request.getParameter("ManagerID");
		    System.out.println(empID+username+password+designation+joiningDate+companyEmailID+managerID+firstName+lastName);
		    try {
		    	 //addEmployeeSuccessState=EmployeeClient.createEmployee(baseURL, empID,  username,  password,  designation,  joiningDate,  companyEmailID,  managerID,  firstName,  lastName );
		    	
		    	addEmployeeSuccessState=JerseyClient.createEmployee(restJSONWebServiceURL, empID, username, password, designation, joiningDate, companyEmailID, managerID, firstName, lastName);
		    } catch (DatatypeConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (JAXBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    if(addEmployeeSuccessState.equals(null))
		    {
		    	addEmployeeSuccessState="some problem while adding";		    	
		    }
		    mapResponse.put("addEmployeeSuccessState", addEmployeeSuccessState);
		    System.out.println(addEmployeeSuccessState);
		    return mapResponse;		    	     
		}
		
		
		
		@RequestMapping("/EmployeeUpdationJSON")
		
		
		public @ResponseBody Map<String, String> updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException 
		{
			ApplicationRelatedBeans applicationRelatedBeans=new ApplicationRelatedBeans();
			String restJSONWebServiceURL=applicationRelatedBeans.getRestJSONWebServiceURL();
		String updateEmployeeSuccessState=null;
		Map<String, String> mapResponse=new HashMap<String, String>();
		String employeeID =  request.getParameter("EmpID");
	    String password = request.getParameter("Password");
	    String designation =request.getParameter("Designation");
	    String managerID=request.getParameter("ManagerID");
	    try {
	    	 updateEmployeeSuccessState=JerseyClient.updateEmployee(restJSONWebServiceURL,employeeID, password, designation, managerID);
		} catch (DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    if(updateEmployeeSuccessState.equals(null))
	    {
	    	updateEmployeeSuccessState="some problem while updating";
	    	
	    }
	    else
	    {
	    	updateEmployeeSuccessState="Employee successfully updated";
	    }
	    
	    mapResponse.put("updateEmployeeSuccessState", updateEmployeeSuccessState);
	    return mapResponse;
		}
		
		
		@RequestMapping("/EmployeeDeletionJSON")
		public @ResponseBody Map<String, String> deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException
		{
			
			// TODO Auto-generated method stub
			Map<String, String> mapResponse=new HashMap<String, String>();
			ApplicationRelatedBeans applicationRelatedBeans=new ApplicationRelatedBeans();
			String restJSONWebServiceURL=applicationRelatedBeans.getRestJSONWebServiceURL();
			String deleteEmployeeSuccessState=null;
			@Nullable
			Date joiningDate=null;
			SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
			String empID =	request.getParameter("EmpID");
			String username =	request.getParameter("Username");
			String designation =  request.getParameter("Designation");
			if(request.getParameter("JoiningDate")!=null && request.getParameter("JoiningDate")!="")
			{
				joiningDate =	Date.valueOf(simpleDateFormat.format(Date.valueOf(request.getParameter("JoiningDate"))));
			}
			String companyEmailID =	request.getParameter("CompanyEmailID");
			String managerID =	request.getParameter("ManagerID");
			String firstName =	request.getParameter("FirstName");
			String lastName =	request.getParameter("LastName");
			try {
				deleteEmployeeSuccessState=EmployeeClient.deleteEmployee(restJSONWebServiceURL,empID, username, designation, joiningDate, companyEmailID, managerID, firstName, lastName);
			} catch (DatatypeConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (JAXBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(deleteEmployeeSuccessState.equals(null))
		    {
				deleteEmployeeSuccessState="some problem while deleting";
		    }
			else
			{
				System.out.println(deleteEmployeeSuccessState);
				deleteEmployeeSuccessState="Employee deleted";
			}
			mapResponse.put("deleteEmployeeSuccessState", deleteEmployeeSuccessState);
			return mapResponse;			    
		}	
		
		@RequestMapping("/EmployeeRetrieveJSON")
		protected   @ResponseBody  List<RetrievedEmployee> EmployeeRetrieveJSON(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
			ApplicationRelatedBeans applicationRelatedBeans=new ApplicationRelatedBeans();
			String restJSONWebServiceURL=applicationRelatedBeans.getRestJSONWebServiceURL();
			System.out.println(restJSONWebServiceURL);
			List<RetrievedEmployee> listEmp=new ArrayList<RetrievedEmployee>();
			List<Employee> listOfEmployees=new ArrayList<Employee>();
			@Nullable
			String joiningDate=null;
			@Nullable
			String empID ;
			@Nullable
			String username;
			@Nullable
			String password;
			@Nullable
			String designation;
			@Nullable
			String companyEmailID;
			@Nullable
			String managerID;
			@Nullable
			String firstName;
			@Nullable
			String lastName;				 
			
			empID =request.getParameter("EmpID");			
			username =	request.getParameter("Username");		
			password =	request.getParameter("Password");		
			designation =  request.getParameter("Designation");
			if(request.getParameter("JoiningDate")!=null && request.getParameter("JoiningDate")!="")
			{		
				joiningDate =	request.getParameter("JoiningDate");
			}		
			companyEmailID =	request.getParameter("CompanyEmailID");		
			managerID =	request.getParameter("ManagerID");		
			firstName =	request.getParameter("FirstName");		
			lastName =	request.getParameter("LastName");
			
			try {
				listEmp=JerseyClient.retrieveEmployee(restJSONWebServiceURL,empID, username, password, designation, joiningDate, companyEmailID, managerID, firstName, lastName);
			} catch (DatatypeConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (JAXBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	/*try{
JaxbClient.MarshalRetrievedEmployeeList("D:/RetrievedEmployeesList.xml", retrievedEmployeesList);
}catch(Exception Exception){}*/

			/*for(RetrievedEmployee retrievedEmployee:listEmp)
			{
				Employee employee=new Employee(retrievedEmployee.getEmpID(), retrievedEmployee.getUsername(), retrievedEmployee.getPassword(), retrievedEmployee.getDesignation(), java.sql.Date.valueOf(simpleDateFormat.format(Date.valueOf( retrievedEmployee.getJoiningDate()))), retrievedEmployee.getCompanyEmailID(), retrievedEmployee.getManagerID(), retrievedEmployee.getFirstName(), retrievedEmployee.getLastName());

				System.out.println(retrievedEmployee.getEmpID()+ retrievedEmployee.getUsername()+ retrievedEmployee.getPassword()+ retrievedEmployee.getDesignation()+ java.sql.Date.valueOf(simpleDateFormat.format(Date.valueOf( retrievedEmployee.getJoiningDate())))+ retrievedEmployee.getCompanyEmailID()+ retrievedEmployee.getManagerID()+ retrievedEmployee.getFirstName()+ retrievedEmployee.getLastName());
				listOfEmployees.add(employee);
				System.out.println(employee.getEmpID()+ employee.getUsername());
			}*/
			return 	listEmp;	
			}		
}
