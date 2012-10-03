package com.huang.study.model;

import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IreportDaoTest {
	ApplicationContext actx;
	IIreportDao dao;
	
	@Before
	public void setUp() throws Exception {
		actx = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (IIreportDao)actx.getBean("jsprDao");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetAll() {
		List<Ireport> irptList = dao.getAll();
		Ireport irpt;
		for (Iterator<Ireport> it = irptList.iterator(); it.hasNext(); ) {
			irpt = (Ireport)it.next();
			System.out.println(irpt.getId() + " " + irpt.getName() + " " + irpt.getSex() 
					+ " " + irpt.getAge() + " " + irpt.getClsd());
		}
	}
}
