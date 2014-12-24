package com.Home.applicationRelated;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ApplicationRelatedBeans {
	ReqWebServices reqWebServices;	
	public ApplicationRelatedBeans() {
		// TODO Auto-generated constructor stub
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Database.xml");
		setReqWebServices((ReqWebServices) applicationContext.getBean("ReqWebServices"));
		((ConfigurableApplicationContext)applicationContext).close();
	}
		
	public String getRestJSONWebServiceURL()
	{
		return reqWebServices.getRestJSONWebServiceURL();
	}
	
	public void setReqWebServices(ReqWebServices reqWebServices)
	{
		this.reqWebServices=reqWebServices;
	}
	public String getRestXMLWebServiceURL()
	{
		return reqWebServices.getRestXMLWebServiceURL();
	}
}
