package com.huang.j2ee.ch00.factorymethod;

/**
 * Date : 2013-11-05 22:09
 */
public class ConcreteProductA implements Product {
    @Override
    public void show() {
        System.out.println("ConcreteProductA.show");
    }
}
