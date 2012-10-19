package com.huang.web.service;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;

public class LogThrow implements ThrowsAdvice {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	public void afterThrowing(Exception ex) {
		ex.printStackTrace();
		logger.log(Level.INFO, "审核数据异常++++++");
	}
}
