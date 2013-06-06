package com.huang.study.android;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class TestBitmapActivity extends Activity {
	private ImageView myImageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(LogUtil._FILE_(), LogUtil._FUNC_());
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_bitmap);
		
		myImageView = (ImageView)findViewById(R.id.imageView302);
		
		Resources r = getResources();
		Drawable d = r.getDrawable(R.drawable.moto);
		
		myImageView.setImageDrawable(d);
	}

}
