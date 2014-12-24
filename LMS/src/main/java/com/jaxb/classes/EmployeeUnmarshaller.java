package com.jaxb.classes;

import java.sql.Date;
import java.util.GregorianCalendar;


import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


import com.jaxb.createEmployee.CreateEmployee;
import com.jaxb.deleteEmployee.DeleteEmployee;
import com.jaxb.retrieveEmployee.RetrieveEmployee;
import com.jaxb.updateEmployee.UpdateEmployee;

public class EmployeeUnmarshaller {

	public  void createEmployee( ) throws DatatypeConfigurationException, JAXBException
	  
	{
		 
		CreateEmployee createEmployee=JaxbClient.UnMarshalCreateEmployee("D:/EclipseWorkspace/LMS/CreateEmployee.xml");
		
		//String managerID=
		//String firstName=createEmployee.getFirstName();
		//String lastName=
		
		
		createEmployee.getLastName();
		createEmployee.getCompanyEmailID();
				
		
		
		
	}
	public  void updateEmployee(String employeeID,String password,String designation,String managerID) throws DatatypeConfigurationException, JAXBException
	  
	{
		UpdateEmployee updateEmployee=new UpdateEmployee();
		updateEmployee.setEmpID(employeeID);
		updateEmployee.setDesignation(designation);		
		updateEmployee.setPassword(password);
		JaxbClient.MarshalUpdateEmployee("D:/EclipseWorkspace/LMS/UpdateEmployee.xml", updateEmployee);
	}
	public void retrieveEmployee(String empID,String username, String password, String designation, Date joiningDate, String companyEmailID, String managerID,String firstName, String lastName)  throws DatatypeConfigurationException, JAXBException
	  
	{
		RetrieveEmployee retrieveEmployee=new RetrieveEmployee();
		retrieveEmployee.setEmpID(empID);
		retrieveEmployee.setFirstName(firstName);
		retrieveEmployee.setLastName(lastName);
		retrieveEmployee.setCompanyEmailID(companyEmailID);
		retrieveEmployee.setDesignation(designation);		
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(joiningDate);
		XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		retrieveEmployee.setJoiningDate(date2);
		retrieveEmployee.setPassword(password);
		retrieveEmployee.setUsername(username);
		JaxbClient.MarshalRetrieveEmployee("D:/EclipseWorkspace/LMS/RetrieveEmployee.xml", retrieveEmployee);
	}
	public void deleteEmployee(String empID,String username, String designation, Date joiningDate, String companyEmailID, String managerID,String firstName, String lastName) throws DatatypeConfigurationException, JAXBException
	  
	{
		DeleteEmployee deleteEmployee=new DeleteEmployee();
		deleteEmployee.setEmpID(empID);
		deleteEmployee.setFirstName(firstName);
		deleteEmployee.setLastName(lastName);
		deleteEmployee.setCompanyEmailID(companyEmailID);
		deleteEmployee.setDesignation(designation);		
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(joiningDate);
		XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		deleteEmployee.setJoiningDate(date2);
		deleteEmployee.setUsername(username);
		JaxbClient.MarshalDeleteEmployee("D:/EclipseWorkspace/LMS/DeleteEmployee.xml", deleteEmployee);
	}
	
}
