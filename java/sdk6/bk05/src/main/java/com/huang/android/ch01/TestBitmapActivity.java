package com.huang.android.ch01;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import com.huang.android.R;

public class TestBitmapActivity extends Activity {
    private ImageView myImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l02_bitmap);

        myImageView = (ImageView) findViewById(R.id.l0200_imageView);

        Resources r = getResources();
        Drawable d = r.getDrawable(R.drawable.d07_moto);

        myImageView.setImageDrawable(d);
    }

}
