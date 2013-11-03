package com.huang.android.ch01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.huang.android.R;

import java.util.ArrayList;
import java.util.List;

public class TestWidgetRlstActivity extends Activity {
	private ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.l11_widget);
		
		listView = (ListView)findViewById(R.id.l1100_listView);
		
		Intent intent = this.getIntent();
		Bundle b = intent.getBundleExtra("data");
		
		List list = new ArrayList();
		list.add(b.getString("username"));
		list.add(b.getString("password"));
		list.add(b.getString("position"));
		list.add(b.getString("gender"));
		list.add(b.getString("hobby"));
		list.add(b.getString("marriged"));
		
		ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_checked, list);
		listView.setAdapter(adapter);
	}

}
