package com.huang.study.android;

import android.test.ActivityInstrumentationTestCase2;

public class TestXmlActivityTest extends ActivityInstrumentationTestCase2<TestXmlActivity> {

    public TestXmlActivityTest() {
        super(TestXmlActivity.class); 
    }

    public void testActivity() {
    	TestXmlActivity activity = getActivity();
        assertNotNull(activity);
    }
}

