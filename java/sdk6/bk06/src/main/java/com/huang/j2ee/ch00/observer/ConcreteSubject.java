package com.huang.j2ee.ch00.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Date : 2013-10-31 19:44
 */
public class ConcreteSubject implements Subject {
    private List<Observer> observerList = new ArrayList<Observer>();

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer: observerList) {
            observer.update();
        }
    }

    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer observer = new ConcreteObserver();
        subject.registerObserver(observer);

        // when subject's state change, notify observer
        subject.notifyObserver();
    }
}
