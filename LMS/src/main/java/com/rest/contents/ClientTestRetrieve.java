package com.rest.contents;



import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;


import com.jaxb.classes.JaxbClient;

import com.jaxb.retrieveEmployee.RetrieveEmployee;
import com.jaxb.retrievedEmployeesList.RetrievedEmployeesList;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientTestRetrieve {

	public static void main(String[] args) throws DatatypeConfigurationException, JAXBException {
		// TODO Auto-generated method stub
		
		Client client=Client.create();
		WebResource webResource=client.resource("http://localhost:8080/Tutorial/api/EmployeeWebservice/RetrieveEmployee");
		RetrieveEmployee retrieveEmployee=new RetrieveEmployee();
		
		retrieveEmployee.setDesignation("ASSOCIATE");
		
		ClientResponse response = webResource.accept(MediaType.APPLICATION_XML).put(ClientResponse.class,retrieveEmployee);
		RetrievedEmployeesList output= response.getEntity(RetrievedEmployeesList.class); 
		System.out.println(output.getRetrievedEmployees().get(0).getFirstName());
		JaxbClient.MarshalRetrievedEmployeeList("D:/RetrievedEmployeesList1.xml", output);
	   
		
		
	}

}
