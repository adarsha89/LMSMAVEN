package com.rest.contents;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class EmployeeXMLSender
 */
@WebServlet("/CreateEmployeeXMLSender")
public class CreateEmployeeXMLSender extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateEmployeeXMLSender() {
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
		StringBuilder xmlContentBuilder= new StringBuilder();
		BufferedReader in = new BufferedReader(new FileReader("D:/EclipseWorkspace/Tutorial/CreateEmployee.xml"));  
        String str=null;
    	while( ( str = in.readLine() ) != null ) 
    	{
    	System.out.println(str);
    	xmlContentBuilder.append(str);
    	}    	
    	
    	in.close();
		String xmlContent=xmlContentBuilder.toString();
		System.out.println(xmlContent);
		request.setAttribute("XmlFile", xmlContent);
		System.out.println(request.getAttribute("XmlFile"));
		RequestDispatcher requestDispatcher=(RequestDispatcher) request.getRequestDispatcher(("http://localhost:8080/Tutorial/api/AjaxProcessing?name: adad"));
		requestDispatcher.forward(request, response);
	}

}
