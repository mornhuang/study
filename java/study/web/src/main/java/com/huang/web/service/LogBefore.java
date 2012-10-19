package com.huang.web.service;

import java.lang.reflect.Method;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class LogBefore implements MethodBeforeAdvice {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		logger.log(Level.INFO, "开始审核数据+++++" + method.toString());
	}

}
