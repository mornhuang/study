package com.huang.j2ee.ch00.observer;

/**
 * Date : 2013-10-31 19:42
 */
public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
}
