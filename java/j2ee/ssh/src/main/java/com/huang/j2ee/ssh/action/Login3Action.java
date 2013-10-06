package com.huang.j2ee.ssh.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;

import com.opensymphony.xwork2.interceptor.PreResultListener;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import java.util.Date;

public class Login3Action implements Action {
	private static final long serialVersionUID = 3585525634319258691L;
	
	private String username;
	private String password;
    private String tip;

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
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
        ActionContext.getContext().getSession().put("user", getUsername());

        ActionInvocation invocation = ActionContext.getContext().getActionInvocation();
        invocation.addPreResultListener(new PreResultListener() {
            @Override
            public void beforeResult(ActionInvocation invocation, String resultCode) {
                System.out.println("返回的逻辑视图名为：" + resultCode);
                invocation.getInvocationContext().put("extra", new Date() + "由" + resultCode + "逻辑视图转入");
            }
        });

		if (getUsername().equals("scott") && getPassword().equals("tiger")) {
            Cookie c = new Cookie("user", getUsername());
            c.setMaxAge(60 * 60);
            ServletActionContext.getResponse().addCookie(c);

			return SUCCESS;
		} else {
			return ERROR;
		}
	}

    public String regist() throws Exception {
        ActionContext actx = ActionContext.getContext();
        Integer counter = (Integer)actx.getApplication().get("counter");
        if (counter == null) {
            counter = 1;
        } else {
            counter++;
        }
        actx.getApplication().put("counter", counter);
        actx.put("tip", "计数嚣增加1");

        return "regist";
    }
}
