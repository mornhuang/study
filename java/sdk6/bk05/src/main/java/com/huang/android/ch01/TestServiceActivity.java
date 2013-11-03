package com.huang.android.ch01;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.huang.android.R;

/**
 * Created by User : Morn
 * Created DateTime: 13-6-30 下午8:49
 */
public class TestServiceActivity extends Activity {
    private Button startBtn, stopBtn, bindBtn, unbindBtn;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l19_service);

        startBtn = (Button) findViewById(R.id.l1900_button);
        stopBtn = (Button) findViewById(R.id.l1901_button);
        bindBtn = (Button) findViewById(R.id.l1902_button);
        unbindBtn = (Button) findViewById(R.id.l1903_button);

        startBtn.setOnClickListener(startListener);
        stopBtn.setOnClickListener(stopListener);
        bindBtn.setOnClickListener(bindListener);
        unbindBtn.setOnClickListener(unbindListener);
    }

    private View.OnClickListener startListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setAction(SvrSimpleService.MY_SIMPLE_SERVICE);
            startService(intent);
        }
    };

    private View.OnClickListener stopListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setAction(SvrSimpleService.MY_SIMPLE_SERVICE);
            stopService(intent);
        }
    };

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Toast.makeText(TestServiceActivity.this, "连接成功.....", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Toast.makeText(TestServiceActivity.this, "断开连接.....", Toast.LENGTH_LONG).show();
        }
    };

    private View.OnClickListener bindListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setAction(SvrSimpleService.MY_SIMPLE_SERVICE);
            bindService(intent, conn, Service.BIND_AUTO_CREATE);
        }
    };

    private View.OnClickListener unbindListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setAction(SvrSimpleService.MY_SIMPLE_SERVICE);
            unbindService(conn);
        }
    };
}