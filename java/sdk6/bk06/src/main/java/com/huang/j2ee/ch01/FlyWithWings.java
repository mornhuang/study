package com.huang.j2ee.ch01;

/**
 * Date : 2013-10-30 22:35
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
