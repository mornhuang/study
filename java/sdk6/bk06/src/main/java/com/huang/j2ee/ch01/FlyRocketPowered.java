package com.huang.j2ee.ch01;

/**
 * Date : 2013-10-30 23:23
 */
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with rocket!");
    }
}
