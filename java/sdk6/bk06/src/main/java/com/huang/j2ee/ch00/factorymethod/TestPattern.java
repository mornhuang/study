package com.huang.j2ee.ch00.factorymethod;

/**
 * Date : 2013-11-05 22:24
 */
public class TestPattern {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreatorA();
        creator.anOperation();

        creator = new ConcreteCreatorB();
        creator.anOperation();
    }
}
