package com.huang.j2ee.ch00.observer;

/**
 * Date : 2013-11-05 22:34
 */
public class ConcreteObserverB implements Observer {
    @Override
    public void update() {
        System.out.println("ConcreteObserverB.update have got message and updated yourself!");
    }
}
