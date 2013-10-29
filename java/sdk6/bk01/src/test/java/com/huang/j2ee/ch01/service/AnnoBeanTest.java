package com.huang.j2ee.ch01.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created By User : Morn
 * Created DateTime: 13-10-3 下午8:26
 * Descriptions    :
 */
public class AnnoBeanTest {
    @Test
    public void testAnnoBean() throws Exception {
        ApplicationContext actx = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnoBean bean = actx.getBean("annoBean", AnnoBean.class);
        System.out.println(bean.getName());
        System.out.println(bean.getAge());
        bean.sayHello();

    }
}
