package com.huang.j2ee.ch00.factorymethod;

/**
 * Date : 2013-11-05 22:10
 */
public abstract class Creator {
    protected Product product;

    protected abstract void factorMethod();

    public void anOperation() {
        factorMethod();
        product.show();
    }
}
