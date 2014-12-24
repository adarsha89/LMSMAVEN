package com.rest.contents;

import java.io.IOException;
import java.sql.Date;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;

import com.jaxb.classes.EmployeeMarshaller;
import com.jaxb.classes.JaxbClient;
import com.jaxb.createEmployee.CreateEmployee;
import com.jaxb.deleteEmployee.DeleteEmployee;
import com.jaxb.retrieveEmployee.RetrieveEmployee;
import com.jaxb.retrievedEmployeesList.RetrievedEmployeesList;
import com.jaxb.updateEmployee.UpdateEmployee;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class EmployeeClient {
	
	public static String createEmployee( String restXMLWebService,String empID,String  username,String password,String  designation,Date  joiningDate,String  companyEmailID,String  managerID,String  firstName,String  lastName ) throws IOException, DatatypeConfigurationException, JAXBException
	{
		Client client=Client.create();
		WebResource webResource=client.resource(restXMLWebService+"/CreateEmployee");
		CreateEmployee createEmployee=EmployeeMarshaller.createEmployee( empID,  username,  password, designation,    joiningDate,  companyEmailID,  managerID,  firstName,  lastName);
		ClientResponse response = webResource.accept(MediaType.TEXT_PLAIN).put(ClientResponse.class,createEmployee);
		String output= response.getEntity(String.class); 
	    return output;
	}
	
	public static String updateEmployee(String restXMLWebService,String employeeID,String password,String designation,String managerID) throws IOException, DatatypeConfigurationException, JAXBException
	{
		Client client=Client.create();
		WebResource webResource=client.resource(restXMLWebService+"/UpdateEmployee");
		UpdateEmployee updateEmployee=EmployeeMarshaller.updateEmployee(employeeID, password, designation, managerID);
		ClientResponse response = webResource.accept(MediaType.TEXT_PLAIN).put(ClientResponse.class,updateEmployee);
		String output= response.getEntity(String.class); 
	    return output;
	}
	
	public  static RetrievedEmployeesList retrieveEmployee(String restXMLWebService,String empID,String username, String password, String designation, Date joiningDate, String companyEmailID, String managerID,String firstName, String lastName) throws IOException, DatatypeConfigurationException, JAXBException
	{
		RetrieveEmployee retrieveEmployee=EmployeeMarshaller.retrieveEmployee(empID, username, password, designation, joiningDate, companyEmailID, managerID, firstName, lastName);
		
		Client client=Client.create();
		WebResource webResource=client.resource(restXMLWebService+"/RetrieveEmployee");
		
		
		ClientResponse response = webResource.accept(MediaType.APPLICATION_XML).put(ClientResponse.class,retrieveEmployee);
		RetrievedEmployeesList output= response.getEntity(RetrievedEmployeesList.class); 
		
		JaxbClient.MarshalRetrievedEmployeeList("D:/RetrievedEmployeesList1.xml", output);
		return output;
	}
	public  static String deleteEmployee( String restXMLWebService, String empID,String username, String designation, Date joiningDate, String companyEmailID, String managerID,String firstName, String lastName) throws IOException, DatatypeConfigurationException, JAXBException
	{
		Client client=Client.create();
		WebResource webResource=client.resource(restXMLWebService+"/DeleteEmployee");
		DeleteEmployee deleteEmployee=EmployeeMarshaller.deleteEmployee(empID, username, designation, joiningDate, companyEmailID, managerID, firstName, lastName);
		ClientResponse response = webResource.accept(MediaType.TEXT_PLAIN).put(ClientResponse.class,deleteEmployee);
		String output= response.getEntity(String.class); 
	    return output;
	}
	
}
