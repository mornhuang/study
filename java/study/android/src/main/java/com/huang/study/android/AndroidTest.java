package com.huang.study.android;

import junit.framework.Assert;
import android.test.AndroidTestCase;

public class AndroidTest extends AndroidTestCase {
	private static final String Tag = "MyTest";

	public void testSave() throws Throwable
	{
		int i = 4 + 8;
		Assert.assertEquals(12, i);
	}

	public void testSomethingElse() throws Throwable {
		Assert.assertTrue(1 + 1 == 2);
	}
}
