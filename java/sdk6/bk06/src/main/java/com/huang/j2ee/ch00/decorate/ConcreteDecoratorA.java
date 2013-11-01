package com.huang.j2ee.ch00.decorate;

/**
 * Date : 2013-11-01 23:05
 */
public class ConcreteDecoratorA extends Decorator {
    private int addState = 1;

    public ConcreteDecoratorA(Component componet) {
        super(componet);
    }

    @Override
    public void operation() {
        this.componet.operation();
        System.out.println("ConcreteDecoratorA.operation");
    }
}
