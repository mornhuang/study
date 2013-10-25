package com.huang.j2ee.ch00;

/**
 * Created By User : Morn
 * Created DateTime: 13-9-19 上午10:10
 * Descriptions    :
 */
public class MyException extends Exception {
    public MyException() {
        super();
    }

    public MyException(String msg) {
        super(msg);
    }
}
