package com.huang.j2ee.ch01.service;

import com.huang.j2ee.ch01.model.News;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.List;

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
        List<News> newsList = newsService.getAll();

        for (Iterator it = newsList.iterator(); it.hasNext();) {
            News news = (News)it.next();
            System.out.println(news);
        }

        for(News news : newsList) {
            System.out.println(news);
        }
    }
}
