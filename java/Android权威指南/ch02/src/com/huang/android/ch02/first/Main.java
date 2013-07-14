package com.huang.android.ch02.first;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Main extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Log.i("Ch02", "测试输出");
    }
}
