package com.huang.j2ee.ch01;

/**
 * Date : 2013-10-30 22:39
 */
public class Quack implements QuarkBehavior {
    @Override
    public void quack() {
        System.out.println("Say 'gua gua'");
    }
}
