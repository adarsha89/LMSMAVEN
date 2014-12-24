package com.rest.contents;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.ws.rs.core.MediaType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


import com.jaxb.createEmployee.CreateEmployee;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientTest {

	public static void main(String[] args) throws DatatypeConfigurationException {
		// TODO Auto-generated method stub
		Client client=Client.create();
		WebResource webResource=client.resource("http://localhost:8080/api/EmployeeWebservice/CreateEmployee");
		CreateEmployee createEmployee=new CreateEmployee();
		createEmployee.setEmpID("M_542");
		createEmployee.setFirstName("Kdiledfyys");
		createEmployee.setCompanyEmailID("na2331@wq.com");
		createEmployee.setDesignation("ASSOCIATE");
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		createEmployee.setJoiningDate(date2);
		createEmployee.setUsername("ae34fr");
		createEmployee.setPassword("as");
		ClientResponse response = webResource.accept(MediaType.TEXT_PLAIN).put(ClientResponse.class,createEmployee);
		String output= response.getEntity(String.class); 
		
		System.out.println(response.getStatus());
	    System.out.println(output);
	}

}
