package com.huang.j2ee.ch00.service;

/**
 * Created By User : Morn
 * Created DateTime: 2015/2/13 15:22
 * Descriptions    : 测试构造注入、Set注入
 */
public class GreetingServiceImpl implements GreetingService {
    private String greeting;

    public GreetingServiceImpl() {
    }

    public GreetingServiceImpl(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public void sayGreeting() {
        System.out.println(greeting);
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
