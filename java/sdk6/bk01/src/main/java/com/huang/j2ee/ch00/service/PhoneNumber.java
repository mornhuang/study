package com.huang.j2ee.ch00.service;

/**
 * Created By User : Morn
 * Created DateTime: 2015/3/5 17:48
 * Descriptions    : 测试注入时属性转化
 */
public class PhoneNumber {
    private String areaCode;
    private String prefix;
    private String number;

    public PhoneNumber() {
    }

    public PhoneNumber(String areaCode, String prefix, String number) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.number = number;
    }
}
