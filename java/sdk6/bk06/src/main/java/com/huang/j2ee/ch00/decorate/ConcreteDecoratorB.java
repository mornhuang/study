package com.huang.j2ee.ch00.decorate;

/**
 * Date : 2013-11-01 23:06
 */
public class ConcreteDecoratorB extends Decorator{

    public ConcreteDecoratorB(Component componet) {
        super(componet);
    }

    public void otherMethod() {
        System.out.println("ConcreteDecoratorB.otherMethod");
    }

    @Override
    public void operation() {
        this.otherMethod();
        this.componet.operation();
        System.out.println("ConcreteDecoratorB.operation");
    }
}
