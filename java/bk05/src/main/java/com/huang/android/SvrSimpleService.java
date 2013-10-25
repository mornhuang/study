package com.huang.android;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by User : Morn
 * Created DateTime: 13-6-30 下午8:26
 */
public class SvrSimpleService extends Service {
    public static final String MY_SIMPLE_SERVICE = "com.huang.android.MY_SIMPLE_SERVICE";

    public IBinder onBind(Intent intent) {
        Toast.makeText(SvrSimpleService.this, "onBind...........", Toast.LENGTH_LONG).show();
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(SvrSimpleService.this, "onCreate...........", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Toast.makeText(SvrSimpleService.this, "onStart...........", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(SvrSimpleService.this, "onDestory...........", Toast.LENGTH_LONG).show();
    }
}
