package com.huang.study.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.ToggleButton;

public class TestWidgetActivity extends Activity {
	private Button register, cancle;
	private ToggleButton marriged;
	private RadioButton male, female;
	private EditText username, password;
	private Spinner position;
	private CheckBox reading, swimming;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(LogUtil._CLASS_(), LogUtil._FUNC_());
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_widget);
		
		username = (EditText)findViewById(R.id.id701username);
		password = (EditText)findViewById(R.id.id702password);
		male = (RadioButton)findViewById(R.id.id7031male);
		female = (RadioButton)findViewById(R.id.id7032female);
		reading = (CheckBox)findViewById(R.id.id705reading);
		swimming = (CheckBox)findViewById(R.id.id705swimming);
		marriged = (ToggleButton)findViewById(R.id.id704marriged);
		
		position = (Spinner)findViewById(R.id.id706position);
		String[] str = {"CEO", "CFO", "PM"};
		ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, str);
		position.setAdapter(aa);
		
		register = (Button)findViewById(R.id.id707register);
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Bundle b = new Bundle();
				
				b.putString("username", "用户名称：" + username.getText());
				b.putString("password", "用户密码：" + password.getText());
				
				if (male.isChecked()) {
					b.putString("gender", "性别：男");
				} else {
					b.putString("gender", "性别：女");
				}
				
				String temp = "爱好：";
				if (reading.isChecked()) {
					temp += " 阅读";
				}
				if (swimming.isChecked()) {
					temp += " 游泳";
				}
				b.putString("hobby", temp);
				
				if (marriged.isChecked()) {
					b.putString("marriged", "婚否：已婚");
				} else {
					b.putString("marriged", "婚否：未婚");
				}
				
				b.putString("position", "职位：" + position.getSelectedItem().toString());
				
				Intent intent = new Intent(TestWidgetActivity.this, TestWidgetRlstActivity.class);
				intent.putExtra("data", b);
				startActivity(intent);
			}
		});
	}

}
