package com.huang.j2ee.ch00.factorymethod;

/**
 * Date : 2013-11-05 22:19
 */
public class ConcreteCreatorB extends Creator {
    @Override
    public void factorMethod() {
        product = new ConcreteProductB();
    }
}
