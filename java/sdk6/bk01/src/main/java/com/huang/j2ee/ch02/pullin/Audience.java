package com.huang.j2ee.ch02.pullin;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created By User : Morn
 * Created DateTime: 2015/3/19 14:49
 * Descriptions    : 测试Spring的AOP
 */
public class Audience {
    public void takeSeats() {
        System.out.println("The audience is taking their seats");
    }

    public void turnOffCellPhone() {
        System.out.println("The audience is turning off their cellphones");
    }

    public void apploud() {
        System.out.println("CLAP CLAP CLAP");
    }

    public void demandRefund() {
        System.out.println("Boo! We want our money back!");
    }

    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("The audience is taking their seats");
            System.out.println("The audience is turning off their cellphones");
            long start = System.currentTimeMillis();
            joinPoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println("CLAP CLAP CLAP");
            System.out.println("The performance took" + (end - start) + "milliseconds");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
