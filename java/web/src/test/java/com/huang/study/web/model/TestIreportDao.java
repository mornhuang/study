package com.huang.study.web.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created By User : Morn
 * Created DateTime: 13-9-22 下午10:22
 * Descriptions    :
 */
public class TestIreportDao {
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
