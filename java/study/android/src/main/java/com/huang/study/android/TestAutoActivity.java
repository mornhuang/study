package com.huang.study.android;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import com.huang.study.android.util.LogUtil;

public class TestAutoActivity extends Activity {
	private AutoCompleteTextView atv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(LogUtil._CLASS_(), LogUtil._FUNC_());
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.l01_auto);
	
		atv = (AutoCompleteTextView)findViewById(R.id.l0100_TextView);
		String[] strs = {"abc", "bcd", "abcd", "bcde"};
		ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, strs);
		atv.setAdapter(ad);
		
	}

}
