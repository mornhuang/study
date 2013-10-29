package com.huang.j2ee.ch01.service;

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
		System.out.println("测试用例1:手动方式\n");
		ApplicationContext actx = new ClassPathXmlApplicationContext("applicationContext_test.xml");
		TimeBook timeBookProxy = (TimeBook)actx.getBean("logProxy");
		timeBookProxy.doAudit();
		timeBookProxy.doCheck();
		timeBookProxy.doThrow();
	}

	@Test
	public void test2() {
		System.out.println("测试用例2:自动方式\n");
		ApplicationContext actx = new ClassPathXmlApplicationContext("applicationContext_test.xml");
		TimeBook timeBookProxy = (TimeBook)actx.getBean("timeBook");
		timeBookProxy.doAudit();
		timeBookProxy.doCheck();
		try {
			timeBookProxy.doThrow();
		} catch (Exception e) {
		}
	}

}
