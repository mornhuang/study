package com.huang.j2ee.ch00.decorate;

/**
 * Date : 2013-11-01 23:35
 */
public class TestPattern {
    public static void main(String[] args) {
        System.out.println("----Component out----------");
        Component component = new ConcreteComponent();
        component.operation();
        System.out.println("");

        System.out.println("----DecoratorA out----------");
        Decorator decoratora = new ConcreteDecoratorA(component);
        decoratora.operation();
        System.out.println("");

        System.out.println("----DecoratorB out----------");
        Decorator decoratorb = new ConcreteDecoratorB(component);
        decoratorb.operation();
        System.out.println("");

        System.out.println("----Decorator twice out----------");
        Decorator decoratorc = new ConcreteDecoratorB(decoratora);
        decoratorc.operation();

    }
}
