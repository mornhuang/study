package com.huang.j2ee.ch00.decorate;

/**
 * Date : 2013-11-01 23:19
 */
public abstract class Decorator implements Component {
    protected Component componet;

    protected Decorator(Component componet) {
        this.componet = componet;
    }

    @Override
    public abstract void operation();
}
