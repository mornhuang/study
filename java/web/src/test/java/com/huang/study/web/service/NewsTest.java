package com.huang.study.web.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created By User : Morn
 * Created DateTime: 13-10-6 下午6:14
 * Descriptions    :
 */
public class NewsTest {
    @Test
    public void testNewsGetAll() throws Exception {
        ApplicationContext actx = new ClassPathXmlApplicationContext("applicationContext.xml");
        NewsService newsService = actx.getBean("newsService", NewsService.class);
        newsService.getAll();

    }
}
