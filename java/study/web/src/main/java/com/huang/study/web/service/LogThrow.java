package com.huang.study.web.service;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;

public class LogThrow implements ThrowsAdvice {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	public void afterThrowing(Exception ex) {
		logger.log(Level.INFO, "----------调用AOP的afterThrowing-------");
		ex.printStackTrace();
	}
}
