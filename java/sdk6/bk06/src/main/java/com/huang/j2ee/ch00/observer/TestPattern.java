package com.huang.j2ee.ch00.observer;

/**
 * Date : 2013-11-05 22:31
 */
public class TestPattern {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserverA();
        Observer observer2 = new ConcreteObserverB();
        subject.registerObserver(observer1);
        subject.registerObserver(observer2);

        System.out.println("--------two observer----------");
        // when subject's state change, notify observer
        subject.notifyObserver();

        subject.removeObserver(observer1);

        System.out.println("--------one observer----------");
        subject.notifyObserver();
    }
}
