package com.huang.study.web.action;

import com.huang.study.web.utils.MyException;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.SQLException;

public class Login1Action extends ActionSupport{
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
	
	public String execute() throws Exception {
        if (getUsername().equalsIgnoreCase("user")) {
            throw new MyException("自定义异常");
        }

        if (getUsername().equalsIgnoreCase("sql")) {
            throw new SQLException("用户名不能为SQL");
        }

		if (getUsername().equals("scott") && getPassword().equals("tiger")){
			return "success";
		} else {
			return "error";
		}
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
