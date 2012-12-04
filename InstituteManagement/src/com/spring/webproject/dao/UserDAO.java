package com.spring.webproject.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.spring.webproject.model.User;

public class UserDAO {
	
	private List<User> users;
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void init_fn(){
		users = hibernateTemplate.loadAll(User.class);
	}
	
	public boolean isValidUser(String userName){
		for(User user:users){
			if(user.getUserName().equals(userName)) return true;
		}
		return false;
	}
	
	public User authenticate(String userName,String password){
		for(User user:users){
			if(user.getUserName().equals(userName)){
				if(user.getPassword().equals(password)){
					return user;
				}else{
					return null;
				}
			}
		}
		return null;
	}

}
