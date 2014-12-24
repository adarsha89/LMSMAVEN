package com.Home.AdminModule;


import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;








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
 * Servlet implementation class AddEmployee
 */
@WebServlet(description = "AddEmployee", urlPatterns = { "/AddEmployee" })
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployee() {
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
	    try {
	    	 addEmployeeSuccessState=EmployeeClient.createEmployee(baseURL, empID,  username,  password,  designation,  joiningDate,  companyEmailID,  managerID,  firstName,  lastName );
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
	    
	    
	    request.setAttribute("AddEmployeeSuccessState", addEmployeeSuccessState);
	    
	    RequestDispatcher requestDispatcher=request.getRequestDispatcher("/AddEmployee.jsp");
	    requestDispatcher.forward(request, response);
	    
	     
	}

}
