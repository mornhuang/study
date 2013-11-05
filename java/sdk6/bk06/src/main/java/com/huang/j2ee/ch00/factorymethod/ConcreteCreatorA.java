package com.huang.j2ee.ch00.factorymethod;

/**
 * Date : 2013-11-05 22:14
 */
public class ConcreteCreatorA extends Creator {
    @Override
    public void factorMethod() {
        product = new ConcreteProductA();
    }
}
