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

public class EmployeeMarshaller {

	public  static CreateEmployee createEmployee(String empID, String username, String password, String designation, Date joiningDate, String companyEmailID, String managerID, String firstName, String lastName ) throws DatatypeConfigurationException, JAXBException
	  
	{
		CreateEmployee createEmployee=new CreateEmployee();
		createEmployee.setEmpID(empID);
		createEmployee.setFirstName(firstName);
		createEmployee.setLastName(lastName);
		createEmployee.setCompanyEmailID(companyEmailID);
		createEmployee.setDesignation(designation);		
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(joiningDate);
		XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		createEmployee.setJoiningDate(date2);
		createEmployee.setPassword(password);
		createEmployee.setUsername(username);
		 return createEmployee;
	}
	public static UpdateEmployee updateEmployee(String employeeID,String password,String designation,String managerID) throws DatatypeConfigurationException, JAXBException
	  
	{
		
			UpdateEmployee updateEmployee=new UpdateEmployee();
		
			updateEmployee.setDesignation(designation);	
		
		
			updateEmployee.setEmpID(employeeID);
			
		
		
			updateEmployee.setPassword(password);
		
		
			
		
			return updateEmployee;
	}
	public static RetrieveEmployee retrieveEmployee(String empID,String username, String password, String designation, Date joiningDate, String companyEmailID, String managerID,String firstName, String lastName)  throws DatatypeConfigurationException, JAXBException
	  
	{	
		XMLGregorianCalendar date2=null;
		RetrieveEmployee retrieveEmployee=new RetrieveEmployee();
		retrieveEmployee.setEmpID(empID);
		retrieveEmployee.setFirstName(firstName);
		retrieveEmployee.setLastName(lastName);
		retrieveEmployee.setCompanyEmailID(companyEmailID);
		retrieveEmployee.setDesignation(designation);
		try
		{
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(joiningDate);
			 date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		}catch(NullPointerException e)	
		{
			System.out.println("Hi");
		}
			retrieveEmployee.setJoiningDate(date2);
		
		
		
		retrieveEmployee.setPassword(password);
		retrieveEmployee.setUsername(username);
		return retrieveEmployee;
	}
	public static DeleteEmployee deleteEmployee(String empID,String username, String designation, Date joiningDate, String companyEmailID, String managerID,String firstName, String lastName) throws DatatypeConfigurationException, JAXBException
	  
	{
		DeleteEmployee deleteEmployee=new DeleteEmployee();
		deleteEmployee.setEmpID(empID);
		deleteEmployee.setFirstName(firstName);
		deleteEmployee.setLastName(lastName);
		deleteEmployee.setCompanyEmailID(companyEmailID);
		deleteEmployee.setDesignation(designation);		
		try
		{
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(joiningDate);
			XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			deleteEmployee.setJoiningDate(date2);
		}catch(NullPointerException e)	
		{
			
		}
		deleteEmployee.setUsername(username);
		return deleteEmployee;
	}
	
}
