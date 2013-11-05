package com.huang.j2ee.ch00.strategy;

/**
 * Date : 2013-10-31 19:30
 */
public class ConcreteStrategyB implements Strategy {
    @Override
    public void algorithm() {
        System.out.println("ConcreteStrategyB.algorithm");
    }
}
