package com.huang.study.android.util;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: HuangMeng
 * Date: 13-6-9
 * Time: 下午4:26
 * To change this template use File | Settings | File Templates.
 */
public class TestCalendar {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.HOUR));
    }
}
