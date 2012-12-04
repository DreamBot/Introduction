package com.spring.webproject.model;

import java.io.Serializable;

public class User  implements Serializable, Comparable<User> {
	
	private String id;
	private String userName;
	private String password;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int compareTo(User user){
		if(user!=null && user.userName.equals(this.userName)) return 0;
		else return -1;
	}

}
