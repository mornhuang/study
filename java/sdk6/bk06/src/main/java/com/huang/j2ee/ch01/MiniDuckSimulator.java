package com.huang.j2ee.ch01;

/**
 * Date : 2013-10-30 23:02
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.swim();
        mallard.performFly();
        mallard.performQuark();

        Duck model = new ModelDuck();
        model.display();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
