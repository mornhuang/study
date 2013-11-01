package com.huang.j2ee.ch01;

/**
 * Date : 2013-10-30 23:31
 */
public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quarkBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
