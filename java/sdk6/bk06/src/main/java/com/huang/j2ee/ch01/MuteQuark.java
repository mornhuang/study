package com.huang.j2ee.ch01;

/**
 * Date : 2013-10-30 22:42
 */
public class MuteQuark implements QuarkBehavior {
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
