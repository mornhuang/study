package com.huang.j2ee.ch01.service;

import java.lang.reflect.Method;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * 学习spring的AOP，通过继承spring的类的方式
 */
public class LogBefore implements MethodBeforeAdvice {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		logger.log(Level.INFO, "------调用AOP的before-------\n拦截：" + method.toString());
	}

}
