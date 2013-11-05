package com.huang.j2ee.ch00.factorymethod;

/**
 * Date : 2013-11-05 22:18
 */
public class ConcreteProductB implements Product {
    @Override
    public void show() {
        System.out.println("ConcreteProductB.show");
    }
}
