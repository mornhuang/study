package com.huang.j2ee.ch01.service;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;

/**
 * 学习spring的AOP，通过继承spring的类的方式
 */
public class LogThrow implements ThrowsAdvice {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	public void afterThrowing(Exception ex) {
		logger.log(Level.INFO, "----------调用AOP的afterThrowing-------");
		ex.printStackTrace();
	}
}
