package com.huang.j2ee.ch00.proxy;

/**
 * Created By User : Morn
 * Created DateTime: 2015/3/6 13:29
 * Descriptions    :
 */
public class BusinessProcessorImpl implements BusinessProcessor {
    @Override
    public void processBusiness() {
        System.out.println("processing business...");
    }
}
