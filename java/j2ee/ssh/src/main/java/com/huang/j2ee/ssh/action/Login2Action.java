package com.huang.j2ee.ssh.action;

import com.huang.j2ee.ssh.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class Login2Action extends ActionSupport {
	private String username;
	private String password;
    private List users;
    private String tip;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public List getUsers() {
        return users;
    }

    public void setUsers(List users) {
        this.users = users;
    }

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
        if (getUser().getName().equals("crazy") && getUser().getPass().equals("gogo")) {
            setTip("Login Success");
            return "crazy";
        }

        User firstUser = (User)getUsers().get(0);
        if (firstUser.getName().equals("crazy") && firstUser.getPass().equals("gogo")) {
            setTip("Login Success");
            return "crazy";
        }

		if (getUsername().equals("scott") && getPassword().equals("tiger")) {
			ActionContext.getContext().getSession().put("user", getUsername());
			return SUCCESS;
		}

		return ERROR;
	}
}
