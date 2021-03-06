package com.huang.j2ee.ch01.service;

import java.lang.reflect.Method;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

/**
 * 学习spring的AOP，通过继承spring的类的方式
 */
public class LogAfter implements AfterReturningAdvice {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		logger.log(Level.INFO, "--------调用AOP的afterReturning-------\n拦截：" + method.toString() + "\n");
	}

}
