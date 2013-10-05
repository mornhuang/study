package com.huang.study.web.base;

/**
 * Created By User : Morn
 * Created DateTime: 13-10-5 下午2:27
 * Descriptions    :
 */
public aspect TxAspect {
        void around() :call (void com.huang.study.web.base.Hello.sayHello()) {
            System.out.println("Begin Transaction...");
            proceed();
            System.out.println("End Transaction ...");
        }
}
