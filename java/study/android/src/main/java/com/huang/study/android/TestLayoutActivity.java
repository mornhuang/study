package com.huang.study.android;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class TestLayoutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(LogUtil._CLASS_(), LogUtil._FUNC_());
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_layout);
		
	}

}
