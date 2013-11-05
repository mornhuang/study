package com.huang.j2ee.ch00.strategy;

/**
 * Date : 2013-10-31 19:31
 */
public class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void performAlgorithm() {
        strategy.algorithm();
    }
}
