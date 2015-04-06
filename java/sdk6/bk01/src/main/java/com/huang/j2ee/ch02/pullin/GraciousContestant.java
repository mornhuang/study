package com.huang.j2ee.ch02.pullin;

/**
 * Created By User : Morn
 * Created DateTime: 2015/3/16 19:38
 * Descriptions    :
 */
public class GraciousContestant implements Contestant {
    @Override
    public void receiveAward() {
        System.out.println("Why? thank you all very much");
    }
}
