package com.huang.j2ee.ch00.service;

/**
 * Created By User : Morn
 * Created DateTime: 2015/3/5 17:47
 * Descriptions    : 测试注入
 */
public class Contact {
    private PhoneNumber phoneNumber;

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
