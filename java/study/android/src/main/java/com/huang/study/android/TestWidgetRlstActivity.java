package com.huang.study.android;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TestWidgetRlstActivity extends Activity {
	private ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(LogUtil._CLASS_(), LogUtil._FUNC_());
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_widget2);
		
		listView = (ListView)findViewById(R.id.id801listView);
		
		Intent intent = this.getIntent();
		Bundle b = intent.getBundleExtra("data");
		
		List list = new ArrayList();
		list.add(b.getString("username"));
		list.add(b.getString("password"));
		list.add(b.getString("position"));
		list.add(b.getString("gender"));
		list.add(b.getString("hobby"));
		list.add(b.getString("marriged"));
		
		ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_checked,list);
		listView.setAdapter(adapter);
	}

}
