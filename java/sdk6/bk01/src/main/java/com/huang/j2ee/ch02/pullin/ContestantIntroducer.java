package com.huang.j2ee.ch02.pullin;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * Created By User : Morn
 * Created DateTime: 2015/3/19 15:33
 * Descriptions    : 使用注解方式测试Spring的引入
 */
@Aspect
public class ContestantIntroducer {
    @DeclareParents(
            value = "com.huang.j2ee.ch02.pullin.Performer+",
            defaultImpl = GraciousContestant.class)
    public static Contestant contestant;
}
