package com.huang.study.web.service;

import org.aspectj.lang.annotation.*;

/**
 * Created By User : Morn
 * Created DateTime: 13-10-5 下午4:49
 * Descriptions    :
 */
@Aspect
public class AnnoBeforeAop {
    @Before("execution(* com.huang.study.web.service.*.sayHello(..))")
    public void log() {
        System.out.println("Before Advice----->");
    }
}
