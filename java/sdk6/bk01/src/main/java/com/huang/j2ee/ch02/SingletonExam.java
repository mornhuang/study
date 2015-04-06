package com.huang.j2ee.ch02;

/**
 * Created By User : Morn
 * Created DateTime: 2015/3/10 18:03
 * Descriptions    : Initialization on demand holder
 */
public class SingletonExam {
    private SingletonExam() {
    }

    private static class SingletonHolder {
        static SingletonExam instance = new SingletonExam();
    }

    public static SingletonExam getInstance() {
        return SingletonHolder.instance;
    }
}
