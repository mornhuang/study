package com.huang.j2ee.ch13;

import org.springframework.stereotype.Component;

/**
 * Date : 2013-10-25 16:12
 */
//@Component
public class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
