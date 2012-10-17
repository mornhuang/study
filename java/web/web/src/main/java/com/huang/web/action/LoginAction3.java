package com.huang.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction3 extends ActionSupport {
	private static final long serialVersionUID = 3585525634319258691L;
	
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		/*
		if (getUsername().equals("scott") && getPassword().equals("tiger")) {
			return SUCCESS;
		} else {
			return ERROR;
		}*/
		return SUCCESS;
	}
	
	public void validate() {
		if (getUsername() == null || getUsername().trim().equals("")) {
			addFieldError("username", getText("user.required"));
		}
		
		if (getPassword() == null || getPassword().trim().equals("")) {
			addFieldError("password", getText("password.required"));
		}
	}
}
