package com.huang.j2ee.ch01;

/**
 * Date : 2013-10-30 22:41
 */
public class Squeak implements QuarkBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
