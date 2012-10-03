package com.huang.study.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LogAopTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	public void test1() {
		System.out.println("手动方式");
		ApplicationContext actx = new ClassPathXmlApplicationContext("applicationContext_test.xml");
		ITimeBook timeBookProxy = (ITimeBook)actx.getBean("logProxy");
		timeBookProxy.doAudit();
		timeBookProxy.doCheck();
		timeBookProxy.doThrow();
	}
	
	@Test
	public void test2() {
		System.out.println("自动方式");
		ApplicationContext actx = new ClassPathXmlApplicationContext("applicationContext_test.xml");
		ITimeBook timeBookProxy = (ITimeBook)actx.getBean("timeBook");
		timeBookProxy.doAudit();
		timeBookProxy.doCheck();
		try {
			timeBookProxy.doThrow();
		} catch (Exception e) {
		}
	}

}
