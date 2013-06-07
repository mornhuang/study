package com.huang.study.android;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class TestAutoActivity extends Activity {
	private AutoCompleteTextView atv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(LogUtil._CLASS_(), LogUtil._FUNC_());
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_auto);
	
		atv = (AutoCompleteTextView)findViewById(R.id.AutoTextView901);
		String[] strs = {"abc", "bcd", "abcd", "bcde"};
		ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, strs);
		atv.setAdapter(ad);
		
	}

}
