package com.jaxb.test;

import javax.xml.bind.JAXBException;


import com.jaxb.classes.JaxbClient;
import com.jaxb.createEmployee.CreateEmployee;


public class CreateEmployeeMarshallerTest {

	public static void main(String args[]) throws JAXBException
	{
		CreateEmployee createEmployee=new CreateEmployee();
		createEmployee.setEmpID("E_123");
		createEmployee.setFirstName("Adarsha");
		createEmployee.setLastName("Shetty");
		createEmployee.setCompanyEmailID("ashet1@sapient.com");
		createEmployee.setDesignation("ASSOCIATE");		
		//createEmployee.setJoiningDate(XMLGregorianCalendarSerializer.createDate(1989, 8, 18, 5));
		createEmployee.setPassword("as23");
		createEmployee.setUsername("adrt2");
		JaxbClient.MarshalCreateEmployee("D:/EclipseWorkspace/Tutorial/CreateEmployee.xml", createEmployee);
	}
}
