package com.json.restClient;


import java.io.IOException;
import java.net.ConnectException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.Home.Employee;
import com.Home.applicationRelated.ApplicationRelatedBeans;
import com.jaxb.retrievedEmployeesList.RetrievedEmployeesList;
import com.json.serviceClasses.CreateEmployee;
import com.json.serviceClasses.DeleteEmployee;
import com.json.serviceClasses.ListOfRetrievedEmployees;
import com.json.serviceClasses.RetrieveEmployee;
import com.json.serviceClasses.RetrievedEmployee;
import com.json.serviceClasses.UpdateEmployee;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class JerseyClient {

 

    public static void main(String[] args)  {        	

         RestTemplate restTemplate = new RestTemplate();
 		 Employee response=restTemplate.getForObject("http://localhost:8080/Tutorial/print", Employee.class);
 		 System.out.println(response.getEmpID());
 		 
 		RetrieveEmployee retrieveEmployee=new RetrieveEmployee(null, null, null, null, null, null, null, null, null);
		
		restTemplate.postForObject("http://localhost:8080/Tutorial/getEmployees", retrieveEmployee,ListOfRetrievedEmployees.class);
	//	System.out.println(response1.getListOfRetrievedEmployees().toString());
         
 /*ListOfRetrievedEmployees list1=null;
        try {
        	
			 list1=JerseyClient.retrieveEmployee(null, null, null,null, null, null, null, null, null, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for(RetrievedEmployee retr: list1.getListOfRetrievedEmployees())
        {
        	System.out.println(retr.getFirstName());
        }*/
    }
    
    public  static List<RetrievedEmployee> retrieveEmployee(String restJSONWebServiceURL,String empID,String username, String password, String designation, String joiningDate, String companyEmailID, String managerID,String firstName, String lastName) throws IOException, DatatypeConfigurationException, JAXBException
	{
		RetrieveEmployee retrieveEmployee=new RetrieveEmployee(empID, username, password, designation, joiningDate, companyEmailID, managerID, firstName, lastName);
		RestTemplate restTemplate = new RestTemplate();
		ListOfRetrievedEmployees response=restTemplate.postForObject(restJSONWebServiceURL+"/getEmployees", retrieveEmployee,ListOfRetrievedEmployees.class);
		
        return response.getListOfRetrievedEmployees();
  }

    
    public static String createEmployee( String restJSONWebServiceURL,String empID,String  username,String password,String  designation,String  joiningDate,String  companyEmailID,String  managerID,String  firstName,String  lastName ) throws IOException, DatatypeConfigurationException, JAXBException
	{
    	CreateEmployee createEmployee=new CreateEmployee( empID, firstName, lastName, username,password, managerID, designation, companyEmailID, joiningDate);
        RestTemplate restTemplate = new RestTemplate();
		String response=restTemplate.postForObject(restJSONWebServiceURL+"/createEmployee", createEmployee,String.class);
		System.out.println(response);
        return response;
	}
    public static String updateEmployee(String restJSONWebServiceURL,String employeeID,String password,String designation,String managerID) throws IOException, DatatypeConfigurationException, JAXBException
	{
    	UpdateEmployee updateEmployee=new UpdateEmployee(employeeID, password, managerID, designation);
        RestTemplate restTemplate = new RestTemplate();
		String response=restTemplate.postForObject(restJSONWebServiceURL+"/updateEmployee", updateEmployee,String.class);
		System.out.println(response);
        return response;
	}
    
    
    public static String deleteEmployee( String restJSONWebServiceURL, String empID,String username, String designation, String joiningDate, String companyEmailID, String managerID,String firstName, String lastName) throws IOException, DatatypeConfigurationException, JAXBException
    	
	{
    	String password=null;
    	DeleteEmployee deleteEmployee=new DeleteEmployee(empID, username, password, designation, joiningDate, companyEmailID, managerID, firstName, lastName);
        RestTemplate restTemplate = new RestTemplate();
		String response=restTemplate.postForObject(restJSONWebServiceURL+"/deleteEmployee", deleteEmployee,String.class);
		System.out.println(response);
        return response;
	}

}

