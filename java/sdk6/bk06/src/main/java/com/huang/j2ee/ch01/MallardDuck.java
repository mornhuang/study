package com.huang.j2ee.ch01;

/**
 * Date : 2013-10-30 22:48
 */
public class MallardDuck extends Duck {
    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quarkBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a really mallard duck");
    }
}
