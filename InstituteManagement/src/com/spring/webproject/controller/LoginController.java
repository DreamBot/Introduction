package com.spring.webproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.webproject.dao.UserDAO;
import com.spring.webproject.model.User;

public class LoginController {
	
	UserDAO userDAO;
	
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String loginPage(final ModelMap modelmap,final HttpServletRequest request){
		modelmap.addAttribute("springWebProjectObject", "Value passed by controller");
		return "loginView";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doLogin(final ModelMap modelmap,final HttpServletRequest request){
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		
		if(userDAO.isValidUser(userName)){
			User user= null;
			if((user=userDAO.authenticate(userName, password))!=null){
				modelmap.addAttribute("user", user);
				return "homeView";
			}
			else{
				modelmap.addAttribute("springWebProjectObject", "Login Failed");
			}
		}else{
			modelmap.addAttribute("springWebProjectObject", "User invalid");
		}
		//System.out.println(user.getUserName());
		//modelmap.addAttribute("springWebProjectObject", "Value passed by controller after login");
		return "loginView"; // replacing with redirect
		//return "redirect:/display/redirectPage.spring";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String redirectPage(final ModelMap modelmap,final HttpServletRequest request){
		
		modelmap.addAttribute("springWebProjectObject", "Redirect Page");
		return "loginView";
	}
	
}
