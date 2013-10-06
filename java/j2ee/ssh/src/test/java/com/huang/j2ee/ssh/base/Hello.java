package com.huang.j2ee.ssh.base;

/**
 * Created By User : Morn
 * Created DateTime: 13-10-5 下午2:19
 * Descriptions    :
 */
public class Hello {
    public void sayHello() {
        System.out.println("Hello AspectJ");
    }

    public static void main(String[] args) {
        Hello h = new Hello();
        h.sayHello();
    }
}
