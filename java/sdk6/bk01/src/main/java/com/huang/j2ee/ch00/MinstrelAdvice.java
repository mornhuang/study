package com.huang.j2ee.ch00;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created By User : Morn
 * Created DateTime: 2015/2/14 16:15
 * Descriptions    : 学习Spring的AOP内容
 */
public class MinstrelAdvice implements MethodBeforeAdvice {
    public MinstrelAdvice() {
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {

    }
}
