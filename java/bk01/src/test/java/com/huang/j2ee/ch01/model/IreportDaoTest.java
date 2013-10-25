package com.huang.j2ee.ch01.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.List;

public class IreportDaoTest {
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetAll() {
        ApplicationContext actx = new ClassPathXmlApplicationContext("applicationContext.xml");
        IreportDao dao = (IreportDao)actx.getBean("jsprDao");

        List<Ireport> irptList = dao.getAll();
		Ireport irpt;
		for (Iterator<Ireport> it = irptList.iterator(); it.hasNext(); ) {
			irpt = (Ireport)it.next();
			System.out.println(irpt.getId() + " " + irpt.getName() + " " + irpt.getSex() 
					+ " " + irpt.getAge() + " " + irpt.getClsd());
		}
	}

    @Test
    public void testSetData() {
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();

        Ireport ir = new Ireport(2, "huang", "male", 30, "c2");
        sess.save(ir);

        tx.commit();
        sess.close();
        sf.close();

    }

}
