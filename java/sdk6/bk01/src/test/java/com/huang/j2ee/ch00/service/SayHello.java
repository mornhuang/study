package com.huang.j2ee.ch00.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created By User : Morn
 * Created DateTime: 2015/2/13 15:48
 * Descriptions    : 测试spring获取bean
 */
public class SayHello {
    public static void main(String[] args) throws Exception {
//        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("hello.xml"));

        ApplicationContext factory = new ClassPathXmlApplicationContext("com/huang/j2ee/ch00/hello.xml");

        GreetingService greetingService = (GreetingService) factory.getBean("greetingService");
        greetingService.sayGreeting();
    }
}
