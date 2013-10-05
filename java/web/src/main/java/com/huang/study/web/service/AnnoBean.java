package com.huang.study.web.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created By User : Morn
 * Created DateTime: 13-9-29 下午5:59
 * Descriptions    :
 */
@Component("annoBean")
@Scope("singleton")
public class AnnoBean {
    @Value("Anno Bean's Name")
    private String name;

    @Value("${annoBean.age}")
    private int age;

    public AnnoBean() {
    }

    public AnnoBean(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void init() {
        System.out.println("AnnoBean Initialize");
    }

    @PreDestroy
    public void destory() {
        System.out.println("AnnoBean Destroy");
    }
}
