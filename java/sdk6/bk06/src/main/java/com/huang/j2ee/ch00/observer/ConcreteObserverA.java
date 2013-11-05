package com.huang.j2ee.ch00.observer;

/**
 * Date : 2013-10-31 19:42
 */
public class ConcreteObserverA implements Observer {
    @Override
    public void update() {
        System.out.println("ConcreteObserverA.update have got message and updated yourself!");
    }
}
