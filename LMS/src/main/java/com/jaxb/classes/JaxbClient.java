package com.jaxb.classes;


import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;

import java.sql.Date;



import java.util.ArrayList;
import java.util.List;

import com.Home.Designation;
import com.Home.Employee;
import com.jaxb.createEmployee.*;
import com.jaxb.deleteEmployee.DeleteEmployee;
import com.jaxb.retrieveEmployee.RetrieveEmployee;
import com.jaxb.retrievedEmployee.RetrievedEmployee;
import com.jaxb.retrievedEmployeesList.RetrievedEmployeesList;
import com.jaxb.updateEmployee.*;

public class JaxbClient {
	public static void MarshalCreateEmployee(String pathofxmlfile,CreateEmployee createEmployee) throws JAXBException
	{
		//JAXBContext jAXBContext=JAXBContext.newInstance(com.jaxb.createEmployee.ObjectFactory.class);
		//Marshaller marshaller= jAXBContext.createMarshaller();		
		//marshaller.marshal(createEmployee, new File(pathofxmlfile));
	}
	public static CreateEmployee UnMarshalCreateEmployee(String pathname) throws JAXBException
	{
		JAXBContext jAXBContext=JAXBContext.newInstance(com.jaxb.createEmployee.ObjectFactory.class);
		Unmarshaller unmarshaller= jAXBContext.createUnmarshaller();	
		return (CreateEmployee)unmarshaller.unmarshal(new File(pathname));
	}
	public static void MarshalUpdateEmployee(String pathofxmlfile,UpdateEmployee updateEmployee) throws JAXBException
	{
		//JAXBContext jAXBContext=JAXBContext.newInstance(com.jaxb.updateEmployee.ObjectFactory.class);
		//Marshaller marshaller= jAXBContext.createMarshaller();		
		//marshaller.marshal(updateEmployee, new File(pathofxmlfile));
	}
	public static UpdateEmployee UnMarshalUpdateEmployee(String pathname) throws JAXBException
	{
		JAXBContext jAXBContext=JAXBContext.newInstance(com.jaxb.updateEmployee.ObjectFactory.class);
		Unmarshaller unmarshaller= jAXBContext.createUnmarshaller();	
		return (UpdateEmployee)unmarshaller.unmarshal(new File(pathname));
	}
	public static void MarshalRetrieveEmployee(String pathofxmlfile,RetrieveEmployee retrieveEmployee) throws JAXBException
	{
		//JAXBContext jAXBContext=JAXBContext.newInstance(com.jaxb.retrieveEmployee.ObjectFactory.class);
		//Marshaller marshaller= jAXBContext.createMarshaller();		
		//marshaller.marshal(retrieveEmployee, new File(pathofxmlfile));
	}
	public static RetrieveEmployee UnMarshalRetrieveEmployee(String pathname) throws JAXBException
	{
		JAXBContext jAXBContext=JAXBContext.newInstance(com.jaxb.retrieveEmployee.ObjectFactory.class);
		Unmarshaller unmarshaller= jAXBContext.createUnmarshaller();	
		return (RetrieveEmployee)unmarshaller.unmarshal(new File(pathname));
	}
	public static void MarshalDeleteEmployee(String pathofxmlfile,DeleteEmployee deleteEmployee) throws JAXBException
	{
		//JAXBContext jAXBContext=JAXBContext.newInstance(com.jaxb.deleteEmployee.ObjectFactory.class);
		//Marshaller marshaller= jAXBContext.createMarshaller();		
		//marshaller.marshal(deleteEmployee, new File(pathofxmlfile));
	}
	public static DeleteEmployee UnMarshalDeleteEmployee(String pathname) throws JAXBException
	{
		JAXBContext jAXBContext=JAXBContext.newInstance(com.jaxb.deleteEmployee.ObjectFactory.class);
		Unmarshaller unmarshaller= jAXBContext.createUnmarshaller();	
		return (DeleteEmployee)unmarshaller.unmarshal(new File(pathname));
	}
	public static RetrievedEmployeesList UnMarshalRetrievedEmployeeList(String pathname) throws JAXBException
	{
		JAXBContext jAXBContext=JAXBContext.newInstance(RetrievedEmployeesList.class);
		Unmarshaller unmarshaller= jAXBContext.createUnmarshaller();	
		return (RetrievedEmployeesList)unmarshaller.unmarshal(new File(pathname));
	}
	public static void MarshalRetrievedEmployeeList(String pathofxmlfile,RetrievedEmployeesList retrievedEmployeesList) throws JAXBException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(RetrievedEmployeesList.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	 
	    //jaxbMarshaller.marshal(retrievedEmployeesList,new File(pathofxmlfile));
	}public static RetrievedEmployee UnMarshalRetrievedEmployee(String pathname) throws JAXBException
	{
		JAXBContext jAXBContext=JAXBContext.newInstance(RetrievedEmployee.class);
		Unmarshaller unmarshaller= jAXBContext.createUnmarshaller();	
		return (RetrievedEmployee)unmarshaller.unmarshal(new File(pathname));
	}
	public static void MarshalRetrievedEmployee(String pathofxmlfile,RetrievedEmployee retrievedEmployee) throws JAXBException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(RetrievedEmployee.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	 
	   // jaxbMarshaller.marshal(retrievedEmployee,new File(pathofxmlfile));
	}
	
	
	public static List<Employee> GetListOfRetrievedEmployees(RetrievedEmployeesList retrievedEmployeesList)
	{
		Employee employee=null;
		List<Employee> listOfEmployees=new ArrayList<Employee>();
		List<RetrievedEmployee> listofRetrievedEmployees= retrievedEmployeesList.getRetrievedEmployees();
			for(RetrievedEmployee retrievedEmployee:listofRetrievedEmployees)
			{
				employee=Employee.getInstance();
				String empID=retrievedEmployee.getEmpID();
				String username=retrievedEmployee.getUsername();
				String password=retrievedEmployee.getPassword();
				String designationString=retrievedEmployee.getDesignation();
				System.out.println(retrievedEmployee.getDesignation());
				Designation designation=Designation.fromString(designationString);
				
				Date joiningDate=Date.valueOf(retrievedEmployee.getJoiningDate().getYear()+"-"+retrievedEmployee.getJoiningDate().getMonth()+"-"+retrievedEmployee.getJoiningDate().getDay());
				String companyEmailID=retrievedEmployee.getCompanyEmailID();
				String managerID=retrievedEmployee.getManagerID();
				String firstName=retrievedEmployee.getFirstName();
				String lastName=retrievedEmployee.getLastName();
	    		
				employee.setEmpID(empID);
				employee.getOfficialDetails().setUsername(username);
				employee.getOfficialDetails().setPassword(password);
				employee.getOfficialDetails().setPassword(password);
				employee.getOfficialDetails().setDesignation(designation);
				employee.getOfficialDetails().setJoiningDate(joiningDate);
				employee.getOfficialDetails().setManagerID(managerID);
				employee.getOfficialDetails().setCompanyEmailID(companyEmailID);
				employee.getPersonalDetails().setFirstName(firstName);
				employee.getPersonalDetails().setLastName(lastName);
				listOfEmployees.add(employee);
								
					
			}
			for(Employee emp:listOfEmployees)
			{
				System.out.println(emp.getEmpID()+emp.getOfficialDetails().getUsername());
			}
			return listOfEmployees;
	}
}

