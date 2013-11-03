package com.huang.j2ee.ch00.service;

/**
 * Date : 2013-11-02 18:58
 */
public class SayHiServiceImpl implements SayHiService {
    @Override
    public String sayHi(String str) {
        if (null == str) {
            return "hi";
        } else {
            return "hi" + str;
        }
    }
}
