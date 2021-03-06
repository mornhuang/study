package com.huang.android.ch01;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.*;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.huang.android.R;

public class TestMenuActivity extends Activity {
	private MenuInflater mi;
	
	private static final int ITEM1 = Menu.FIRST;
	private static final int ITEM2 = Menu.FIRST + 1;
	private static final int ITEM3 = Menu.FIRST + 2;
	
	private TextView myTV;
	
	private Button btn1;
	private Button btn2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.l07_menu);
		
		mi = new MenuInflater(this);
		
		myTV = (TextView)findViewById(R.id.l0700_menuTextView);
		registerForContextMenu(myTV);
		
		btn1 = (Button)findViewById(R.id.l0701_button);
		btn2 = (Button)findViewById(R.id.l0702_button);
		
		final int l = Toast.LENGTH_LONG;
		final int s = Toast.LENGTH_SHORT;
		final String sl = "让我多显示会";
		final String ss = "让我少显示会";
		
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast t1 = Toast.makeText(getApplicationContext(), sl, l);
				t1.show();
			}
		});
		
		btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast t2 = Toast.makeText(getApplicationContext(), ss, s);
				t2.show();
			}
		});
		
		
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		menu.add(0, ITEM1, 0, "红色背景");
		menu.add(0, ITEM2, 0, "绿色背景");
		menu.add(0, ITEM3, 0, "白色背景");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		mi.inflate(R.menu.m01_menu, menu);
		return true;
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case R.id.about:
			aboutAlert("演示菜单");
			break;
		case R.id.exit:
			exitAlert("真的退出？");
			break;
		}
		return true;
	}

	private void exitAlert(String msg) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		
		builder.setMessage(msg)
			.setCancelable(false)
			.setPositiveButton("确定", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					finish();
				}
			})
			.setNegativeButton("取消", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					return;
				}
			}); 
		
		AlertDialog alert = builder.create();
		
		alert.show();
	}

	private void aboutAlert(String msg) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		
		builder.setMessage(msg)
			.setCancelable(false)
			.setPositiveButton("确定", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					return;
				}
			});
		
		AlertDialog dialog = builder.create();
		dialog.show();
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case ITEM1:
			myTV.setBackgroundColor(Color.RED);
			break;
		case ITEM2:
			myTV.setBackgroundColor(Color.GREEN);
			break;
		case ITEM3:
			myTV.setBackgroundColor(Color.WHITE);
			break;
		}
		
		return true;
	}

}
