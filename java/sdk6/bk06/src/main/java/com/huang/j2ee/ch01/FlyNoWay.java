package com.huang.j2ee.ch01;

/**
 * Date : 2013-10-30 22:37
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("i can't fly");
    }
}
