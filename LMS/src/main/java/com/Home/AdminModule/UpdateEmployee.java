package com.Home.AdminModule;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;




import com.rest.contents.EmployeeClient;

/**
 * Servlet implementation class UpdateEmployee
 */
/**
 * @author Adarsha
 *
 */
@WebServlet(description = "UpdateEmployee", urlPatterns = { "/UpdateEmployee" })
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployee() {
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
		String baseURL=request.getRequestURL().toString().replaceAll(request.getContextPath()+request.getServletPath(), "/");
		String updateEmployeeSuccessState=null;
		String employeeID =  request.getParameter("EmpID");
	    String password = request.getParameter("Password");
	    String designation =request.getParameter("Designation");
	    String managerID=request.getParameter("ManagerID");
	    try {
	    	 updateEmployeeSuccessState=EmployeeClient.updateEmployee(baseURL,employeeID, password, designation, managerID);
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
	    	updateEmployeeSuccessState="Employee successfully updated";
	 	   	request.setAttribute("UpdateEmployeeSuccessState", updateEmployeeSuccessState);
	 		    
	 	    
	 	    	
	 	    RequestDispatcher requestDispatcher=request.getRequestDispatcher("UpdateEmployee.jsp");
	 	    requestDispatcher.forward(request, response);

}
}
