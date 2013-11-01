package com.huang.j2ee.ch00.decorate;

/**
 * Date : 2013-11-01 23:17
 */
public class ConcreteComponent implements Component{
    @Override
    public void operation() {
        System.out.println("Concrete Component");
    }
}
