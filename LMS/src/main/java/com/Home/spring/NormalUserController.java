package com.Home.spring;

import java.security.Principal;






import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;



import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NormalUserController {
	@RequestMapping(value={"/Employee"}, method = RequestMethod.GET)
	public String printWelcome(ModelMap model, Principal principal,HttpServletRequest request) {
		return "employeeHomePage";
 
	}
}
