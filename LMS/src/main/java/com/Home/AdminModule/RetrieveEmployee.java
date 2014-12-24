package com.Home.AdminModule;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;








import org.springframework.web.bind.annotation.ResponseBody;

import com.Home.Employee;
import com.jaxb.classes.JaxbClient;
import com.jaxb.retrievedEmployeesList.RetrievedEmployeesList;
import com.rest.contents.EmployeeClient;

/**
 * Servlet implementation class RetrieveEmployee
 */
@WebServlet(description = "RetrieveEmployee", urlPatterns = { "/RetrieveEmployee" })
public class RetrieveEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String baseURL=request.getRequestURL().toString().replaceAll(request.getContextPath()+request.getServletPath(), "/");
		RetrievedEmployeesList retrievedEmployeesList=new RetrievedEmployeesList();
		List<Employee> listOfEmployees=null;
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
			retrievedEmployeesList=EmployeeClient.retrieveEmployee(baseURL,empID, username, password, designation, joiningDate, companyEmailID, managerID, firstName, lastName);
		} catch (DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	try{
		JaxbClient.MarshalRetrievedEmployeeList("D:/RetrievedEmployeesList.xml", retrievedEmployeesList);
		}catch(Exception Exception){}try
		{
			listOfEmployees=JaxbClient.GetListOfRetrievedEmployees(retrievedEmployeesList);
		}catch(Exception e)
		{
			
		}
	    if(listOfEmployees==null)
	    {
	    	retrieveEmployeeSuccessState="No such Employee found";
	    	pageToBeDispatchedTo="RetrieveEmployee.jsp";
		    request.setAttribute("RetrieveEmployeeSuccessState", retrieveEmployeeSuccessState);
		}
	    else
	    {
	    	pageToBeDispatchedTo="RetrievedEmployees.jsp";
	    	request.setAttribute("ListOfEmployees", listOfEmployees);
	    }	
	    RequestDispatcher requestDispatcher=request.getRequestDispatcher(pageToBeDispatchedTo);
	    requestDispatcher.forward(request, response);
	    
}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	    	deleteEmployeeSuccessState="Employee deleted";
	    	request.setAttribute("DeleteEmployeeSuccessState", deleteEmployeeSuccessState);
			
	    	String pageToBeDispatchedTo="DeleteEmployee.jsp";
	    	
	    RequestDispatcher requestDispatcher=request.getRequestDispatcher(pageToBeDispatchedTo);
	    requestDispatcher.forward(request, response);
		
	}
	
	

}
