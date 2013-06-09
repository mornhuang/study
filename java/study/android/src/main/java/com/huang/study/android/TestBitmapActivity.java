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
		Log.i(LogUtil._CLASS_(), LogUtil._FUNC_());
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.l02_bitmap);
		
		myImageView = (ImageView)findViewById(R.id.l0200_imageView);
		
		Resources r = getResources();
		Drawable d = r.getDrawable(R.drawable.d07_moto);
		
		myImageView.setImageDrawable(d);
	}

}
