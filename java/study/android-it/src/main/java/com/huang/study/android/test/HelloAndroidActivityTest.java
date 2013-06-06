package com.huang.study.android.test;

import android.test.ActivityInstrumentationTestCase2;
import com.huang.study.android.*;

public class HelloAndroidActivityTest extends ActivityInstrumentationTestCase2<TestDimActivity> {

    public HelloAndroidActivityTest() {
        super(TestDimActivity.class); 
    }

    public void testActivity() {
        TestDimActivity activity = getActivity();
        assertNotNull(activity);
    }
}

