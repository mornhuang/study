package com.huang.j2ee.ch00.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created By User : Morn
 * Created DateTime: 2015/3/6 13:32
 * Descriptions    : 学习java反射的proxy
 */
public class BusinessProcessorHandler implements InvocationHandler {
    private Object target = null;

    BusinessProcessorHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("You can do something here before process your business");
        Object result = method.invoke(target, args);
        System.out.println("You can do something here after process your business");
        return result;
    }
}
