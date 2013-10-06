package com.huang.j2ee.ssh.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class IntpAction extends AbstractInterceptor {
	private static final long serialVersionUID = 1295197047564036956L;
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println(name + " 拦截器的动作--------" + "开始执行登录Action的时间：" + new Date());
		long start = System.currentTimeMillis();
		String result = invocation.invoke();
		System.out.println(name + " 拦截器的动作--------" + "执行完登录Action的时间：" + new Date());
		long end = System.currentTimeMillis();
		System.out.println(name + " 拦截器的动作--------" + "执行完Action的时间：" + (end - start) + "毫秒");
		return result;
	}

}
