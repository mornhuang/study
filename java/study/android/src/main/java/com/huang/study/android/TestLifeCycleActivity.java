package com.huang.study.android;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Created by User : Morn
 * Created DateTime: 13-6-24 下午4:17
 */
public class TestLifeCycleActivity extends Activity {
    private final String TAG = "测试生命周期";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.l17_lifecycle);
        Log.i(TAG, "OnCreate--------------->");

        findViewById(R.id.l1701_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestLifeCycleActivity.this.finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"OnStart-------------->");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "OnRestart------------>");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "OnPause-------------->");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "OnResume-------------->");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "OnStop---------------->");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "OnDestroy-------------->");
    }

}