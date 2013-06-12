package com.huang.study.android.util;

import java.util.ArrayList;
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

        ArrayList<String> test = new ArrayList<String>();
        test.add("test");
        test.add("test2");

        String[] a = test.toArray(new String[test.size()]);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
