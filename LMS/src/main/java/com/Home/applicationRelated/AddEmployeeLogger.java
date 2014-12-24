package com.Home.applicationRelated;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AddEmployeeLogger {
	
	PrintWriter printWriter=null;
	ApplicationLogger applicationLogger=new ApplicationLogger();
	@Pointcut(
			"execution(* com.json.restClient.JerseyClient.createEmployee(..))")
			public void addingEmployee(){
				
			}
	
	@Before("addingEmployee()")
	public void beforeAddingEmployee()
	{
		try {
			 
			 applicationLogger.logInfo(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date())+" Before trying to add employee");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		}
		
		
		
	}
	@After("addingEmployee()")
	public void afterAddingEmployee()
	{
		try {
			applicationLogger.logInfo(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date())+" After trying to add employee");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		}
		
	}
	
	@Pointcut(
			"execution(* com.json.restClient.JerseyClient.updateEmployee(..))")
			public void updatingEmployee(){
				
			}
	@Before("updatingEmployee()")
	public void beforeUpdatingEmployee()
	{
		try {
			 
			 applicationLogger.logInfo(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date())+" Before trying to update employee");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		}
		
		
		
	}
	@After("updatingEmployee()")
	public void afterUpdatingEmployee()
	{
		try {
			applicationLogger.logInfo(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date())+" After trying to update employee");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		}
		
	}
	
	
	@Pointcut(
			"execution(* com.json.restClient.JerseyClient.retrieveEmployee(..))")
			public void retrievingEmployee(){
				
			}
	@Before("retrievingEmployee()")
	public void beforeRetrievingEmployee()
	{
		try {
			 
			 applicationLogger.logInfo(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date())+" Before trying to retrieve employee");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		}
		
		
		
	}
	@After("retrievingEmployee()")
	public void afterRetrievingEmployee()
	{
		try {
			applicationLogger.logInfo(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date())+" After trying to retrieve employee");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		}
		
	}
	
	
	@Pointcut(
			"execution(* com.json.restClient.JerseyClient.deleteEmployee(..))")
			public void deletingEmployee(){
				
			}
	@Before("deletingEmployee()")
	public void beforeDeletingEmployee()
	{
		try {
			 
			 applicationLogger.logInfo(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date())+" Before trying to delete employee");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		}
		
		
		
	}
	@After("deletingEmployee()")
	public void afterDeletingEmployee()
	{
		try {
			applicationLogger.logInfo(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date())+" After trying to delete employee");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
		}
		
	}
	
	
	
	
	

}
