package com.huang.j2ee.ch01;

/**
 * Date : 2013-10-30 22:45
 */
public abstract class Duck {
    FlyBehavior flyBehavior;
    protected QuarkBehavior quarkBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuarkBehavior(QuarkBehavior quarkBehavior) {
        this.quarkBehavior = quarkBehavior;
    }

    public final void performQuark() {
        quarkBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public abstract void display();

    public void swim() {
        System.out.println("All duck can swim, even decoys");
    }
}
