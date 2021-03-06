package com.huang.j2ee.ch01.action;

import com.huang.j2ee.ch00.MyException;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.SQLException;

/**
 * 学习Struts的validate
 * @see com/huang/j2ee/ch01/action/Login2Action-validation.xml
 */
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

    /* 只有在jsp中使用struts的标签才有用 */
    public void validate() {
        if (getUsername() == null || getUsername().trim().equals("")) {
            addFieldError("username", getText("user.required"));
        }

        if (getPassword() == null || getPassword().trim().equals("")) {
            addFieldError("password", getText("password.required"));
        }
    }

}
