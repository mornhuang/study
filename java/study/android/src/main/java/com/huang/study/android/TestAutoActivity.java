package com.huang.study.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class TestAutoActivity extends Activity {
	private AutoCompleteTextView atv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.l01_auto);
	
		atv = (AutoCompleteTextView)findViewById(R.id.l0101_AutoTextView);
		String[] strs = {"abc", "bcd", "abcd", "bcde"};
		ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, strs);
		atv.setAdapter(ad);
		
	}

}
