package com.huang.web.service;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LogAround implements MethodInterceptor {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		logger.log(Level.INFO,  "........调用AOP的invoke开始........\n拦截：" + arg0.getMethod().toString());
		try {
			Object result = arg0.proceed();
			return result;
		} finally {
			logger.log(Level.INFO, "........调用AOP的invoke结束........\n拦截：" + arg0.getMethod().toString());
		}
	}

}
