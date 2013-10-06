package com.huang.j2ee.ssh.base;

/**
 * Created By User : Morn
 * Created DateTime: 13-10-5 下午2:27
 * Descriptions    :
 */
public aspect HelloAspect {
        void around() :call (void com.huang.j2ee.ssh.base.Hello.sayHello()) {
            System.out.println("Begin Transaction...");
            proceed();
            System.out.println("End Transaction ...");
        }
}
