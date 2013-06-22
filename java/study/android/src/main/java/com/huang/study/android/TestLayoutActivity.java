package com.huang.study.android;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.huang.study.android.util.LogUtil;

public class TestLayoutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(LogUtil._CLASS_(), LogUtil._FUNC_());
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.l05_layout);
		
	}

}
