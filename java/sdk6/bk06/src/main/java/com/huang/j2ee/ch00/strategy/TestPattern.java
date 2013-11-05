package com.huang.j2ee.ch00.strategy;

/**
 * Date : 2013-11-05 22:39
 */
public class TestPattern {
    public static void main(String[] args) {
        Context context = new Context();

        // can use different strategy
        context.setStrategy(new ConcreteStrategyA());
        context.performAlgorithm();

        System.out.println();

        context.setStrategy(new ConcreteStrategyB());
        context.performAlgorithm();
    }
}
