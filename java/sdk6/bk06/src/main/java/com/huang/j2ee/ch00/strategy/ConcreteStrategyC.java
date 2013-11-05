package com.huang.j2ee.ch00.strategy;

/**
 * Date : 2013-10-31 19:31
 */
public class ConcreteStrategyC implements Strategy {
    @Override
    public void algorithm() {
        System.out.println("ConcreteStrategyC.algorithm");
    }
}
